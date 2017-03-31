package com.microservices.services;

import com.microservices.models.User;
/* this interface defines the methods for the user relation operations required for this application */
public interface UserService {
	
	public User saveUser(User user);
	
	public User getUserByEmailAddress(String emailAddress);
	
	public User getUserByUserId(Long id);

}
