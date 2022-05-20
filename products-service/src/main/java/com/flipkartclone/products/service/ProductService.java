package com.flipkartclone.products.service;

import java.util.List;
import java.util.Optional;

import com.flipkartclone.products.exception.ProductAlreadyExistException;
import com.flipkartclone.products.model.Product;
import com.flipkartclone.products.model.ProductToCart;

public interface ProductService {
	
	public Product addNewProduct(Product pro) throws ProductAlreadyExistException;

	public List<Product> getAllProducts();

	public Optional<Product> getByProductId(int proId);

	public List<Product> getProductByType(String proType);

	public List<Product> getProductByCategory(String proCategory);
	
	public List<Product> getProductByName(String proName);

	public void deleteProductByProductId(int proId);
	
	public ProductToCart addProductToCart(ProductToCart proToCart);
	
	//public Product updateProducts(Product);

}
