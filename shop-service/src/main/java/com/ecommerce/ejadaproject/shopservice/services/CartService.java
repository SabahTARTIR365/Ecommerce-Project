package com.ecommerce.ejadaproject.shopservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.ejadaproject.shopservice.exceptions.ProductOutOfStockException;
import com.ecommerce.ejadaproject.shopservice.models.Cart;
import com.ecommerce.ejadaproject.shopservice.models.CartItem;
import com.ecommerce.ejadaproject.shopservice.models.Product;
import com.ecommerce.ejadaproject.shopservice.proxies.ProductProxy;
import com.ecommerce.ejadaproject.shopservice.repositories.CartRepository;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;
    
    @Autowired
    ProductProxy productProxy;
    @Autowired
    CartItemService cartItemService;

    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    public Cart getCartById(Long id) {
        return cartRepository.findById(id).orElse(null);
    }

    Cart getCartByUserId(Long userId) {
    	
    	 return cartRepository.findByUserId(userId);
    	
    }
    public Cart createCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public Cart updateCart(Long id, Cart cart) {
        Cart existingCart = cartRepository.findById(id).orElse(null);
        if (existingCart != null) {
            cart.setId(id);
            return cartRepository.save(cart);
        }
        return null;
    }

    public boolean deleteCart(Long id) {
        if (cartRepository.existsById(id)) {
            cartRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Cart addItemToCart(Long cartId, CartItem cartItem) throws ProductOutOfStockException {
        Cart cart = cartRepository.findById(cartId).orElse(null);
        if (cart != null) {
        	
        	cartItem.setCart(cart);
        	//cartItemService.createCartItem(cartItem);
          List<CartItem> newCartItems= cart.getItems();
         Product currentProduct=productProxy.getProductById(cartItem.getProductId()).getBody();
         if (currentProduct.getQuantity()>0)
         { newCartItems.add(cartItem);
        	cart.setItems(newCartItems);
           // cartItemService.createCartItem(cartItem);
            return cartRepository.save(cart);}
         
         else {throw new ProductOutOfStockException("Product is out of stock");}
        }
        return null;
    }

    public Cart removeItemFromCart(Long cartId, Long itemId) {
        Cart cart = cartRepository.findById(cartId).orElse(null);
        if (cart != null) {
           cartItemService.deleteCartItem(itemId);
            cart.getItems().removeIf(item -> item.getId().equals(itemId));
            
          
            return cartRepository.save(cart);
        }
        return null;
    }
    
    
    public double getTotalPrice(Long cartId) throws Exception {
        return cartRepository.findById(cartId).map(cart -> {
            double totalPrice = 0.0;
            double cartItemPrice=0.0;
            
            for (CartItem cartItem : cart.getItems()) {
           Product product =productProxy.getProductById(cartItem.getProductId()).getBody();
           System.out.println("Product--------------");
           System.out.println(product);
        	cartItemPrice=product.getPrice();
                totalPrice +=  cartItemPrice* cartItem.getQuantity();
            }
            return totalPrice;
        }).orElseThrow(() -> new Exception("Cart not found"));
    }

}

