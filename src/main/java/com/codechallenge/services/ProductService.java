package com.codechallenge.services;

import java.util.List;

import com.codechallenge.models.Product;

public interface ProductService {
	
	public Product getProductById(Long id);
	
	public Product getProductByName(String name);
	
	public List<Product> getAllProducts();
	
	public void removeProducts(List<Product> products);
	

}
