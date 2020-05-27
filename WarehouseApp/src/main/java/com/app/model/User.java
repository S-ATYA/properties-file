package com.app.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="usertab")
public class User {
	
	@Id
	@Column(name="id")
	@GeneratedValue
	private Integer id;
	
	@Column(name="username")
	private String uname;
	
	@Column(name="useremail")
	private String umail;
	

	@Column(name="userpassword")
	private String upassword;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="useraccepttab",joinColumns=@JoinColumn(name="id"))
	@Column(name="userroles")
	private List<String> uroles;


	public User() {
		super();
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getUname() {
		return uname;
	}


	public void setUname(String uname) {
		this.uname = uname;
	}


	public String getUmail() {
		return umail;
	}


	public void setUmail(String umail) {
		this.umail = umail;
	}


	public String getUpassword() {
		return upassword;
	}


	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}


	public List<String> getUroles() {
		return uroles;
	}


	public void setUroles(List<String> uroles) {
		this.uroles = uroles;
	}


	@Override
	public String toString() {
		return "UserRegister [id=" + id + ", uname=" + uname + ", umail=" + umail + ", upassword=" + upassword
				+ ", uroles=" + uroles + "]";
	}
	
	

}
