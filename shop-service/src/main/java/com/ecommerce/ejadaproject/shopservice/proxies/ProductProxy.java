package com.ecommerce.ejadaproject.shopservice.proxies;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.ecommerce.ejadaproject.shopservice.models.Product;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;


@FeignClient(name="inventory-service", fallback=ProductProxyFallback.class)//here fall back 
public interface ProductProxy {
	
	
	@CircuitBreaker(name = "inventoryCircuitBreaker")
    @GetMapping("/inventory-service/api/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) ;
    
	@CircuitBreaker(name = "inventoryCircuitBreaker")
    @PutMapping("/inventory-service/api/products/{productId}/quantity/{quantityToSubtract}")
    public ResponseEntity<String> updateProductQuantity(
            @PathVariable Long productId,
            @PathVariable int quantityToSubtract);
	
	

}
