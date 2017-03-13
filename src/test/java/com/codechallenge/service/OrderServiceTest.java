package com.codechallenge.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.codechallenge.dto.PlaceOrderRequest;
import com.codechallenge.dto.PlaceOrderResponse;
import com.codechallenge.exception.InvalidProductException;
import com.codechallenge.models.Order;
import com.codechallenge.models.OrderEntry;
import com.codechallenge.models.OrderStatus;
import com.codechallenge.models.Product;
import com.codechallenge.services.DataLoadService;
import com.codechallenge.services.OrderEntryService;
import com.codechallenge.services.OrderService;
import com.codechallenge.services.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTest {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	DataLoadService dataLoadService;
	
	@Autowired
	OrderService orderService;

	
	@Autowired
	OrderEntryService orderEntryService;
	
	private static final Logger LOG = LoggerFactory.getLogger(OrderServiceTest.class);
	
	private static boolean dataLoaded=false;
	
	@Before
	public void setup() throws Exception
	{
		if(!dataLoaded)
		{
			dataLoaded=!dataLoaded;
			dataLoadService.loadDataIntoSystem();
		}
		
	}
	
	//@After
	public void tearDown() throws Exception
	{
		productService.removeProducts(productService.getAllProducts());
	}
	
	@Test
	public void createOrderTest()
	{
		Order order=orderService.createOrder(new Order());
		LOG.info("Order Created with ID : "+order.getId());
		assertEquals(order.getId()!=null && order.getStatus().equals(OrderStatus.NEW),true);
	}
	
	
	@Test
	public void placeOrderTest() throws InvalidProductException, JsonProcessingException
	{
		Order order=orderService.createOrder(new Order());
		List<OrderEntry> entries=new ArrayList<>();
		
		LOG.info("Order Created with ID : "+order.getId());
		OrderEntry entry=new OrderEntry();
		Product product=productService.getProductByName("Apple");
		entry.setProductId(product.getId());
		entry.setQty(10);
		entry.setUnitPrice(product.getPrice());
		entry.setOwner(order);
		entries.add(entry);
		order.setOrderEntries(entries);
		orderService.saveOrder(order);
		PlaceOrderRequest request=new PlaceOrderRequest();
		request.setOrder(order);
		PlaceOrderResponse response=orderService.placeOrder(request);
		LOG.info("total price :"+response.getOrder().getOrderEntries().get(0).getProductId());
		assertEquals(response!=null,true);
		
	}
	

}
