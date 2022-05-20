package com.flipkartclone.orders.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.*;


@Document(collection="orderDetails")
public class Order {
    @Transient
    public static final String SEQUENCE_NAME = "user_sequence";
	@Id
	private int orderId;
	private int customerId;
	private String orderName;
	@CreatedDate
	private Date orderTime;
	private int quantity;
	private Double orderTotal;
	

	Order() {}


	public Order(int orderId, int customerId, String orderName, Date orderTime, int quantity,
			Double orderTotal) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.orderName = orderName;
		this.orderTime = orderTime;
		this.quantity = quantity;
		this.orderTotal = orderTotal;
	}


	public int getOrderId() {
		return orderId;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	public String getOrderName() {
		return orderName;
	}


	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}


	public Date getOrderTime() {
		return orderTime;
	}


	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public Double getOrderTotal() {
		return orderTotal;
	}


	public void setOrderTotal(Double orderTotal) {
		this.orderTotal = orderTotal;
	}


	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", customerId=" + customerId + ", orderName=" + orderName + ", orderTime="
				+ orderTime + ", quantity=" + quantity + ", orderTotal=" + orderTotal + "]";
	}
    
	
	
}
