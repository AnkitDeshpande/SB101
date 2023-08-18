package com.masai.dto;

public class Lawyer {
	private int id;
	private String name;
	private String email;
	private String Address;
	private int exp;

	public Lawyer() {
		super();
	}

	public Lawyer(int id, String name, String email, String address, int exp) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		Address = address;
		this.exp = exp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	@Override
	public String toString() {
		return "Lawyer [id=" + id + ", name=" + name + ", email=" + email + ", Address=" + Address + ", exp=" + exp
				+ "]\n";
	}

}
