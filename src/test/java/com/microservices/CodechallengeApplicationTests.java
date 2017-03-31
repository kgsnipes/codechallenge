package com.microservices;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.microservices.services.DataLoadService;
import com.microservices.services.ProductService;
import com.microservices.services.impl.DefaultProductService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CodechallengeApplicationTests {

	@Autowired
	ProductService productService;
	@Test
	public void contextLoadsTest1() {
		// this is to test if the application context has properly loaded by checking the instance of the auto wired product service
		assertThat(productService instanceof DefaultProductService);
	}
	
	@Test
	public void contextLoadsTest2() {
		// this is to perform the negative testing by comparing the autowired product service instance to some other service class
		assertEquals(productService instanceof DataLoadService,false);
	}

}
