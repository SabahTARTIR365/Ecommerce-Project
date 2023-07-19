package com.ecommerce.ejadaproject.walletservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.ejadaproject.walletservice.dto.TransactionDto;
import com.ecommerce.ejadaproject.walletservice.exceptions.WalletNotFoundException;
import com.ecommerce.ejadaproject.walletservice.models.Transaction;
import com.ecommerce.ejadaproject.walletservice.models.TransactionType;
import com.ecommerce.ejadaproject.walletservice.models.Wallet;
import com.ecommerce.ejadaproject.walletservice.repository.WalletRepository;

@Service
public class WalletService {
	  @Autowired
    private final WalletRepository walletRepository;

    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public List<Wallet> getAllWallets() {
        return walletRepository.findAll();
    }

    public Wallet getWalletById(Long id) {
        return walletRepository.findById(id).orElse(null);
    }

    public Wallet createWallet(Wallet wallet) {
        return walletRepository.save(wallet);
    }

    public Wallet updateWallet(Long id, Wallet wallet) {
        Wallet existingWallet = walletRepository.findById(id).orElse(null);
        if (existingWallet != null) {
            existingWallet.setUserId(wallet.getUserId());
            existingWallet.setBalance(wallet.getBalance());
            existingWallet.setTransactions(wallet.getTransactions());
            return walletRepository.save(existingWallet);
        }
        return null;
    }

    public boolean deleteWallet(Long id) {
        Wallet existingWallet = walletRepository.findById(id).orElse(null);
        if (existingWallet != null) {
            walletRepository.delete(existingWallet);
            return true;
        }
        return false;
    }
    
    public Wallet getWalletByUserId(Long userId) {
        return walletRepository.findByUserId(userId);
    }
    public Long getWalletIdByUserId(Long userId) {
        return walletRepository.findWalletIdByUserId(userId);
    }
   
  
   /* public synchronized void processTransaction(Transaction transaction) {
        double amount = transaction.getAmount();
        TransactionType type = transaction.getType();
        
       Long walletId= walletRepository.findWalletIdByUserId(transaction.getUserId());
        Wallet wallet = walletRepository.findById(walletId).orElse(null);
        if (wallet != null) {
            double currentBalance =wallet.getBalance(); //getWalletBalanceByTransaction(wallet);
            double updatedBalance=0.0;

            if (type == TransactionType.DEPOSIT) {
                updatedBalance = currentBalance + amount;
            } else if (type == TransactionType.WITHDRAW) {
            	if(currentBalance>amount)
            	{ updatedBalance = currentBalance - amount;}//else through exception not enough amount
            } 

            wallet.setBalance(updatedBalance);
            walletRepository.save(wallet);
        }
    }
    */
    
    public synchronized void processTransaction(Transaction transaction) {
        double amount = transaction.getAmount();
        TransactionType type = transaction.getType();

        Long walletId = walletRepository.findWalletIdByUserId(transaction.getUserId());
        Wallet wallet = walletRepository.findById(walletId).orElse(null);

        if (wallet != null) {
            double currentBalance = wallet.getBalance();
            TransactionDto transactionDto =new TransactionDto(currentBalance,amount, type);	
            double updatedBalance = calculateUpdatedBalance(transactionDto);
            wallet.setBalance(updatedBalance);
            walletRepository.save(wallet);
        }
    }

    private double calculateUpdatedBalance(  TransactionDto transactionDto) {
    	//double currentBalance, double amount, TransactionType type) {
    
        switch (transactionDto.getType()) {
            case DEPOSIT:
                return transactionDto.getBalance() + transactionDto.getAmount();
            case WITHDRAW:
                if (transactionDto.getBalance() >= transactionDto.getAmount()) {
                    return transactionDto.getBalance() - transactionDto.getAmount();
                } else {
                    throw new IllegalArgumentException("Not enough amount in the wallet.");
                }
            default:
                throw new IllegalArgumentException("Invalid transaction type.");
        }
    }

    
    public List<Transaction> getTransactionHistory(Long walletId) {
        Optional<Wallet> walletOptional = walletRepository.findById(walletId);
        if (walletOptional.isPresent()) {
            Wallet wallet = walletOptional.get();
            return wallet.getTransactions();
        } else {
            throw new WalletNotFoundException("Wallet not found with ID: " + walletId);
        }
    }
}
