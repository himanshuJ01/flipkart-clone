package com.flipkartclone.orders.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flipkartclone.orders.common.TransactionRequest;
import com.flipkartclone.orders.common.TransactionResponse;
import com.flipkartclone.orders.model.Order;
import com.flipkartclone.orders.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderService orderservice;
	
	

	@PostMapping("/addOrder")
	public TransactionResponse addNewOrder(@RequestBody TransactionRequest request) {

		
		
		return orderservice.addNewOrder(request);
	}

	@GetMapping("/orders")
	public ResponseEntity<List<Order>> getAllCustomers() {
		return new ResponseEntity<List<Order>>((List<Order>) orderservice.getAllOrders(), HttpStatus.OK);
	}

	@DeleteMapping("/del/{orderId}")
	public ResponseEntity<Void> deleteOrderById(@PathVariable int customerId) {
		orderservice.deleteOrderByOrderId(customerId);
		return ResponseEntity.noContent().build();
	}

}
