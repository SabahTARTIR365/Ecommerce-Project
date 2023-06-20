package com.ecommerce.ejadaproject.walletservice.models;


import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;

@Entity
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    @Transient
    private double balance;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "wallet")
    private List<Transaction> transactions;
 // Constructors
    public Wallet() {}
    public Wallet(Long userId,  List<Transaction> transactions) {
		this.userId = userId;
		//this.balance = balance;
		this.transactions = transactions;
	}
    /*
    @Transactional
    public void updateBalance(double newBalance) {
        // Update the balance in a transactional context
        this.balance = newBalance;
    }*/
	//Getters and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public double getBalance() {
		
         balance = 0.0;
        for (Transaction transaction : transactions) {
            if (transaction.getType() == TransactionType.WITHDRAW) {
                balance -= transaction.getAmount();
            } else if (transaction.getType() == TransactionType.DEPOSIT) {
                balance += transaction.getAmount();
            }
        }

		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

 
    
}

