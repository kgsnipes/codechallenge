package com.codechallenge.services.impl;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.codechallenge.CodechallengeApplication;
import com.codechallenge.repository.ProductRepository;
import com.codechallenge.services.StockService;

public class DefaultStockService implements StockService {

	private static ReentrantLock lock=new ReentrantLock(true);
	
	@Autowired
	private ProductRepository productRepository;
	
	private static final Logger LOG = LoggerFactory.getLogger(DefaultStockService.class);
	
	@Override
	@Transactional
	public Integer getCurrentStockForProduct(String productName) {
		
		Integer qty=0;
		try
		{
			lock.tryLock(100, TimeUnit.MILLISECONDS);
			qty= productRepository.findByName(productName).getAvailableQuantity();
			
		}
		catch(Exception ex)
		{
			LOG.error("Exception while fetching the current stock", ex);
		}
		finally
		{
			lock.unlock();
		}
		return qty;
	}

}
