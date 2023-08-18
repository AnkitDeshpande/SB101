package com.masai.Q3;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table
public class Truck extends Vehicle {
	private double loadingCapacity;

	public Truck() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Truck(String brand, String model, double price, double loadingCapacity) {
		super(brand, model, price);
		this.loadingCapacity = loadingCapacity;
	}

	public double getLoadingCapacity() {
		return loadingCapacity;
	}

	public void setLoadingCapacity(double loadingCapacity) {
		this.loadingCapacity = loadingCapacity;
	}

	@Override
	public String toString() {
		return "Truck [loadingCapacity=" + loadingCapacity + "]";
	}

}
