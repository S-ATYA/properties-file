package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="whusertab")
public class WhUser {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;
	@Column(name="utype")
	private String userType;
	@Column(name="ucode")
	private String userCode;
	@Column(name="ufor")
	private String userFor;
	@Column(name="email")
	private String userEmail;
	@Column(name="mobNumber")
	private String mobileNumber;
	@Column(name="uidtype")
	private String idType;
	@Column(name="othrsId")
	private String othersId;
	@Column(name="idNumber")
	private String idNumber;
	
	public WhUser() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserFor() {
		return userFor;
	}

	public void setUserFor(String userFor) {
		this.userFor = userFor;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getOthersId() {
		return othersId;
	}

	public void setOthersId(String othersId) {
		this.othersId = othersId;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	@Override
	public String toString() {
		return "WhUser [id=" + id + ", userType=" + userType + ", userCode=" + userCode + ", userFor=" + userFor
				+ ", userEmail=" + userEmail + ", mobileNumber=" + mobileNumber + ", idType=" + idType + ", othersId="
				+ othersId + ", idNumber=" + idNumber + "]";
	}

	
	
	
	
}
