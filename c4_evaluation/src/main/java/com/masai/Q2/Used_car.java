package com.masai.Q2;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table
@NamedQuery(name = "findCarByYearAndPriceRange", query = "Select u from Used_car u where u.mfg_year = null and u.price between :s and :e")
public class Used_car {
	@Id
	@Column(length = 15)
	private String registration_number;
	@Column(length = 10, nullable = false)
	private String company_name;
	@Column(length = 10, nullable = false)
	private String model_name;
	@Column(nullable = true)
	private int mfg_year;
	@Column(scale = 2, precision = 8, nullable = false)
	private BigDecimal price;
	private int seating_capacity;

	public Used_car() {
		super();
	}

	public Used_car(String registration_number, String company_name, String model_name, int mfg_year, BigDecimal price,
			int seating_capacity) {
		super();
		this.registration_number = registration_number;
		this.company_name = company_name;
		this.model_name = model_name;
		this.mfg_year = mfg_year;
		this.price = price;
		this.seating_capacity = seating_capacity;
	}

	public String getRegistration_number() {
		return registration_number;
	}

	public void setRegistration_number(String registration_number) {
		this.registration_number = registration_number;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getModel_name() {
		return model_name;
	}

	public void setModel_name(String model_name) {
		this.model_name = model_name;
	}

	public int getMfg_year() {
		return mfg_year;
	}

	public void setMfg_year(int mfg_year) {
		this.mfg_year = mfg_year;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getSeating_capacity() {
		return seating_capacity;
	}

	public void setSeating_capacity(int seating_capacity) {
		this.seating_capacity = seating_capacity;
	}

	@Override
	public String toString() {
		return "Used_car [registration_number=" + registration_number + ", company_name=" + company_name
				+ ", model_name=" + model_name + ", mfg_year=" + mfg_year + ", price=" + price + ", seating_capacity="
				+ seating_capacity + "]";
	}

}
