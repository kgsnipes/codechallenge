package com.codechallenge.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="orderentry")
@DiscriminatorValue("4")
public class OrderEntry {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "orderentryid", nullable = false)
    private Long id;
		
	@OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER, orphanRemoval = true)
	@PrimaryKeyJoinColumn 
	private Product product;
	
	@Column(name = "unitprice")
	private Float unitPrice;
	
	@Column(name = "totalprice")
	private Float totalPrice;
	
	@Column(name = "qty")
	private Integer qty;
	
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id")
    private Order order;
	
	

	public OrderEntry() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderEntry(Product product, Float unitPrice, Float totalPrice, Integer qty) {
		super();
		this.product = product;
		this.unitPrice = unitPrice;
		this.totalPrice = totalPrice;
		this.qty = qty;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}
	
	
	

}
