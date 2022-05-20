package com.flipkartclone.orders.service;

import java.util.List;
import java.util.Optional;

import com.flipkartclone.orders.common.TransactionRequest;
import com.flipkartclone.orders.common.TransactionResponse;
import com.flipkartclone.orders.model.Order;

public interface OrderService {
     public TransactionResponse addNewOrder(TransactionRequest request);
     public List<Order> getAllOrders();
     public Optional<Order> getByOrderId(int orderId);
     public void deleteOrderByOrderId(int orderId);
}
