package com.itbulls.learnit.onlinestore.persistence.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "purchase")
public class Purchase {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "fk_purchase_user")
	private User userDto;
	
	@ManyToMany
	@JoinTable(name="purchase_product",
	   joinColumns=@JoinColumn(name="purchase_id"),
	   inverseJoinColumns=@JoinColumn(name="product_id"))
	private List<Product> productDtos;
	
	@ManyToOne
	@JoinColumn(name = "fk_purchase_purchase_status")
	private PurchaseStatus purchaseStatusDto;
	
	@Column(name = "purchase_timestamp", insertable = false, updatable = false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date purchaseTimestamp;
	
	public Purchase() {
	}
	
	public Purchase(Integer id, User userDto, PurchaseStatus purchaseStatusDto) {
		this.id = id;
		this.userDto = userDto;
		this.purchaseStatusDto = purchaseStatusDto;
	}

	public Integer getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUserDto() {
		return userDto;
	}
	public void setUserDto(User userDto) {
		this.userDto = userDto;
	}
	public List<Product> getProductDtos() {
		return productDtos;
	}
	public void setProductDtos(List<Product> productDtos) {
		this.productDtos = productDtos;
	}
	public PurchaseStatus getPurchaseStatusDto() {
		return this.purchaseStatusDto;
	}
	public void setPurchaseStatusDto(PurchaseStatus purchaseStatusDto) {
		this.purchaseStatusDto = purchaseStatusDto;
	}
	public Date getPurchaseTimestamp() {
		return purchaseTimestamp;
	}
	public void setPurchaseTimestamp(Date purchaseTimestamp) {
		this.purchaseTimestamp = purchaseTimestamp;
	}
	public void setId(Integer id) {
		this.id = id;
	}

}
