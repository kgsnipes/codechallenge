package com.microservices.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.microservices.models.Product;
/* this interface uses the Spring JPA CRUD repository to add the crud functionality and also allows to add custom methods to fetch data */
@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	
    Product findByName(String name);
	
	Product findById(Long id);
}