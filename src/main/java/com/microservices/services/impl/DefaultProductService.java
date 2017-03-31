package com.microservices.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;

import com.microservices.exception.InvalidProductException;
import com.microservices.models.Product;
import com.microservices.repository.ProductRepository;
import com.microservices.services.ProductService;

public class DefaultProductService implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	@Cacheable(value="productcache", key="#id")
	public Product getProductById(Long id) {
		// TODO Auto-generated method stub
		return productRepository.findOne(id);
	}

	@Override
	@Cacheable(value="productcache", key="#name")
	public Product getProductByName(String name) {
		return productRepository.findByName(name);
	}

	@Override
	@Transactional
	@CacheEvict(value = "productcache", allEntries = true)
	public void removeProducts(List<Product> products) {
		productRepository.delete(products);
		
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return (List<Product>) productRepository.findAll();
	}

	@Override
	@Cacheable(value = "productcache", key="#product.name")
	@Transactional
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	@Transactional(readOnly=true)
	public Product getProductRealTimeById(Long id) throws InvalidProductException {
		return productRepository.findOne(id);
	}

}
