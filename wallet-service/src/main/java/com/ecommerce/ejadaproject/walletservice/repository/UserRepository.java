package com.ecommerce.ejadaproject.walletservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ecommerce.ejadaproject.walletservice.models.User;

//@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	 @Query("SELECT u FROM User u WHERE u.email = ?1")
	User findByEmail(String email);
}

