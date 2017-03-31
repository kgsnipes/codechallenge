package com.microservices.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.dto.PlaceOrderRequest;
import com.microservices.dto.PlaceOrderResponse;
import com.microservices.models.Order;
import com.microservices.models.OrderStatus;
import com.microservices.services.OrderService;

@RestController
public class OrderServiceController {
	
	@Autowired
	private OrderService orderService;
	
	//this handler places the order
	 @RequestMapping(path="/order/placeOrder",method = RequestMethod.POST, produces="application/json", consumes="application/json")
	    public PlaceOrderResponse placeOrder(@RequestBody PlaceOrderRequest placeOrderRequest) {
	        return orderService.placeOrder(placeOrderRequest);
	    }
	 
	 //this handler creates an order
	 @RequestMapping(path="/order/createOrder",method = RequestMethod.GET, produces="application/json")
	    public Order createOrder() {
	        return orderService.createOrder(new Order());
	    }
	 
	 //this fetches an order by order ID
	 @RequestMapping(path="/order/{orderId}",method = RequestMethod.GET, produces="application/json")
	    public Order getOrderByID(@PathVariable Long orderId) {
	        return orderService.getOrderByOrderId(orderId);
	    }
	 
	 //this handler persists the order 
	 @RequestMapping(path="/order/save",method = RequestMethod.POST, produces="application/json",consumes="application/json")
	    public Order saveOrder(@RequestBody Order order) {
	        return orderService.saveOrder(order);
	    }
	 
	 //this handler fetches the orders by status
	 @RequestMapping(path="/orders/status/{status}/page/{pageNumber}",method = RequestMethod.GET, produces="application/json")
	    public List<Order> saveOrder(@PathVariable OrderStatus status,@PathVariable Integer pageNumber ) {
	        return (List<Order>) orderService.getOrderByOrderStatus(status,pageNumber-1);
	    }


}
