  package com.flipkartclone.payments.service;

import java.util.List;
import java.util.Optional;
import com.flipkartclone.payments.model.Payment;

public interface PaymentService {
    
	public Payment addNewPayment(Payment payment) ;

	public List<Payment> getAllPayments();

	public Optional<Payment> getByPaymentId(int paymentId);

	public void deletePaymentByPaymentId(int paymentId);

	
}
