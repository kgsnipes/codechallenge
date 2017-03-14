package com.codechallenge.services.impl;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.codechallenge.exception.InvalidProductException;
import com.codechallenge.exception.OutOfStockException;
import com.codechallenge.models.Product;
import com.codechallenge.services.ProductService;
import com.codechallenge.services.StockService;

public class DefaultStockService implements StockService {

	/* defining a re-entrant lock for fair chance of providing lock to any deserving thread. Avoiding the thread starvation due to long running threads. This is better than synchronized keyword */
	private static ReentrantLock lock=new ReentrantLock(true);
	
	@Autowired
	private ProductService productService;
	
	private static final Logger LOG = LoggerFactory.getLogger(DefaultStockService.class);
	
	@Override
	@Transactional(readOnly=true)
	public Integer getCurrentStockForProduct(Long id) throws InterruptedException, InvalidProductException {
		Product product=productService.getProductRealTimeById(id);
	    return product.getAvailableQuantity();
	}

	@Override
	@Transactional
	public void reduceStockForProduct(Long id, Integer qty) {
		
		try
		{/* first try for the lock on the monitor object and see if it returns immediately and if this fails then try for a timed lock to retain the fairness of a thread acquiring a lock*/
			if (lock.tryLock() || lock.tryLock(500, TimeUnit.MILLISECONDS) )
			{
				Product product=productService.getProductRealTimeById(id);
				product.setAvailableQuantity(product.getAvailableQuantity()-qty);	
				productService.createProduct(product);
			}
		}
		catch(Exception ex)
		{
			LOG.error("Exception while fetching the current stock", ex);
		}
		finally
		{
			lock.unlock();
		}
		
	}

}
