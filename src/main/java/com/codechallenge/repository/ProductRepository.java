package com.codechallenge.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.codechallenge.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	
    Product findByName(String name);
	
	Product findById(Long id);
}