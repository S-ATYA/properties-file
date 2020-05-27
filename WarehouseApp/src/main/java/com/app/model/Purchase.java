package com.app.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="purchaseTab")
public class Purchase {
	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;
	
	@Column(name="ocode")
	private String orderCode;
	
	@Column(name="rnumber")
	private String referenceNumebr;
	
	@Column(name="qcheck")
	private String qualityCheck;
	
	@Column(name="dstatus")
	private String defaultStatus;
	
	@Column(name="descr")
	private String description;
	
	@ManyToOne
	@JoinColumn(name="shipIdFK")
	private Shipment shipmentCode;
	
	@ManyToOne
	@JoinColumn(name="whUserIdFK")
	private WhUser whUser;
	
	@OneToMany(mappedBy="parent",fetch=FetchType.EAGER)
	//@OneToMany(mappedBy="parent")
	private List<PurchaseDetails> childs;
		

	
	public List<PurchaseDetails> getChilds() {
		return childs;
	}

	public void setChilds(List<PurchaseDetails> childs) {
		this.childs = childs;
	}

	public Purchase() {
		super();
	}

	public Purchase(Integer id) {
		super();
		this.id = id;
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

	public String getReferenceNumebr() {
		return referenceNumebr;
	}

	public void setReferenceNumebr(String referenceNumebr) {
		this.referenceNumebr = referenceNumebr;
	}

	public String getQualityCheck() {
		return qualityCheck;
	}

	public void setQualityCheck(String qualityCheck) {
		this.qualityCheck = qualityCheck;
	}

	public String getDefaultStatus() {
		return defaultStatus;
	}

	public void setDefaultStatus(String defaultStatus) {
		this.defaultStatus = defaultStatus;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Shipment getShipmentCode() {
		return shipmentCode;
	}

	public void setShipmentCode(Shipment shipmentCode) {
		this.shipmentCode = shipmentCode;
	}

	public WhUser getWhUser() {
		return whUser;
	}

	public void setWhUser(WhUser whUser) {
		this.whUser = whUser;
	}

	


	
}
