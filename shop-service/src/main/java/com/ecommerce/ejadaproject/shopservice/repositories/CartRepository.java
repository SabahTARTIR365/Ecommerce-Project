package com.ecommerce.ejadaproject.shopservice.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecommerce.ejadaproject.shopservice.models.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    @Query("SELECT c.id FROM Cart c WHERE c.userId = :userId")
    Long findCartIdByUserId(Long userId);
    
    Cart findByUserId(Long userId);
}
