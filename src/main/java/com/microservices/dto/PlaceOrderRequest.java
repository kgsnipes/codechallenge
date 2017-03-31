package com.microservices.dto;

import com.microservices.models.Order;

public class PlaceOrderRequest extends ServiceRequest{
	
	private  Order order;

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}	
	
	

}
