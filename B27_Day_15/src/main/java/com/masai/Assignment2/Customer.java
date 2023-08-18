package com.masai.Assignment2;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;

@Entity
@NamedQueries({ @NamedQuery(name = "customerById", query = "Select c from Customer c where c.id = :id") })
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerid;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String address;
	@Column(nullable = false)
	private int budget;

	public Customer() {
		super();
	}

	public Customer(String name, String address, int budget) {
		super();
		this.customerid = customerid;
		this.name = name;
		this.address = address;
		this.budget = budget;
	}

	public int getCustomerid() {
		return customerid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	@Override
	public String toString() {
		return "Customer [customerid=" + customerid + ", name=" + name + ", address=" + address + ", budget=" + budget
				+ "]";
	}

}
