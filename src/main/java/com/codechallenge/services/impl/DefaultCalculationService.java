package com.codechallenge.services.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;

import com.codechallenge.exception.InvalidProductException;
import com.codechallenge.models.Order;
import com.codechallenge.models.OrderEntry;
import com.codechallenge.services.CalculationService;
import com.codechallenge.services.PricingService;

public class DefaultCalculationService implements CalculationService {

	@Autowired
	private PricingService pricingService;
	
	
	@Override
	public Order calculateOrder(Order order) throws InvalidProductException, InterruptedException {
		BigDecimal totalPrice=new BigDecimal(0.0);
		for(OrderEntry entry:order.getOrderEntries())
		{
			float unitPrice=pricingService.getPriceForProduct(entry.getProduct().getId());
			entry.setUnitPrice(unitPrice);
			BigDecimal orderEntryTotalPrice=new BigDecimal(unitPrice*entry.getQty());
			totalPrice.add(orderEntryTotalPrice);
		}
		order.setTotalPrice(totalPrice.floatValue());
		return order;
	}

}
