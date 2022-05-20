package com.flipkartclone.products.controller;

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

import com.flipkartclone.products.exception.ProductAlreadyExistException;
import com.flipkartclone.products.model.Product;
import com.flipkartclone.products.model.ProductToCart;
import com.flipkartclone.products.service.ProductService;


@RestController
@RequestMapping("/product")

public class ProductController {

	
	    @Autowired
		private ProductService proserv;
			
		
		@PostMapping("/addproduct")
		public ResponseEntity<Product> addNewProduct(@RequestBody Product pro ) throws ProductAlreadyExistException{
			
			Product savedProduct = proserv.addNewProduct(pro);
			return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
		}
		
		
		
		@GetMapping("/allproducts")
		public ResponseEntity<List<Product>> getAllProducts(){
			return new ResponseEntity<List<Product>>((List<Product>)proserv.getAllProducts(), HttpStatus.OK);
		}
		
		@GetMapping("/allproducts/{productType}")
		public ResponseEntity<List<Product>> getAllProductsByProductType(@PathVariable String productType){
			return new ResponseEntity<List<Product>>((List<Product>)proserv.getProductByType(productType), HttpStatus.OK);
		}
		@GetMapping("/allproducts/{productCategory}")
		public ResponseEntity<List<Product>> getAllProductsByProductCategory(@PathVariable String productCategory){
			return new ResponseEntity<List<Product>>((List<Product>)proserv.getProductByType(productCategory), HttpStatus.OK);
		}
		
		@GetMapping("/allproducts/{productName}")
		public ResponseEntity<List<Product>> getAllProductsByProductName(@PathVariable String productType){
			return new ResponseEntity<List<Product>>((List<Product>)proserv.getProductByType(productType), HttpStatus.OK);
		}
		
		
		@DeleteMapping("/del/{productId}")
		public ResponseEntity<Void> deleteProductByProductId(@PathVariable int productId){
	    proserv.deleteProductByProductId(productId);
			return ResponseEntity.noContent().build();
		}
		
		@PostMapping("/addProductToCart/{productId}")
		public ResponseEntity<ProductToCart> addProductToCart(@RequestBody ProductToCart productToCart ) {
			
			ProductToCart savedProductToCart = proserv.addProductToCart(productToCart);
			return new ResponseEntity<>(savedProductToCart, HttpStatus.CREATED);
		}
		
		
	
}
