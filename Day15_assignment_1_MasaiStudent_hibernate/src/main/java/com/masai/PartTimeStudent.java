package com.masai;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table
public class PartTimeStudent extends MasaiStudent {

	private double partTimeFee;

	public PartTimeStudent() {
		super();
	}

	public PartTimeStudent(String name, String address, double registrationFee, double partTimeFee) {
		super(name, address, registrationFee);
		this.partTimeFee = partTimeFee;
	}

	public double getPartTimeFee() {
		return partTimeFee;
	}

	public void setPartTimeFee(double partTimeFee) {
		this.partTimeFee = partTimeFee;
	}

	@Override
	public double payFee() {
		return getPartTimeFee() + getRegistrationFee();
	}

}
