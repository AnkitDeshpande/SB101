package com.masai.Q3;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Table
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "pizzaType")
class Pizza {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private double price;
	private double rating;
	private double diameter;
	private String type; // can have value veg or non-veg

	public Pizza() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pizza(double price, double rating, double diameter, String type) {
		super();
		this.price = price;
		this.rating = rating;
		this.diameter = diameter;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public double getDiameter() {
		return diameter;
	}

	public void setDiameter(double diameter) {
		this.diameter = diameter;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Pizza [id=" + id + ", price=" + price + ", rating=" + rating + ", diameter=" + diameter + ", type="
				+ type + "]";
	}

}