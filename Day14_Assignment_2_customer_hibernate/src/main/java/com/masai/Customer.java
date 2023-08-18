package com.masai;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table
@NamedQueries({
	@NamedQuery(name = "findCustomerById", query = "SELECT c FROM Customer c WHERE c.id = :customerId")
})
@NamedNativeQuery (name = "ListOfAllTheCustomers", query = "Select * from Customer", resultClass = Customer.class)
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String address;
	@Column(nullable = false)
	private int budget;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String name, String address, int budget) {
		super();
		this.name = name;
		this.address = address;
		this.budget = budget;
	}

	public int getCustomerId() {
		return customerId;
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
		return "Customer [customerId=" + customerId + ", name=" + name + ", address=" + address + ", budget=" + budget
				+ "]";
	}

}
