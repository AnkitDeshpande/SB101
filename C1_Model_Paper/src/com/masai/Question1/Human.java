package com.masai.Question1;

public class Human {
	private double wieght;
	private double height;
	private double bodyMassIndex;

	public Human() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Human(double wieght, double height) {
		super();
		this.wieght = wieght;
		this.height = height;
	}

	public double getWieght() {
		return wieght;
	}

	public void setWieght(double wieght) {
		this.wieght = wieght;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getBodyMassIndex() {
		return bodyMassIndex;
	}

	public void setBodyMassIndex(double bodyMassIndex) {
		this.bodyMassIndex = bodyMassIndex;
	}

	@Override
	public String toString() {
		return "Human [wieght=" + wieght + ", height=" + height + ", bodyMassIndex=" + bodyMassIndex + "]";
	}

}
