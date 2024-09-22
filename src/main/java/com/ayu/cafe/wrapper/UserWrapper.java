package com.ayu.cafe.wrapper;

public class UserWrapper {

	private Integer id;

	private String name;

	private String mail;

	private String contactNumber;

	private String status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public UserWrapper() {

	}

	public UserWrapper(Integer id, String name, String mail, String contactNumber, String status) {
		super();
		this.id = id;
		this.name = name;
		this.mail = mail;
		this.contactNumber = contactNumber;
		this.status = status;
	}

}
