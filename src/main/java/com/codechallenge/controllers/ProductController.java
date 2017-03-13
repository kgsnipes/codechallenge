package com.codechallenge.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.codechallenge.services.impl.DefaultDataLoadService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private StockService stockService;
	
	private static final Logger LOG = LoggerFactory.getLogger(ProductController.class);
	
	
	 @RequestMapping(path="/product/{productName}",method = RequestMethod.GET, produces="application/json")
	    public Product getProduct(@PathVariable String productName) {
		 Product product=null;
		 try
		 {
			 product= productService.getProductByName(productName);
		 }
		 catch(Exception ex)
		 {
			 LOG.error("Exception while fetching product", ex);
		 }
		 return product;
	    }
	 
	 @RequestMapping(path="/stock/{productName}",method = RequestMethod.GET, produces="application/json")
	    public Integer getStock(@PathVariable String productName) {
		 Integer stock=-1;
		 try
		 {
			 stock= stockService.getCurrentStockForProduct(productService.getProductByName(productName).getId());
		 }
		 catch(Exception ex)
		 {
			 LOG.error("Exception while fetching product", ex);
		 }
		 return stock;
	    }

}