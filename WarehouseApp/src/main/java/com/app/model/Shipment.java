package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="shipmenttab")
public class Shipment {
	@Id
	@Column(name="id")
	@GeneratedValue
	private Integer id;
	@Column(name="stype",length=20,nullable=false)
	private String shipmentType;
	@Column(name="scode",length=50,nullable=false)
	private String shipmentCode;
	@Column(name="senable",length=10,nullable=false)
	private String shipmentEnable;
	@Column(name="sgrade",length=5,nullable=false)
	private String shipmentGrade;
	@Column(name="descr")
	private String description;
	
	
	public Shipment() {
		super();
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getShipmentType() {
		return shipmentType;
	}


	public void setShipmentType(String shipmentType) {
		this.shipmentType = shipmentType;
	}


	public String getShipmentCode() {
		return shipmentCode;
	}


	public void setShipmentCode(String shipmentCode) {
		this.shipmentCode = shipmentCode;
	}


	public String getShipmentEnable() {
		return shipmentEnable;
	}


	public void setShipmentEnable(String shipmentEnable) {
		this.shipmentEnable = shipmentEnable;
	}


	public String getShipmentGrade() {
		return shipmentGrade;
	}


	public void setShipmentGrade(String shipmentGrade) {
		this.shipmentGrade = shipmentGrade;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		return "ShipmentType [id=" + id + ", shipmentType=" + shipmentType + ", shipmentCode=" + shipmentCode
				+ ", shipmentEnable=" + shipmentEnable + ", shipmentGrade=" + shipmentGrade + ", description="
				+ description + "]";
	}
	
	
	
	
	
	
	
	

}
