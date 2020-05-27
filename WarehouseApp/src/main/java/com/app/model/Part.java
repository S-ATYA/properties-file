package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="parttable")

public class Part {
	@ManyToOne
	@JoinColumn(name="uomIdFk")
	private Uom uom;
	
	@ManyToOne
	@JoinColumn(name="orderMethodIdFk")
	private OrderMethod orderMethod;

	public OrderMethod getOrderMethod() {
		return orderMethod;
	}


	public void setOrderMethod(OrderMethod orderMethod) {
		this.orderMethod = orderMethod;
	}




	public Uom getUom() {
		return uom;
	}


	public void setUom(Uom uom) {
		this.uom = uom;
	}


	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;

	@Column(name="code")
	private String partCode;

	@Column(name="width")
	private Integer width;

	@Column(name="length")
	private Integer length;

	@Column(name="height")
	private Integer height;


	@Column(name="basecost")
	private Double baseCost;


	@Column(name="basecurrency")
	private String baseCurrency;

	@Column(name="descrii")
	private String description;


	public Part() {
		super();
	}



	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getPartCode() {
		return partCode;
	}


	public void setPartCode(String partCode) {
		this.partCode = partCode;
	}


	public Integer getWidth() {
		return width;
	}


	public void setWidth(Integer width) {
		this.width = width;
	}


	public Integer getLength() {
		return length;
	}


	public void setLength(Integer length) {
		this.length = length;
	}


	public Integer getHeight() {
		return height;
	}


	public void setHeight(Integer height) {
		this.height = height;
	}


	public Double getBaseCost() {
		return baseCost;
	}


	public void setBaseCost(Double baseCost) {
		this.baseCost = baseCost;
	}

	public String getBaseCurrency() {
		return baseCurrency;
	}


	public void setBaseCurrency(String baseCurrency) {
		this.baseCurrency = baseCurrency;
	}



	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		return "Part [uom=" + uom + ", orderMethod=" + orderMethod + ", id=" + id + ", partCode=" + partCode
				+ ", width=" + width + ", length=" + length + ", height=" + height + ", baseCost=" + baseCost
				+ ", baseCurrency=" + baseCurrency + ", description=" + description + "]";
	}






}
