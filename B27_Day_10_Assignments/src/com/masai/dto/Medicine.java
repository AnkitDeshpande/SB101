package com.masai.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Medicine {
	private String medId; // VARCHAR(4)
	private String name; // VARCHAR(20)
	private String company; // VARCHAR(20)
	private BigDecimal pricePerUnit; // DECIMAL(6,2)
	private LocalDate mfgDate; // DATE
	private LocalDate expDate; // DATE

	public Medicine() {
		super();
	}

	public Medicine(String medId, String name, String company, BigDecimal pricePerUnit, LocalDate mfgDate,
			LocalDate expDate) {
		super();
		this.medId = medId;
		this.name = name;
		this.company = company;
		this.pricePerUnit = pricePerUnit;
		this.mfgDate = mfgDate;
		this.expDate = expDate;
	}

	public String getMedId() {
		return medId;
	}

	public void setMedId(String medId) {
		this.medId = medId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public BigDecimal getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(BigDecimal pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	public LocalDate getMfgDate() {
		return mfgDate;
	}

	public void setMfgDate(LocalDate mfgDate) {
		this.mfgDate = mfgDate;
	}

	public LocalDate getExpDate() {
		return expDate;
	}

	public void setExpDate(LocalDate expDate) {
		this.expDate = expDate;
	}

	@Override
	public String toString() {
		return "Medicine [medId=" + medId + ", name=" + name + ", company=" + company + ", pricePerUnit=" + pricePerUnit
				+ ", mfgDate=" + mfgDate + ", expDate=" + expDate + "]";
	}

}
