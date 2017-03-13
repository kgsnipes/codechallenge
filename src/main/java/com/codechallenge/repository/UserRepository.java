package com.codechallenge.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codechallenge.models.OrderEntry;
import com.codechallenge.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	public User findById(Long id);
	
	public User findByEmailAddress(String emailAddress);
   
}