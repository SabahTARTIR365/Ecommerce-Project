package com.ecommerce.ejadaproject.shopservice.proxies;

import org.springframework.http.ResponseEntity;

import com.ecommerce.ejadaproject.shopservice.models.Product;

public class ProductProxyFallback implements ProductProxy {

	@Override
	public ResponseEntity<Product> getProductById(Long id) {
		 return ResponseEntity.ok(new Product());
	}

	@Override
	public ResponseEntity<String> updateProductQuantity(Long productId, int quantityToSubtract) {
		// TODO Auto-generated method stub
		 return ResponseEntity.ok("Fallback response");
	}


}
