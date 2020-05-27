package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="purchasedetailstab")
public class PurchaseDetails {

	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;
	
	@Column(name="qty")
	private Integer quantity;
	
	@Column(name="slno")
	@Transient
	private Integer slno;
	
	@ManyToOne
	@JoinColumn(name="partIdFk")
	private Part part;
	
	@ManyToOne
	@JoinColumn(name="poIdFK")
	private Purchase parent;
	
	public PurchaseDetails() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Part getPart() {
		return part;
	}
	public void setPart(Part part) {
		this.part = part;
	}
	public Integer getSlno() {
		return slno;
	}
	public void setSlno(Integer slno) {
		this.slno = slno;
	}
	public Purchase getParent() {
		return parent;
	}
	public void setParent(Purchase parent) {
		this.parent = parent;
	}
	
	
}
