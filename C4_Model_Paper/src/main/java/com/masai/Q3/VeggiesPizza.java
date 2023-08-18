package com.masai.Q3;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("VP")
class VeggiesPizza extends Pizza {
	private int totalVeggies;
	private double totalCalories;

	public VeggiesPizza() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public VeggiesPizza(double price, double rating, double diameter, String type, int totalVeggies,
			double totalCalories) {
		super(price, rating, diameter, type);
		this.totalVeggies = totalVeggies;
		this.totalCalories = totalCalories;
	}



	public int getTotalVeggies() {
		return totalVeggies;
	}

	public void setTotalVeggies(int totalVeggies) {
		this.totalVeggies = totalVeggies;
	}

	public double getTotalCalories() {
		return totalCalories;
	}

	public void setTotalCalories(double totalCalories) {
		this.totalCalories = totalCalories;
	}



	@Override
	public String toString() {
		return "VeggiesPizza [totalVeggies=" + totalVeggies + ", totalCalories=" + totalCalories + "]";
	}

	
}