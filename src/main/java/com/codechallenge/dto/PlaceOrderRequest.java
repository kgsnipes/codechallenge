package com.codechallenge.dto;

import com.codechallenge.models.Order;

public class PlaceOrderRequest extends ServiceRequest{
	
	private  Order order;

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}	
	
	

}
