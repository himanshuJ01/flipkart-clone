package com.flipkartclone.orders.common;

import java.time.LocalDateTime;


public class Payment {
    private int paymentId;
    private String transactionId;
    private Double amount;
    private LocalDateTime dateTime;
    private String paymentStatus;
    private int orderId;
    
    Payment(){}

	public Payment(int paymentId, String transactionId, Double amount, LocalDateTime dateTime, String paymentStatus,
			int orderId) {
		super();
		this.paymentId = paymentId;
		this.transactionId = transactionId;
		this.amount = amount;
		this.dateTime = dateTime;
		this.paymentStatus = paymentStatus;
		this.orderId = orderId;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", transactionId=" + transactionId + ", amount=" + amount
				+ ", dateTime=" + dateTime + ", paymentStatus=" + paymentStatus + ", orderId=" + orderId + "]";
	}
    
    
		
}
