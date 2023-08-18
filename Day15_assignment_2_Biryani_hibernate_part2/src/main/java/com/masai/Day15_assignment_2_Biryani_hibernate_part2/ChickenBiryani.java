package com.masai.Day15_assignment_2_Biryani_hibernate_part2;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

public class ChickenBiryani extends BiryaniPart2 {

	private double price;
	private String description;

	public ChickenBiryani() {
		super();
	}

	public ChickenBiryani(int rating, double price, String description) {
		super(rating);
		this.price = price;
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
