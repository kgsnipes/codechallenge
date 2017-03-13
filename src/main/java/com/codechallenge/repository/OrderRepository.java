package com.codechallenge.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.codechallenge.models.Order;
import com.codechallenge.models.OrderStatus;

@Repository
public interface OrderRepository extends PagingAndSortingRepository<Order, Long> {
	
	public Order findOne(Long id);
	
	public List<Order> findByStatus(OrderStatus status,Pageable pageable);
   
}