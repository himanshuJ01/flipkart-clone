package com.flipkartclone.products.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "productDetails")
public class Product {
	@Id
    private int productId;
	private String productType; 
	private String productName;
	private String category;
	private String description;
	private double price;
	private String specification;
	private String imageUrl ;
	private Double rating;
	
	Product(){}

	public Product(int productId, String productType, String productName, String category, String description,
			double price, String specification, String imageUrl, Double rating) {
		super();
		this.productId = productId;
		this.productType = productType;
		this.productName = productName;
		this.category = category;
		this.description = description;
		this.price = price;
		this.specification = specification;
		this.imageUrl = imageUrl;
		this.rating = rating;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImage(String image) {
		this.imageUrl = image;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productType=" + productType + ", productName=" + productName
				+ ", category=" + category + ", description=" + description + ", price=" + price + ", specification="
				+ specification + ", imageUrl=" + imageUrl + ", rating=" + rating + "]";
	}
	
	
	
	
}
