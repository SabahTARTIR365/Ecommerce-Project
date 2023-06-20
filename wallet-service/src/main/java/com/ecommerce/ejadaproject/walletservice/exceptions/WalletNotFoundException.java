package com.ecommerce.ejadaproject.walletservice.exceptions;


public class WalletNotFoundException  extends RuntimeException {
    public WalletNotFoundException (String message) {
        super(message);
    }
}
