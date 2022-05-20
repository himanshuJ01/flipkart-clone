package com.flipkartclone.orders.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.flipkartclone.orders.model.Order;

public interface OrderRepository extends MongoRepository<Order, Integer> {
    
	
}
