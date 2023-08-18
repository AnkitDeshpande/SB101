package com.masai.question3;

import jakarta.persistence.Entity;

@Entity
class Truck extends Vehicle {
	private double loadingCapacity;

	public Truck() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Truck(String brand, String model, double price, double loadingCapacity) {
		super(brand, model, price);
		this.loadingCapacity = loadingCapacity;
	}

	@Override
	public String toString() {
		return "Truck [loadingCapacity=" + loadingCapacity + "]";
	}

	public double getLoadingCapacity() {
		return loadingCapacity;
	}

	public void setLoadingCapacity(double loadingCapacity) {
		this.loadingCapacity = loadingCapacity;
	}

}
