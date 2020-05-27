package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="shiptab")
public class Shipping {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;
	
	@Column(name="scode")
	private String shippingCode;
	
	@Column(name="refno")
	private String refNo;
	
	@Column(name="crefno")
	private String crefNo;
	
	@Column(name="cdetails")
	private String cdetails;
	

	@Column(name="odcode")
	private String orderCode;
	

	@Column(name="descri")
	private String description;
	
	

	@Column(name="baddress")
	private String billingAddress;
	

	@Column(name="saddress")
	private String shippingAddress;


	public Shipping() {
		super();
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getShippingCode() {
		return shippingCode;
	}


	public void setShippingCode(String shippingCode) {
		this.shippingCode = shippingCode;
	}


	public String getRefNo() {
		return refNo;
	}


	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}


	public String getCrefNo() {
		return crefNo;
	}


	public void setCrefNo(String crefNo) {
		this.crefNo = crefNo;
	}


	public String getCdetails() {
		return cdetails;
	}


	public void setCdetails(String cdetails) {
		this.cdetails = cdetails;
	}


	public String getOrderCode() {
		return orderCode;
	}


	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getBillingAddress() {
		return billingAddress;
	}


	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}


	public String getShippingAddress() {
		return shippingAddress;
	}


	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}


	@Override
	public String toString() {
		return "Shipping [id=" + id + ", shippingCode=" + shippingCode + ", refNo=" + refNo + ", crefNo=" + crefNo
				+ ", cdetails=" + cdetails + ", orderCode=" + orderCode + ", description=" + description
				+ ", billingAddress=" + billingAddress + ", shippingAddress=" + shippingAddress + "]";
	}



}
