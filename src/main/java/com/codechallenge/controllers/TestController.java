package com.codechallenge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codechallenge.models.Product;
import com.codechallenge.repository.ProductRepository;

@RestController
public class TestController {
	
	@Autowired
	private ProductRepository productRepository;
	
	
	 @RequestMapping(path="/test1",method = RequestMethod.GET, produces="application/json")
	    public Product test1() {
		 return productRepository.findByName("Orange");
	    }

}