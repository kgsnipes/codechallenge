package com.codechallenge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codechallenge.exception.InvalidProductException;
import com.codechallenge.models.Product;
import com.codechallenge.services.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	
	 @RequestMapping(path="/product/{productName}",method = RequestMethod.GET, produces="application/json")
	    public Product test1(@PathVariable String productName) throws InvalidProductException {
		 return productService.getProductByName(productName);
	    }

}