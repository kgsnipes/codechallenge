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
@Table(name="product")
@DiscriminatorValue("2")
public class Product implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6073468905856062059L;
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "productid", nullable = false)
    private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "price")
	private Float price;
	@Column(name = "qty")
	private Integer availableQuantity;
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(String name, Float price, Integer qty) {
		super();
		this.name = name;
		this.price = price;
		this.availableQuantity = qty;
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

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(Integer availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	
}
