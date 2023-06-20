package com.ecommerce.ejadaproject.shopservice.helpers;

import java.util.ArrayList;
import java.util.List;

import com.ecommerce.ejadaproject.shopservice.models.CartItem;
import com.ecommerce.ejadaproject.shopservice.models.Order;
import com.ecommerce.ejadaproject.shopservice.models.OrderItem;

public class OrderItemConverter {

   static public List<OrderItem> convertToOrderItems(List<CartItem> cartItems, Order order) {
        List<OrderItem> orderItems = new ArrayList<>();

        for (CartItem cartItem : cartItems) {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setProductId(cartItem.getProductId());
            orderItem.setQuantity(cartItem.getQuantity());
            
            orderItems.add(orderItem);
        }

        return orderItems;
    }
}