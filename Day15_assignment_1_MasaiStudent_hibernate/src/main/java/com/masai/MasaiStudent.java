package com.masai;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class MasaiStudent {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String address;
	private double registrationFee;

	public int getId() {
		return id;
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

	public double getRegistrationFee() {
		return registrationFee;
	}

	public void setRegistrationFee(double registrationFee) {
		this.registrationFee = registrationFee;
	}

	public MasaiStudent(String name, String address, double registrationFee) {
		super();
		this.name = name;
		this.address = address;
		this.registrationFee = registrationFee;
	}

	public MasaiStudent() {
		super();
	}

	public void displayDetails() {
		System.out.println("Student ID: " + id);
		System.out.println("Name: " + name);
		System.out.println("Address: " + address);
	}

	public abstract double payFee();

}
