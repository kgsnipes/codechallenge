package com.codechallenge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codechallenge.models.Order;
import com.codechallenge.models.User;
import com.codechallenge.services.UserService;

@RestController
public class UserServiceController {
	
	@Autowired
	private UserService userService;
	
	//creates a user
	 @RequestMapping(path="/user/create",method = RequestMethod.POST, produces="application/json", consumes="application/json")
	    public User createUser(@RequestBody User user) {
	        return userService.saveUser(user);
	    }
	 
	 //this handler fetches the user by emailAddress
	 @RequestMapping(path="/user/{emailAddress}",method = RequestMethod.GET, produces="application/json")
	    public User getUser(@PathVariable String emailAddress) {
	        return userService.getUserByEmailAddress(emailAddress);
	    }
	 
	//this handler fetches the user by emailAddress
	@RequestMapping(path="/user/{userID}",method = RequestMethod.GET, produces="application/json")
	    public User getUser(@PathVariable Long userID) {
	        return userService.getUserByUserId(userID);
	    }
	 
	
}
