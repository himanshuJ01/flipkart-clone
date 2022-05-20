package com.flipkartclone.products.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="ProductToCart")
public class ProductToCart {
     private int customerId ;
     private String fullName;
     private List<Product> product;
     
     ProductToCart() {}

	public ProductToCart(int customerId, String fullName, List<Product> product) {
		super();
		this.customerId = customerId;
		this.fullName = fullName;
		this.product = product;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProducts(List<Product> product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "ProductToCart [customerId=" + customerId + ", fullName=" + fullName + ", product=" + product + "]";
	}
     
     
          
}
