package com.microservices.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.microservices.models.OrderEntry;
import com.microservices.models.User;
/* this interface uses the Spring JPA CRUD repository to add the crud functionality and also allows to add custom methods to fetch data */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	public User findById(Long id);
	
	public User findByEmailAddress(String emailAddress);
   
}