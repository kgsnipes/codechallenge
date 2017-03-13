package com.codechallenge.services;

import com.codechallenge.models.User;

public interface UserService {
	
	public User saveUser(User user);
	
	public User getUserByEmailAddress(String emailAddress);
	
	public User getUserByUserId(Long id);

}
