package com.ecommerce.ejadaproject.walletservice.exceptions;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ErrorDetails {
	private LocalDateTime timestamp;
	private String message;
	private String details;
	public ErrorDetails(LocalDateTime localDateTime, String message, String details) {
		this.timestamp = localDateTime;
		this.message = message;
		this.details = details;
	}
	@Override
	public String toString() {
		return "ErrorDetails [timestamp=" + timestamp + ", message=" + message + ", details=" + details + "]";
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public String getMessage() {
		return message;
	}
	public String getDetails() {
		return details;
	}
	
}
