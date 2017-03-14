package com.codechallenge.services;

import com.codechallenge.exception.InvalidProductException;
import com.codechallenge.exception.OutOfStockException;
/* this interface defines the methods for the stock related operations required for this application */
public interface StockService {
	
	public Integer getCurrentStockForProduct(Long id) throws InterruptedException,InvalidProductException;
	
	public void reduceStockForProduct(Long id,Integer qty);

}
