package com.codechallenge.services;

import com.codechallenge.exception.InvalidProductException;
import com.codechallenge.models.Order;

public interface CalculationService  {
	
	public Order calculateOrder(Order order)throws InvalidProductException, InterruptedException;

}
