package com.ecommerce.ejadaproject.shopservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.ejadaproject.shopservice.models.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}