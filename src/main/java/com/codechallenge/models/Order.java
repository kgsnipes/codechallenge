package com.codechallenge.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="orders")
@DiscriminatorValue("3")
public class Order implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7729760149513253282L;

	@Id
	@Column(name = "orderid", nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private Set<OrderEntry> orderEntries;
	
	@Column(name = "totalprice")
	private Float totalPrice;
	
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
	private User customer;
	
	@Column(name="status")
    @Enumerated(value = EnumType.STRING)
	private OrderStatus status;
	
	

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(Set<OrderEntry> orderEntries, Float totalPrice, User customer) {
		super();
		this.orderEntries = orderEntries;
		this.totalPrice = totalPrice;
		this.customer = customer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<OrderEntry> getOrderEntries() {
		return orderEntries;
	}

	public void setOrderEntries(Set<OrderEntry> orderEntries) {
		this.orderEntries = orderEntries;
	}

	public Float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public User getCustomer() {
		return customer;
	}

	public void setCustomer(User customer) {
		this.customer = customer;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
	
	
	
}
