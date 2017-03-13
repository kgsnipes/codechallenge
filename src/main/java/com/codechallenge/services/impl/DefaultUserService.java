package com.codechallenge.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import com.codechallenge.models.User;
import com.codechallenge.repository.UserRepository;
import com.codechallenge.services.UserService;

public class DefaultUserService implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	@CacheEvict(value = "usercache", beforeInvocation = true)
	@Cacheable(value = "usercache",key="#user.emailAddress")
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	@Cacheable(value = "usercache",key="#emailAddress")
	public User getUserByEmailAddress(String emailAddress) {
		// TODO Auto-generated method stub
		return userRepository.findByEmailAddress(emailAddress);
	}

	@Override
	@Cacheable(value = "usercache",key="#user.emailAddress")
	public User getUserByUserId(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}

}
