package com.microservices.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.microservices.models.OrderEntry;
import com.microservices.repository.OrderEntryRepository;
import com.microservices.services.OrderEntryService;

public class DefaultOrderEntryService implements OrderEntryService {

	@Autowired
	private OrderEntryRepository orderEntryRepository;
	
	@Override
	public OrderEntry saveOrderEntry(OrderEntry orderEntry) {
		// TODO Auto-generated method stub
		return orderEntryRepository.save(orderEntry);
	}

}
