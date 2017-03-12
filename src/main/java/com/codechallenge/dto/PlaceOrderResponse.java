package com.codechallenge.dto;

import java.util.ArrayList;

import com.codechallenge.models.Order;

public class PlaceOrderResponse extends ServiceResponse {

	private Order order;
	public PlaceOrderResponse() {
		super();
		this.setErrors(new ArrayList<String>());
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	
	
	

}
