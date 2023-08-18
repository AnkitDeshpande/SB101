package com.masai.question2;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "used_car")
@NamedQuery(name = "findRange", query = "FROM Cars c where price between :start and :end")
@NamedNativeQuery(name = "findByName", query = "select company_name, model_name, price from used_car where model_name like :ch and company_name in :list")
public class Cars {
	@Id
	@Column(name = "registration_number", length = 15)
	private String regNo;
	@Column(name = "company_name", length = 10, nullable = false)
	private String CName;
	@Column(name = "model_name", length = 10, nullable = false)
	private String model;
	@Column(name = "mfg_year")
	private int mfgYear;
	@Column(precision = 8, scale = 2, nullable = false)
	private BigDecimal price;
	@Column(name = "seating_capacity")
	private int SCapacity;

	public Cars() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cars(String regNo, String cName, String model, int mfgYear, BigDecimal price, int sCapacity) {
		super();
		this.regNo = regNo;
		CName = cName;
		this.model = model;
		this.mfgYear = mfgYear;
		this.price = price;
		SCapacity = sCapacity;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public String getCName() {
		return CName;
	}

	public void setCName(String cName) {
		CName = cName;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getMfgYear() {
		return mfgYear;
	}

	public void setMfgYear(int mfgYear) {
		this.mfgYear = mfgYear;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getSCapacity() {
		return SCapacity;
	}

	public void setSCapacity(int sCapacity) {
		SCapacity = sCapacity;
	}

	@Override
	public String toString() {
		return "Cars [regNo=" + regNo + ", CName=" + CName + ", model=" + model + ", mfgYear=" + mfgYear + ", price="
				+ price + ", SCapacity=" + SCapacity + "]";
	}

}
