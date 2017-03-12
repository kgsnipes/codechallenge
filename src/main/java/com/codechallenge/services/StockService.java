package com.codechallenge.services;

import com.codechallenge.exception.InvalidProductException;
import com.codechallenge.exception.OutOfStockException;

public interface StockService {
	
	public Integer getCurrentStockForProduct(Long id) throws InterruptedException,OutOfStockException,InvalidProductException;
	
	public void reduceStockForProduct(Long id,Integer qty);

}
