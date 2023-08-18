package com.masai.Q1part2;

import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Mobile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String modelNumber;
	private int price;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CompanyId")
	public Company companyName;
	
	public Mobile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Mobile(String modelNumber, int price) {
		super();
		this.modelNumber = modelNumber;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public String getModelNumber() {
		return modelNumber;
	}

	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Mobile [id=" + id + ", modelNumber=" + modelNumber + ", price=" + price + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, modelNumber, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mobile other = (Mobile) obj;
		return Objects.equals(companyName, other.companyName) && id == other.id && modelNumber == other.modelNumber
				&& price == other.price;
	}
	
	
}
