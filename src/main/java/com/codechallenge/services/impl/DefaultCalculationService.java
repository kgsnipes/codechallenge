package com.codechallenge.services.impl;

import java.math.BigDecimal;

import com.codechallenge.models.Order;
import com.codechallenge.models.OrderEntry;
import com.codechallenge.services.CalculationService;

public class DefaultCalculationService implements CalculationService {

	@Override
	public Order calculateOrder(Order order) {
		BigDecimal totalPrice=new BigDecimal(0.0);
		for(OrderEntry entry:order.getOrderEntries())
		{
			BigDecimal orderEntryTotalPrice=new BigDecimal(entry.getUnitPrice()*entry.getQty());
			totalPrice.add(orderEntryTotalPrice);
		}
		order.setTotalPrice(totalPrice.floatValue());
		return order;
	}

}
