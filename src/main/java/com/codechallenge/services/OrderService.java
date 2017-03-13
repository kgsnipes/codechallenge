package com.codechallenge.services;

import java.util.Collection;

import com.codechallenge.dto.PlaceOrderRequest;
import com.codechallenge.dto.PlaceOrderResponse;
import com.codechallenge.models.Order;
import com.codechallenge.models.OrderStatus;

public interface OrderService {
	
	public PlaceOrderResponse placeOrder(PlaceOrderRequest request);
	
	public Order getOrderByOrderId(Long orderId);
	
	public Order createOrder(Order order);
	
	public Order saveOrder(Order order);
	
	public Collection<Order> getOrderByOrderStatus(OrderStatus orderStatus,Integer page);

}
