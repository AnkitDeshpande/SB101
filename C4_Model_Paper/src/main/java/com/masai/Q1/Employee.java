package com.masai.Q1;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employeeId;
	private String name;
	private int age;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "policyName", column = @Column(name = "self_policyName")),
			@AttributeOverride(name = "companyName", column = @Column(name = "self_companyName")),
			@AttributeOverride(name = "annualPremium", column = @Column(name = "self_annualPremium")) })
	private Insurance self;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "policyName", column = @Column(name = "employer_policyName")),
			@AttributeOverride(name = "companyName", column = @Column(name = "employer_companyName")),
			@AttributeOverride(name = "annualPremium", column = @Column(name = "employer_annualPremium")) })
	private Insurance employer;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String name, int age, Insurance self, Insurance employer) {
		super();
		this.name = name;
		this.age = age;
		this.self = self;
		this.employer = employer;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Insurance getSelf() {
		return self;
	}

	public void setSelf(Insurance self) {
		this.self = self;
	}

	public Insurance getEmployer() {
		return employer;
	}

	public void setEmployer(Insurance employer) {
		this.employer = employer;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", age=" + age + ", self=" + self
				+ ", employer=" + employer + "]";
	}

}
