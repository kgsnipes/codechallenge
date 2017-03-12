package com.codechallenge.services;

import com.codechallenge.exception.OutOfStockException;

public interface StockService {
	
	public Integer getCurrentStockForProduct(Long id) throws InterruptedException,OutOfStockException;
	
	public void reduceStockForProduct(Long id,Integer qty);

}
