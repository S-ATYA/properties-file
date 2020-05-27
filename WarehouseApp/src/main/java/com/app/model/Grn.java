package com.app.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="grntab")
public class Grn {
	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;
	
	@Column(name="code")
	private String code;
	
	@Column(name="type")
	private String grnType;
	
	@ManyToOne
	@JoinColumn(name="poIdFk",unique=true)
	private Purchase purchase;
	
	@OneToMany(mappedBy="parent")
	private List<GrnDtl> childs;
	
	
	
	
	@Column(name="note")
	private String note;

	public Grn() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	public Grn(Integer id) {
		super();
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getGrnType() {
		return grnType;
	}

	public void setGrnType(String grnType) {
		this.grnType = grnType;
	}

	public Purchase getPurchase() {
		return purchase;
	}

	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}

	public List<GrnDtl> getChilds() {
		return childs;
	}

	public void setChilds(List<GrnDtl> childs) {
		this.childs = childs;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "Grn [id=" + id + ", code=" + code + ", grnType=" + grnType + ", purchase=" + purchase + ", childs="
				+ childs + ", note=" + note + "]";
	}

	
	
	
	

}
