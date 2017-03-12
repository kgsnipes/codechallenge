package com.codechallenge.services;

import com.codechallenge.exception.InvalidProductException;

public interface PricingService {
	
	public Float getPriceForProduct(Long id)throws InvalidProductException,InterruptedException;

}
