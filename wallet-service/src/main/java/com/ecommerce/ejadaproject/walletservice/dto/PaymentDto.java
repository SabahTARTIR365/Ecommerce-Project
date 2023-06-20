package com.ecommerce.ejadaproject.walletservice.dto;



import com.ecommerce.ejadaproject.walletservice.models.TransactionType;

public class PaymentDto {
     
	
	private Long userId;
	private TransactionType transactionType;
	private double total;
	
	public PaymentDto() {}
	public PaymentDto(Long userId, TransactionType transactionType, double total) {
		this.userId = userId;
		this.transactionType = transactionType;
		this.total = total;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public TransactionType getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}


}
