package com.microservices.dto;

import java.util.List;

import com.microservices.models.Product;

public class ProductDataUpload {
	
	private List<Product> products;

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	

}
