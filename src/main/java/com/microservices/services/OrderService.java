package com.microservices.services;

import java.util.Collection;

import com.microservices.dto.PlaceOrderRequest;
import com.microservices.dto.PlaceOrderResponse;
import com.microservices.models.Order;
import com.microservices.models.OrderStatus;
/* this interface defines the methods for the order relation operations required for this application */
public interface OrderService {
	
	public PlaceOrderResponse placeOrder(PlaceOrderRequest request);
	
	public Order getOrderByOrderId(Long orderId);
	
	public Order createOrder(Order order);
	
	public Order saveOrder(Order order);
	
	public Collection<Order> getOrderByOrderStatus(OrderStatus orderStatus,Integer page);

}
