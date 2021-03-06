package com.microservices.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.microservices.dto.PlaceOrderRequest;
import com.microservices.dto.PlaceOrderResponse;
import com.microservices.exception.InvalidProductException;
import com.microservices.models.Order;
import com.microservices.models.OrderEntry;
import com.microservices.models.OrderStatus;
import com.microservices.models.Product;
import com.microservices.models.User;
import com.microservices.services.DataLoadService;
import com.microservices.services.OrderService;
import com.microservices.services.ProductService;
import com.microservices.services.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceStressTest {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	DataLoadService dataLoadService;
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	UserService userService;

	
	private static final Logger LOG = LoggerFactory.getLogger(OrderServiceStressTest.class);
	
	
	
	@Before
	public void setup() throws Exception
	{
		if(productService.getProductByName("Apple")==null)
		{
			
			dataLoadService.loadDataIntoSystem();
		}
		
	}
	
	@Test
	public void threadTestForPlaceOrder() throws InterruptedException
	{
		/* stress test for order placement when 200 threads are started*/
		for(int i=0;i<200;i++)
		{
			Thread t=new Thread(new Runnable(){
				public void run()
				{
					try
					{
						LOG.info("-----------------Executing new thread-------------------------------");						
						placeOrderTest();
					}
					catch(Exception ex)
					{
						LOG.error("Exception in thread", ex);
					}
				}
				
			});
			t.start();
			t.join();
		}
		
		
		
		
	}
	

	
	public void placeOrderTest() throws InvalidProductException, JsonProcessingException
	{
		Order order=orderService.createOrder(new Order());
		User user=userService.getUserByEmailAddress("user1@test.com");
		
		if(user==null)
		{
			userService.saveUser(new User("user1","user1@test.com"));
		}
		
		Product product=productService.getProductByName("Apple");
		
		List<OrderEntry> entries=new ArrayList<>();
		
		LOG.info("Order Created with ID : "+order.getId());
		OrderEntry entry=new OrderEntry();
		
		entry.setProductId(product.getId());
		entry.setQty(10);
		entry.setUnitPrice(product.getPrice());
		entry.setOwner(order);
		entries.add(entry);
		
		order.setOrderEntries(entries);
		order.setCustomer(user);
		orderService.saveOrder(order);
		
		PlaceOrderRequest request=new PlaceOrderRequest();
		request.setOrder(order);
		
		PlaceOrderResponse response=orderService.placeOrder(request);
		
		assertEquals(response!=null,true);
		assertEquals(response.getOrder()!=null,true);
		assertEquals(response.getOrder().getStatus().equals(OrderStatus.PLACED),true);
		
	}
	
	
	
}
