package com.ecommerce.ejadaproject.shopservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.ejadaproject.shopservice.helpers.OrderItemConverter;
import com.ecommerce.ejadaproject.shopservice.models.Cart;
import com.ecommerce.ejadaproject.shopservice.models.CartItem;
import com.ecommerce.ejadaproject.shopservice.models.Order;
import com.ecommerce.ejadaproject.shopservice.proxies.ProductProxy;
import com.ecommerce.ejadaproject.shopservice.repositories.CartRepository;
import com.ecommerce.ejadaproject.shopservice.repositories.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    
    @Autowired
    private CartRepository cartRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public Order createOrder(Order order) {
    	Cart cart =cartRepository.findByUserId(order.getUserId());
    	order.setItems(OrderItemConverter.convertToOrderItems(cart.getItems(),order));
    	//maybe there is need to post the cart order
        return orderRepository.save(order);
    }

    public Order updateOrder(Long id, Order order) {
        Order existingOrder = orderRepository.findById(id).orElse(null);
        if (existingOrder != null) {
            order.setId(id);
            return orderRepository.save(existingOrder);
        }
        return null;
        
    }

    public boolean deleteOrder(Long id) {
        Order existingOrder = orderRepository.findById(id).orElse(null);
        if (existingOrder != null) {
            orderRepository.delete(existingOrder);
            return true;
        }
        return false;
    }
    

}