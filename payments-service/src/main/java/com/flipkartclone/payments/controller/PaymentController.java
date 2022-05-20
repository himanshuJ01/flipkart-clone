package com.flipkartclone.payments.controller;

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

import com.flipkartclone.payments.model.Payment;
import com.flipkartclone.payments.service.PaymentService;
import com.flipkartclone.payments.service.SequenceGeneratorService;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	private PaymentService paymentservice;
	
	@Autowired
	private SequenceGeneratorService sgservice;

	@PostMapping("/addPayment")
	public ResponseEntity<Payment> addNewCustomer(@RequestBody Payment payment) {
		payment.setPaymentId(sgservice.getSequenceNumber(Payment.SEQUENCE_NAME));
		Payment savedCustomer = paymentservice.addNewPayment(payment);
		return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
	}
	@GetMapping("/payments")
	public ResponseEntity<List<Payment>> getAllPayments() {
		return new ResponseEntity<List<Payment>>((List<Payment>) paymentservice.getAllPayments(), HttpStatus.OK);
	}

	@DeleteMapping("/del/{customerId}")
	public ResponseEntity<Void> deleteCustomerById(@PathVariable int paymentId) {
		paymentservice.deletePaymentByPaymentId(paymentId);
		return ResponseEntity.noContent().build();
	}
	
	

}
