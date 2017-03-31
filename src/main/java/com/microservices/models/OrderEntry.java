package com.microservices.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="order_entries")
public class OrderEntry implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6695912403787040615L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "order_entry_id")
    private Long id;
		
	/*@OneToOne
    @JoinColumn(name = "product_id")
	private Product product;*/
	@Column(name = "product_id")
	private Long productId;
	
	@Column(name = "unit_price")
	private Float unitPrice;
	
	@Column(name = "total_price")
	private Float totalPrice;
	
	@Column(name = "qty")
	private Integer qty;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "order_id",foreignKey=@ForeignKey(name="orderentry2order_fk"))
	@JsonBackReference
    private Order owner;
	
	

	public OrderEntry() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderEntry(Long productId, Float unitPrice, Float totalPrice, Integer qty) {
		super();
		this.productId = productId;
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

	/*public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}*/
	
	

	public Float getUnitPrice() {
		return unitPrice;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
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

	public Order getOwner() {
		return owner;
	}

	public void setOwner(Order owner) {
		this.owner = owner;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderEntry other = (OrderEntry) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	
	

}
