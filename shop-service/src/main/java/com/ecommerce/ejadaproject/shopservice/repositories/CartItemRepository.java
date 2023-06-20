package com.ecommerce.ejadaproject.shopservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.ejadaproject.shopservice.models.CartItem;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    // You can add custom query methods here if needed
}
