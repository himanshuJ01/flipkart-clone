package com.flipkartclone.products.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.flipkartclone.products.model.ProductToCart;

public interface ProductToCartRepository extends MongoRepository<ProductToCart, Integer> {

}
