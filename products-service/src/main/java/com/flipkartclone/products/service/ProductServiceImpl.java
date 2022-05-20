package com.flipkartclone.products.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flipkartclone.products.exception.ProductAlreadyExistException;
import com.flipkartclone.products.model.Product;
import com.flipkartclone.products.model.ProductToCart;
import com.flipkartclone.products.repository.ProductRepository;
import com.flipkartclone.products.repository.ProductToCartRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository prorepo;
	
	@Autowired
	private ProductToCartRepository productToCartrepo;
	
		

	@Override
	public Product addNewProduct(Product pro) throws ProductAlreadyExistException {
		
		if(prorepo.existsById(pro.getProductId())) {
			throw new ProductAlreadyExistException();
		}

		Product saveCutomer = prorepo.save(pro);
		return saveCutomer;
	}

	@Override
	public List<Product> getAllProducts() {
		return (List<Product>) prorepo.findAll();
	}

	@Override
	public Optional<Product> getByProductId(int proId) {
		return (Optional<Product>) prorepo.findById(proId);
	}

	@Override
	public List<Product> getProductByType(String proType) {
		return (List<Product>) prorepo.findAll();
	}

	@Override
	public List<Product> getProductByCategory(String proCategory) {
		return (List<Product>) prorepo.findAll();
	}

	@Override
	public List<Product> getProductByName(String proName) {
		return (List<Product>) prorepo.findAll();
	}

	@Override
	public void deleteProductByProductId(int proId) {
		prorepo.deleteById(proId);
		
	}


	@Override
	public ProductToCart addProductToCart(ProductToCart productToCart) {
		ProductToCart saveProduct = productToCartrepo.save(productToCart);
		return saveProduct;
	}

}
