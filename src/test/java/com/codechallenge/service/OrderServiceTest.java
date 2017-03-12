package com.codechallenge.service;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
	
	

}
