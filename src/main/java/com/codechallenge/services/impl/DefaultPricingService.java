package com.codechallenge.services.impl;

import java.util.concurrent.locks.ReentrantLock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.codechallenge.exception.InvalidProductException;
import com.codechallenge.services.PricingService;
import com.codechallenge.services.ProductService;

public class DefaultPricingService implements PricingService {
	
	@Autowired
	private ProductService productService;

	/* defining a re-entrant lock for fair chance of providing lock to any deserving thread. Avoiding the thread starvation due to long running threads. This is better than synchronized keyword */
	private static ReentrantLock lock=new ReentrantLock(true);
	
	@Override
	@Transactional(readOnly=true)
	public Float getPriceForProduct(Long id) throws InvalidProductException, InterruptedException {
		Float price=-1.0f;
		price=productService.getProductRealTimeById(id).getPrice();
		return price;
	}

}
