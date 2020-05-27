package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="salestab")
public class Sale {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="shipmentTypeFk")
	Shipment type;
	
	public Shipment getType() {
		return type;
	}




	public void setType(Shipment type) {
		this.type = type;
	}




	@Column(name="scode")
	private String orderCode; 
	

	@Column(name="smode")
	private String shipmentMode; 
	

	@Column(name="scustomer")
	private String customer; 
	

	@Column(name="rno")
	private String referenceNo; 
	

	@Column(name="stmode")
	private String stockMode; 
	

	@Column(name="ssource")
	private String stockSource; 
	

	

	@Column(name="descri")
	private String description;




	public Sale() {
		super();
	}




	public Integer getId() {
		return id;
	}




	public void setId(Integer id) {
		this.id = id;
	}




	public String getOrderCode() {
		return orderCode;
	}




	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}




	public String getShipmentMode() {
		return shipmentMode;
	}




	public void setShipmentMode(String shipmentMode) {
		this.shipmentMode = shipmentMode;
	}




	public String getCustomer() {
		return customer;
	}




	public void setCustomer(String customer) {
		this.customer = customer;
	}




	public String getReferenceNo() {
		return referenceNo;
	}




	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}




	public String getStockMode() {
		return stockMode;
	}




	public void setStockMode(String stockMode) {
		this.stockMode = stockMode;
	}




	public String getStockSource() {
		return stockSource;
	}




	public void setStockSource(String stockSource) {
		this.stockSource = stockSource;
	}




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}




	@Override
	public String toString() {
		return "Sale [id=" + id + ", type=" + type + ", orderCode=" + orderCode + ", shipmentMode=" + shipmentMode
				+ ", customer=" + customer + ", referenceNo=" + referenceNo + ", stockMode=" + stockMode
				+ ", stockSource=" + stockSource + ", description=" + description + "]";
	}


	
}
