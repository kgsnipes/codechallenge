package com.codechallenge.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.codechallenge.exception.InvalidProductException;
import com.codechallenge.models.Product;
import com.codechallenge.services.DataLoadService;
import com.codechallenge.services.ProductService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {

	@Autowired
	ProductService productService;
	
	@Autowired
	DataLoadService dataLoadService;
	
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
	public void getProductByNameTest1() throws InvalidProductException {
		String productName="Apple";
		Product product=productService.getProductByName(productName);
		assertNotNull(product);
	}
	
	@Test
	public void getProductByNameTest2() throws InvalidProductException {
		String productName="Orange";
		Product product=productService.getProductByName(productName);
		assertEquals(product.getName(),productName);
	}
	
	@Test
	public void getAllProductsTest() {
		
		assertEquals(productService.getAllProducts().size()
				,4);
	}
	
	@Test
	public void removeProductsTest() {
		productService.removeProducts(productService.getAllProducts());
		assertEquals(productService.getAllProducts().size()
				,0);
	}
	
	@Test
	public void createProductTest() {
		Product product=new Product("Product001",50.0f, 0);
		product=productService.createProduct(product);
		
		assertEquals(product!=null && product.getId()!=null,true);
		assertEquals(product.getName(),"Product001");
	}

}
