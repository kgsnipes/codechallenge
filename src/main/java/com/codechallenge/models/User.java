package com.codechallenge.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
@DiscriminatorValue("1")
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6725110445090699441L;
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "userid",nullable=false)
    private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "email")
	private String emailAddress;
	
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String name, String emailAddress) {
		super();
		this.name = name;
		this.emailAddress = emailAddress;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	

}
