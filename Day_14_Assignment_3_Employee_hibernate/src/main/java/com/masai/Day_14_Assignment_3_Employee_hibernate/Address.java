package com.masai.Day_14_Assignment_3_Employee_hibernate;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Embeddable
class Address {
	private String state;
	private String city;
	private String pincode;
	private String type;

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(String state, String city, String pincode, String type) {
		super();
		this.state = state;
		this.city = city;
		this.pincode = pincode;
		this.type = type;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
