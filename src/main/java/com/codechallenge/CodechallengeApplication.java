package com.codechallenge;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.codechallenge.config.AppConfig;
import com.codechallenge.services.DataLoadService;

/*all the spring boot annotations required for auto configuration and startup.*/
@SpringBootApplication
@EnableCaching
@EnableAutoConfiguration
public class CodechallengeApplication {
	
	private static final Logger LOG = LoggerFactory.getLogger(CodechallengeApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(CodechallengeApplication.class, args);
		//fetching the spring context
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		LOG.info("Application has booted..going in for data load");
		//fetching the data load service for loading the initial product data to the application
		DataLoadService dataLoadService=(DataLoadService) context.getBean("dataLoadService");
		try
		{
			//loading the initial data to the system
			dataLoadService.loadDataIntoSystem();
		}
		catch(Exception ex)
		{
			LOG.error("Exception loading data into system", ex);
		}
	}

}
