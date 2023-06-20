package com.ecommerce.ejadaproject.shopservice.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ecommerce.ejadaproject.shopservice.dto.PaymentDto;
import com.ecommerce.ejadaproject.shopservice.models.Transaction;
import com.ecommerce.ejadaproject.shopservice.models.Wallet;

@FeignClient(name="wallet-service")
public interface WalletProxy {

	 @GetMapping("/wallet-service/wallets/users/{userId}")
	    public ResponseEntity<Long> getWalletIdByUserId(@PathVariable Long userId) ;
	 
	 @PostMapping("/wallet-service/transactions")
	    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction);
	 
	 
	    @GetMapping("/wallet-service/wallets/user/{userId}")
	    public ResponseEntity<Wallet> getWalletByUserId(@PathVariable Long userId);
	    
	    @PostMapping("/wallet-service/transactions/dto")
	    public ResponseEntity<Transaction> createTransaction(@RequestBody PaymentDto paymentDto) ;
	
}
