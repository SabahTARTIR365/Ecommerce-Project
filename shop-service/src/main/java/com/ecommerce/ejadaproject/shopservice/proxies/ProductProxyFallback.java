package com.ecommerce.ejadaproject.shopservice.proxies;

import org.springframework.http.ResponseEntity;

import com.ecommerce.ejadaproject.shopservice.models.Product;

public class ProductProxyFallback implements ProductProxy {
   /* @Override
    public ResponseEntity<Product> getProductByIdFallback(Long id, Throwable throwable) {
        // Return a fallback response or perform alternative logic
        return ResponseEntity.ok(new Product());
    }

    @Override
    public ResponseEntity<String> updateProductQuantityFallback(
            Long productId, int quantityToSubtract, Throwable throwable) {
        // Return a fallback response or perform alternative logic
        return ResponseEntity.ok("Fallback response");
    }
*/
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
