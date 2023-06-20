package com.ecommerce.ejadaproject.shopservice.services;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.ejadaproject.shopservice.dto.PaymentDto;
import com.ecommerce.ejadaproject.shopservice.exceptions.InsufficientAmountException;
import com.ecommerce.ejadaproject.shopservice.models.Cart;
import com.ecommerce.ejadaproject.shopservice.models.CartItem;
import com.ecommerce.ejadaproject.shopservice.models.Order;
import com.ecommerce.ejadaproject.shopservice.models.Payment;
import com.ecommerce.ejadaproject.shopservice.models.TransactionType;
import com.ecommerce.ejadaproject.shopservice.models.Wallet;
import com.ecommerce.ejadaproject.shopservice.proxies.ProductProxy;
import com.ecommerce.ejadaproject.shopservice.proxies.WalletProxy;
import com.ecommerce.ejadaproject.shopservice.repositories.CartItemRepository;
import com.ecommerce.ejadaproject.shopservice.repositories.OrderRepository;
import com.ecommerce.ejadaproject.shopservice.repositories.PaymentRepository;

@Service
public class PaymentService {
	  @Autowired
    private final PaymentRepository paymentRepository;
    
	 /* @Autowired
	    private CartRepository cartRepository;*/
	  @Autowired
	    private CartService cartService;
	  
	  @Autowired
	    private OrderRepository orderRepository;
	  @Autowired
	    private CartItemRepository cartItemRepository;
	  @Autowired 
	  private ProductProxy productProxy;
	    
	  @Autowired
	  private WalletProxy walletProxy;
	  
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Payment getPaymentById(Long id) {
        return paymentRepository.findById(id).orElse(null);
    }

    public Payment createPayment(Payment payment) {
    	processPayment(payment);
        return paymentRepository.save(payment);
    }
    public void processPayment(Payment payment) {
        // Delete cart item list
    	long orderId= payment.getOrderId();
    	Order currentOrder= orderRepository.findById(orderId).orElse(null);
    	long userId=currentOrder.getUserId();
    	//find cart and clear cat items
    	Cart cart = cartService.getCartByUserId(userId);
    	//cart.getItems().clear();
    	//for loop to delete from cart item // need to add cartitem repo
    	List<CartItem> cartItems = cart.getItems();
    	/*
    	for (CartItem cartItem : cartItems) {
    	   // cartItemRepository.delete(cartItem);
    		cartService.removeItemFromCart(cart.getId(),cartItem.getId());
    	}
    	*/
    	
		//update the quanities 
    	for (CartItem cartItem : cartItems) {
    	    // Update the quantities
    	    productProxy.updateProductQuantity(cartItem.getProductId(), cartItem.getQuantity());
    	}

    	Iterator<CartItem> iterator = cartItems.iterator();
    	while (iterator.hasNext()) {
    
    	    CartItem cartItem = iterator.next();

    	    iterator.remove(); // Delete the current item from the list
    	   // cartItemRepository.delete(cartItem); // Delete the item from the database
    	    cartService.removeItemFromCart(cart.getId(),cartItem.getId());
    	}
    	
    	
    	   
    	 	//we need to create request here for PaymentDto to create  transction
    	   //Post a Transaction by transaction proxy 
    	   PaymentDto paymentDto= new PaymentDto( currentOrder.getUserId(),
    			                                     TransactionType.WITHDRAW,
    			                                     currentOrder.getTotal() );
    	   
    	 //check balance 
    	   Wallet wallet= walletProxy.getWalletByUserId(userId).getBody();
    	   if (wallet.getBalance()>=currentOrder.getTotal())
    	   {walletProxy.createTransaction(paymentDto);}
    	   else {throw new InsufficientAmountException("Insufficient amount in the wallet.");}
    


    }
    public Payment updatePayment(Long id, Payment payment) {
        Payment existingPayment = paymentRepository.findById(id).orElse(null);
        if (existingPayment != null) {
            payment.setId(id);
            return paymentRepository.save(payment);
        }
        return null;
    }

    public boolean deletePayment(Long id) {
        Payment existingPayment = paymentRepository.findById(id).orElse(null);
        if (existingPayment != null) {
            paymentRepository.delete(existingPayment);
            return true;
        }
        return false;
    }
}
