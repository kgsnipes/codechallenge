package com.codechallenge.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.codechallenge.models.OrderEntry;
import com.codechallenge.repository.OrderEntryRepository;
import com.codechallenge.services.OrderEntryService;

public class DefaultOrderEntryService implements OrderEntryService {

	@Autowired
	private OrderEntryRepository orderEntryRepository;
	
	@Override
	public OrderEntry saveOrderEntry(OrderEntry orderEntry) {
		// TODO Auto-generated method stub
		return orderEntryRepository.save(orderEntry);
	}

}
