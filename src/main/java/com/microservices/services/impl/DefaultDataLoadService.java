package com.microservices.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservices.MicroservicesApplication;
import com.microservices.dto.ProductDataUpload;
import com.microservices.repository.ProductRepository;
import com.microservices.services.DataLoadService;

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
		if(productRespository.findByName("Apple")==null){
			
			ObjectMapper objectMapper=new ObjectMapper();
			ProductDataUpload productData=objectMapper.readValue(MicroservicesApplication.class.getResourceAsStream("/productData.json"),ProductDataUpload.class);
			productRespository.save(productData.getProducts());
		}
	}

}
