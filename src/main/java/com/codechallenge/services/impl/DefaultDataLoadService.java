package com.codechallenge.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.codechallenge.CodechallengeApplication;
import com.codechallenge.dto.ProductDataUpload;
import com.codechallenge.repository.ProductRepository;
import com.codechallenge.services.DataLoadService;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DefaultDataLoadService implements DataLoadService {
	
	@Autowired
	private ProductRepository productRespository;
	
	private static final Logger LOG = LoggerFactory.getLogger(DefaultDataLoadService.class);

	@Override
	public void loadDataIntoSystem() throws Exception {
		LOG.info("Loading the product data.");
		loadProductData();
		LOG.info("Product data is loaded.");
		
	}
	
	private void loadProductData() throws Exception
	{
		ObjectMapper objectMapper=new ObjectMapper();
		ProductDataUpload productData=objectMapper.readValue(CodechallengeApplication.class.getResourceAsStream("/productData.json"),ProductDataUpload.class);
		productRespository.save(productData.getProducts());
	}

}
