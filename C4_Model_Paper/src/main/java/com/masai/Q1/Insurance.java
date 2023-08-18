package com.masai.Q1;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Embeddable
public class Insurance {
	private String policyName;
	private String companyName;
	private int annualPremium;
	
	
	public Insurance() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Insurance(String policyName, String companyName, int annualPremium) {
		super();
		this.policyName = policyName;
		this.companyName = companyName;
		this.annualPremium = annualPremium;
	}
	public String getPolicyName() {
		return policyName;
	}
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public int getAnnulaPremium() {
		return annualPremium;
	}
	public void setAnnulaPremium(int annulaPremium) {
		this.annualPremium = annulaPremium;
	}
	@Override
	public String toString() {
		return "Insurance [policyName=" + policyName + ", companyName=" + companyName + ", annulaPremium="
				+ annualPremium + "]";
	}
	
}
