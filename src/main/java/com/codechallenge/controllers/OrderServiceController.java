package com.codechallenge.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codechallenge.dto.PlaceOrderRequest;
import com.codechallenge.dto.PlaceOrderResponse;

@RestController
public class OrderServiceController {
	
	 @RequestMapping(path="/order/placeOrder",method = RequestMethod.POST, produces="application/json", consumes="application/json")
	    public PlaceOrderResponse placeOrder(@RequestBody PlaceOrderRequest placeOrderRequest) {
	        return new PlaceOrderResponse();
	    }

}
