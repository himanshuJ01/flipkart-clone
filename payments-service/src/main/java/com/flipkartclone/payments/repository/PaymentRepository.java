package com.flipkartclone.payments.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.flipkartclone.payments.model.Payment;

public interface PaymentRepository extends MongoRepository<Payment, Integer> {
	
	

}
