package com.codechallenge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codechallenge.exception.InvalidProductException;
import com.codechallenge.exception.OutOfStockException;
import com.codechallenge.models.Product;
import com.codechallenge.services.ProductService;
import com.codechallenge.services.StockService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private StockService stockService;
	
	
	 @RequestMapping(path="/product/{productName}",method = RequestMethod.GET, produces="application/json")
	    public Product getProduct(@PathVariable String productName) throws InvalidProductException {
		 return productService.getProductByName(productName);
	    }
	 
	 @RequestMapping(path="/stock/{productName}",method = RequestMethod.GET, produces="application/json")
	    public Integer getStock(@PathVariable String productName) throws InvalidProductException, InterruptedException, OutOfStockException {
		 return stockService.getCurrentStockForProduct(productService.getProductByName(productName).getId());
	    }

}