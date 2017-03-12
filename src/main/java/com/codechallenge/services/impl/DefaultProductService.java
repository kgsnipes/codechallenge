package com.codechallenge.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;

import com.codechallenge.models.Product;
import com.codechallenge.repository.ProductRepository;
import com.codechallenge.services.ProductService;

public class DefaultProductService implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Product getProductById(Long id) {
		// TODO Auto-generated method stub
		return productRepository.findOne(id);
	}

	@Override
	@Cacheable(value="codechallengecache", key="#name")
	public Product getProductByName(String name) {
		return productRepository.findByName(name);
	}

	@Override
	@Transactional
	public void removeProducts(List<Product> products) {
		productRepository.delete(products);
		
	}

	@Override
	@Transactional(readOnly=true)
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return (List<Product>) productRepository.findAll();
	}

}
