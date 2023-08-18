package com.masai;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table
public class FullTimeStudent extends MasaiStudent {
	private double fullTimeFee;

	public FullTimeStudent() {
		super();
	}

	public FullTimeStudent(String name, String address, double registrationFee, double fullTimeFee) {
		super(name, address, registrationFee);
		this.fullTimeFee = fullTimeFee;
	}

	public double getFullTimeFee() {
		return fullTimeFee;
	}

	public void setFullTimeFee(double fullTimeFee) {
		this.fullTimeFee = fullTimeFee;
	}

	@Override
	public double payFee() {
		return getFullTimeFee() + getRegistrationFee();
	}

}
