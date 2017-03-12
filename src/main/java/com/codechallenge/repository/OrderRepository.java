package com.codechallenge.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codechallenge.models.Order;
import com.codechallenge.models.OrderStatus;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
	
	public Order findOne(Long id);
	
	public Collection<Order> findByStatus(OrderStatus status);
   
}