package com.codechallenge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codechallenge.dto.PlaceOrderRequest;
import com.codechallenge.dto.PlaceOrderResponse;
import com.codechallenge.models.Order;
import com.codechallenge.services.OrderService;

@RestController
public class OrderServiceController {
	
	@Autowired
	private OrderService orderService;
	
	 @RequestMapping(path="/order/placeOrder",method = RequestMethod.POST, produces="application/json", consumes="application/json")
	    public PlaceOrderResponse placeOrder(@RequestBody PlaceOrderRequest placeOrderRequest) {
	        return orderService.placeOrder(placeOrderRequest);
	    }
	 
	 @RequestMapping(path="/order/createOrder",method = RequestMethod.GET, produces="application/json")
	    public Order createOrder() {
	        return orderService.createOrder(new Order());
	    }

}
