package com.ecommerce.ejadaproject.inventoryservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ecommerce.ejadaproject.inventoryservice.beans.Product;
import com.ecommerce.ejadaproject.inventoryservice.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();//CHECK PAGABLE THING
    }
    	
    public Page<Product> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Optional<Product> updateProduct(Long id, Product product) {
        Optional<Product> existingProduct = productRepository.findById(id);
        if (existingProduct.isPresent()) {
            product.setId(id);
            return Optional.of(productRepository.save(product));
        } else {
            return Optional.empty();
        }
    }

    public boolean deleteProduct(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            productRepository.delete(product.get());
            return true;
        } else {
            return false;
        }
    }
    
    public void updateProductQuantity(Long productId, int quantityToSubtract) {
        // Retrieve the product from the database
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Product not found with ID: " + productId));
        
        // Subtract the given quantity from the current product quantity
        int updatedQuantity = product.getQuantity() - quantityToSubtract;
        
        // Ensure the updated quantity is not negative
        if (updatedQuantity < 0) {
            throw new IllegalArgumentException("Insufficient quantity available for product with ID: " + productId);
        }
        
        // Update the product quantity
        product.setQuantity(updatedQuantity);
        
        // Save the updated product in the database
        productRepository.save(product);
    }
}
