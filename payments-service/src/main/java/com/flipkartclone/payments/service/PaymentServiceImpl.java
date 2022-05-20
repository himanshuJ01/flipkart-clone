package com.flipkartclone.payments.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flipkartclone.payments.model.Payment;
import com.flipkartclone.payments.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService {
	
	private PaymentRepository paymentrepo;
	
	@Autowired
	public PaymentServiceImpl(PaymentRepository paymentrepo) {
		super();
		this.paymentrepo = paymentrepo;
	}

	@Override
	public Payment addNewPayment(Payment payment) {
		
        payment.setPaymentStatus(paymentProcessing());
        payment.setTransactionId(UUID.randomUUID().toString());
		Payment saveCutomer = paymentrepo.save(payment);
		return saveCutomer;
	}

	@Override
	public List<Payment> getAllPayments() {
		// TODO Auto-generated method stub
		return (List<Payment>) paymentrepo.findAll();
	}

	@Override
	public Optional<Payment> getByPaymentId(int paymentId) {
		// TODO Auto-generated method stub
		return (Optional<Payment>) paymentrepo.findById(paymentId);
	}

	@Override
	public void deletePaymentByPaymentId(int paymentId) {
		// TODO Auto-generated method stub
		paymentrepo.deleteById(paymentId);
	}
	
	public String paymentProcessing() {
		//api should be third party gateway....
		
		return new Random().nextBoolean()?"success":"false";
	}

 
}
