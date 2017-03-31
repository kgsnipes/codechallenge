package com.microservices.services.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;

import com.microservices.exception.InvalidProductException;
import com.microservices.models.Order;
import com.microservices.models.OrderEntry;
import com.microservices.services.CalculationService;
import com.microservices.services.PricingService;

public class DefaultCalculationService implements CalculationService {

	@Autowired
	private PricingService pricingService;
	
	
	@Override
	public Order calculateOrder(final Order order) throws InvalidProductException, InterruptedException {
		BigDecimal totalPrice=new BigDecimal(0.0);
		for(OrderEntry entry:order.getOrderEntries())
		{
			float unitPrice=pricingService.getPriceForProduct(entry.getProductId());
			entry.setUnitPrice(unitPrice);
			BigDecimal orderEntryTotalPrice=new BigDecimal(unitPrice*entry.getQty());
			entry.setTotalPrice(orderEntryTotalPrice.floatValue());
			totalPrice=totalPrice.add(orderEntryTotalPrice);
		}
		order.setTotalPrice(totalPrice.floatValue());
		return order;
	}

}
