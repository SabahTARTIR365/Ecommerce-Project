package com.ecommerce.ejadaproject.walletservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.ejadaproject.walletservice.dto.PaymentDto;
import com.ecommerce.ejadaproject.walletservice.models.Transaction;
import com.ecommerce.ejadaproject.walletservice.repository.TransactionRepository;

@Service
public class TransactionService {
    @Autowired
    private final TransactionRepository transactionRepository;
    @Autowired
    private  WalletService walletService ;


    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction getTransactionById(Long id) {
        return transactionRepository.findById(id).orElse(null);
    }
    
    public Transaction createTransactionWithPaymentDto(PaymentDto paymentDto) {
    	Transaction transaction = new Transaction();
    	transaction.setUserId(paymentDto.getUserId());
    	transaction.setAmount(paymentDto.getTotal());
    	transaction.setType(paymentDto.getTransactionType());
    	transaction.setWallet(walletService.getWalletByUserId(paymentDto.getUserId()));
    
    	//set here data
    	walletService.processTransaction(transaction);
        return transactionRepository.save(transaction);
    }

    public Transaction createTransaction(Transaction transaction) {
    	transaction.setWallet(walletService.getWalletByUserId(transaction.getUserId()));
    	walletService.processTransaction(transaction);
        return transactionRepository.save(transaction);
    }



	public Transaction updateTransaction(Long id, Transaction transaction) {
        Transaction existingTransaction = transactionRepository.findById(id).orElse(null);
        if (existingTransaction != null) {
          //  existingTransaction.setWalletId(transaction.getWalletId());
            existingTransaction.setUserId(transaction.getUserId());
            existingTransaction.setType(transaction.getType());
            existingTransaction.setAmount(transaction.getAmount());
            return transactionRepository.save(existingTransaction);
        }
        return null;
    }

    public boolean deleteTransaction(Long id) {
        Transaction existingTransaction = transactionRepository.findById(id).orElse(null);
        if (existingTransaction != null) {
            transactionRepository.delete(existingTransaction);
            return true;
        }
        return false;
    }
}
