package com.masai.Q1part2;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String companyName;
	private int ESTDYear;

	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "companyName")
	private Set<Mobile> mobile = new HashSet<>();

	public Set<Mobile> getMobile() {
		return mobile;
	}

	public void setMobile(Set<Mobile> mobile) {
		this.mobile = mobile;
	}

	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Company(String companyName, int eSTDYear) {
		super();
		this.id = id;
		this.companyName = companyName;
		ESTDYear = eSTDYear;
	}

	public int getId() {
		return id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getESTDYear() {
		return ESTDYear;
	}

	public void setESTDYear(int eSTDYear) {
		ESTDYear = eSTDYear;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", companyName=" + companyName + ", ESTDYear=" + ESTDYear + "]";
	}

}
