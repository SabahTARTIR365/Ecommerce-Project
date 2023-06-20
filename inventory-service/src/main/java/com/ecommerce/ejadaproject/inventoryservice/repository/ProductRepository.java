package com.ecommerce.ejadaproject.inventoryservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.ejadaproject.inventoryservice.beans.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}

