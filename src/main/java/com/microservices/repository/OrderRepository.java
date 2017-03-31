package com.microservices.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.microservices.models.Order;
import com.microservices.models.OrderStatus;
/* this interface uses the Spring JPA CRUD repository to add the crud functionality and also allows to add custom methods to fetch data */
@Repository
public interface OrderRepository extends PagingAndSortingRepository<Order, Long> {
	
	public Order findOne(Long id);
	
	public List<Order> findByStatus(OrderStatus status,Pageable pageable);
   
}