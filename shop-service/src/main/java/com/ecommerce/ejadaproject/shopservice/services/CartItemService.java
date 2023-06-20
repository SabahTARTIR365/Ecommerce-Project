package com.ecommerce.ejadaproject.shopservice.services;

import org.springframework.stereotype.Service;

import com.ecommerce.ejadaproject.shopservice.models.CartItem;
import com.ecommerce.ejadaproject.shopservice.repositories.CartItemRepository;

@Service
public class CartItemService {

    private final CartItemRepository cartItemRepository;

    public CartItemService(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    public CartItem getCartItem(Long cartItemId) {
        return cartItemRepository.findById(cartItemId).orElse(null);
    }

    public CartItem createCartItem(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    public CartItem updateCartItem(Long cartItemId, CartItem cartItem) {
        if (cartItemRepository.existsById(cartItemId)) {
            cartItem.setId(cartItemId);
            return cartItemRepository.save(cartItem);
        } else {
            return null;
        }
    }

    public boolean deleteCartItem(Long cartItemId) {
        if (cartItemRepository.existsById(cartItemId)) {
            cartItemRepository.deleteById(cartItemId);
            return true;
        } else {
            return false;
        }
    }
}

