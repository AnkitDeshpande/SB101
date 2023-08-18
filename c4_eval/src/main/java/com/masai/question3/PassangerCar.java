package com.masai.question3;

import jakarta.persistence.Entity;

@Entity
class PassangerCar extends Vehicle {
	private int seating_capacity;
	private double groundClearance;

	public PassangerCar() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PassangerCar(String brand, String model, double price, int seating_capacity, double groundClearance) {
		super(brand, model, price);
		this.seating_capacity = seating_capacity;
		this.groundClearance = groundClearance;
	}

	@Override
	public String toString() {
		return "PassangerCar [seating_capacity=" + seating_capacity + ", groundClearance=" + groundClearance + "]";
	}

	public int getSeating_capacity() {
		return seating_capacity;
	}

	public void setSeating_capacity(int seating_capacity) {
		this.seating_capacity = seating_capacity;
	}

	public double getGroundClearance() {
		return groundClearance;
	}

	public void setGroundClearance(double groundClearance) {
		this.groundClearance = groundClearance;
	}

}