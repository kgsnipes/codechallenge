package com.microservices.services;
/* this interface defines the method which would be used to load sample data set for the application to operate*/
public interface DataLoadService {
	
	public void loadDataIntoSystem() throws Exception;

}
