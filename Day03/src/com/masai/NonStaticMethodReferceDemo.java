package com.masai;

class SimpleInterest{
	double getAmtBySimpleInterest(double p, double t, double r) {
		double si = (p*r*t)/100;
		double amt = p+si;
		return Math.round(amt*100)/100.0;
	}
	
	double getAmtByCompoundInterest(double p, double t, double r) {
		double amt = p*Math.pow((1+r/100), t);
		return Math.round(amt*100)/100.0;
	}
}

interface LoanRepay{
	double getAmt(double p, double t, double r);
}

public class NonStaticMethodReferceDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleInterest s = new SimpleInterest();
//		LoanRepay li = SimpleInterest::getAmtBySimpleInterest;
	}

}
