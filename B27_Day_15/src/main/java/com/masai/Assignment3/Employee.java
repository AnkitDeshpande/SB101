package com.masai.Assignment3;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OrderBy;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empID;
	private String name;
	private String gender;
	private int salary;
	@Embedded
	@ElementCollection(fetch = FetchType.EAGER)
	@OrderBy("state DESC, city ASC, zipcode ASC")
	@JoinTable(name = "address", joinColumns = @JoinColumn(name = "customer_id"))
	private Set<Address> empAddress = new HashSet();

	public Employee(String name, String gender, int salary) {
		super();
		this.name = name;
		this.gender = gender;
		this.salary = salary;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Set<Address> getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(Set<Address> empAddress) {
		this.empAddress = empAddress;
	}

	@Override
	public String toString() {
		return "Employee [empID=" + empID + ", name=" + name + ", gender=" + gender + ", salary=" + salary
				+ ", empAddress=" + empAddress + "]";
	}

}