package com.ecommerce.ejadaproject.shopservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.ejadaproject.shopservice.models.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    
}
