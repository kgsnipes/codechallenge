package com.codechallenge.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codechallenge.models.OrderEntry;
/* this interface uses the Spring JPA CRUD repository to add the crud functionality and also allows to add custom methods to fetch data */
@Repository
public interface OrderEntryRepository extends CrudRepository<OrderEntry, Long> {
	
	public OrderEntry findOne(Long id);
	
	
   
}