package com.codechallenge.services;

import com.codechallenge.exception.InvalidProductException;
import com.codechallenge.models.Order;
/* this interface defines the methods required for the calculation of total based on the prices and other components for an order*/
public interface CalculationService  {
	
	public Order calculateOrder(Order order)throws InvalidProductException, InterruptedException;

}
