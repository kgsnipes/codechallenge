package com.codechallenge.dto;

import java.util.Collection;

public class ServiceResponse {
	
	private String status;
	
	private Collection<String> errors;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Collection<String> getErrors() {
		return errors;
	}

	public void setErrors(Collection<String> errors) {
		this.errors = errors;
	}
	
	
	

}
