package com.ecommerce.ejadaproject.walletservice.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecommerce.ejadaproject.walletservice.models.Wallet;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {
    @Query("SELECT w.id FROM Wallet w WHERE w.userId = :userId")
    Long findWalletIdByUserId(@Param("userId") Long userId);
    
    Wallet findByUserId(Long userId);
}