package com.flipkartclone.orders.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.flipkartclone.orders.common.Payment;
import com.flipkartclone.orders.common.TransactionRequest;
import com.flipkartclone.orders.common.TransactionResponse;
import com.flipkartclone.orders.model.Order;
import com.flipkartclone.orders.repository.OrderRepository;


@Service
public class OrderServiceImpl implements OrderService {
   
	@Autowired
	private OrderRepository orderrepo;
	
	@Autowired
	private RestTemplate template; 
	
   
	@Override
	public TransactionResponse addNewOrder(TransactionRequest request) {
		String response = "";
		Order order = request.getOrder();
		Payment payment = request.getPayment();
		payment.setOrderId(order.getOrderId());
		payment.setAmount(order.getOrderTotal());
		
	Payment paymentResponse	= template.postForObject("http://localhost:9093/payment/addPayment", payment, Payment.class);
		
		response=paymentResponse.getPaymentStatus().equals("success")? "payment processing successful and order placed":" there is a failure in payment api , order added to cart"; 
		orderrepo.save(order);
		return new TransactionResponse(order, paymentResponse.getAmount(), paymentResponse.getTransactionId(), response);
	}

	@Override
	public List<Order> getAllOrders() {
		return (List<Order>) orderrepo.findAll();
	}

	@Override
	public Optional<Order> getByOrderId(int orderId) {
		return (Optional<Order>) orderrepo.findById(orderId);
	}

	@Override
	public void deleteOrderByOrderId(int orderId) {
		orderrepo.deleteById(orderId);
	}
	
	
	
	
}
