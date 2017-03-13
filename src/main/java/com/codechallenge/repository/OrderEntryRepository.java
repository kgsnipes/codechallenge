package com.codechallenge.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codechallenge.models.OrderEntry;

@Repository
public interface OrderEntryRepository extends CrudRepository<OrderEntry, Long> {
	
	public OrderEntry findOne(Long id);
	
	
   
}