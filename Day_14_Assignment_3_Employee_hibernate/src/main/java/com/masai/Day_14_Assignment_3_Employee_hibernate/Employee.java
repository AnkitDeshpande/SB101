package com.masai.Day_14_Assignment_3_Employee_hibernate;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;

@Entity
@Table (name = "Emp_table")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empID;
	private String name;
	private String gender;
	private int salary;
	
	@Embedded
	@ElementCollection(fetch = FetchType.EAGER)
	@JoinTable(name = "Addresses", joinColumns = @JoinColumn(name = "Employee_id"))
	private Set<Address> empAddress;

	public Employee() {
		super();
	}

	public Employee(String name, String gender, int salary, HashSet<Address> hashSet) {
		super();
		this.name = name;
		this.gender = gender;
		this.salary = salary;
		this.empAddress = hashSet;
	}


	public int getEmpID() {
		return empID;
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
		return "Emplyoee [empID=" + empID + ", name=" + name + ", gender=" + gender + ", salary=" + salary
				+ ", empAddress=" + empAddress + "]";
	}

}
