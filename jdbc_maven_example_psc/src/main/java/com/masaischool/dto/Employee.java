package com.masaischool.dto;

import java.time.LocalDate;

public class Employee {
	private int employeeId;
	private String name;
	private double salary;
	private String state;
	private LocalDate joiningDate;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String name, double salary, String state, LocalDate joiningDate) {
		super();
		this.name = name;
		this.salary = salary;
		this.state = state;
		this.joiningDate = joiningDate;
	}

	public Employee(int employeeId, String name, double salary, String state, LocalDate joiningDate) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.salary = salary;
		this.state = state;
		this.joiningDate = joiningDate;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public LocalDate getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", salary=" + salary + ", state=" + state
				+ ", joiningDate=" + joiningDate + "]";
	}
}
