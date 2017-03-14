package com.codechallenge.services;

import com.codechallenge.exception.InvalidProductException;
/* this interface defines the methods for the fetching the pricing for a product as required for this application */
public interface PricingService {
	
	public Float getPriceForProduct(Long id)throws InvalidProductException,InterruptedException;

}
