package com.codechallenge.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.codechallenge.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	@Transactional(readOnly=true)
    Product findByName(String name);
}