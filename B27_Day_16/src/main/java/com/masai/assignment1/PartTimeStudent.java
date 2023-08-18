/**
 * 
 */
package com.masai.assignment1;
//Entity class
public class PartTimeStudent extends MasaiStudent{

	private double fullTimeFee;
	
	public PartTimeStudent() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PartTimeStudent(String name, String address, double registrationFee) {
		super(name, address, registrationFee);
		// TODO Auto-generated constructor stub
	}

	
	public PartTimeStudent(double fullTimeFee) {
		super();
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
		// TODO Auto-generated method stub
		return 0;
	}

}