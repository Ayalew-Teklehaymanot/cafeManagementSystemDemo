package com.ayu.cafe.POJO;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.*;

import lombok.Data;

@NamedQuery(name="User.findByMailId", query = "select u from User u where u.mail=:mail")

@NamedQuery(name="User.getAllUsers", query = "select  new com.ayu.cafe.wrapper.UserWrapper(u.id,u.name,u.mail,u.contactNumber,u.status)  from User u where u.role='user'")

//@Data
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "user")

public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "mail")
	private String mail;

	@Column(name = "password")
	private String password;

	@Column(name = "contactNumber") 
	private String contactNumber; 

	@Column(name = "status")
	private String status;

	@Column(name = "role")
	private String role;

	public User() {

	}

	public User(String name, String mail, String password, String contactNumber, String status, String role) {
	
		this.name = name;
		this.mail = mail;
		this.password = password;
		this.contactNumber = contactNumber;
		this.status = status;
		this.role = role;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
