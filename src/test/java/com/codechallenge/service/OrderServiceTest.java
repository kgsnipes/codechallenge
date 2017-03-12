package com.codechallenge.service;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.codechallenge.models.Order;
import com.codechallenge.models.OrderStatus;
import com.codechallenge.services.DataLoadService;
import com.codechallenge.services.OrderService;
import com.codechallenge.services.ProductService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTest {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	DataLoadService dataLoadService;
	
	@Autowired
	OrderService orderService;
	
	private static final Logger LOG = LoggerFactory.getLogger(OrderServiceTest.class);
	
	@Before
	public void setup() throws Exception
	{
		dataLoadService.loadDataIntoSystem();
	}
	
	@After
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
	
	

}
