package com.ecommerce.ejadaproject.shopservice.exceptions;

public class ProductOutOfStockException extends Exception {
    public ProductOutOfStockException(String message) {
        super(message);
    }
}
