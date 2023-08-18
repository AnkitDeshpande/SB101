package com.masai.dto;

public class Lawyer {
	private int id;
	private String name;
	private String email;
	private String address;
	private int experience;

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
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public Lawyer(int id, String name, String email, String address, int experience) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.experience = experience;
	}

	public Lawyer() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Lawyer Details:\n");
		sb.append("ID: ").append(id).append("\n");
		sb.append("Name: ").append(name).append("\n");
		sb.append("Email: ").append(email).append("\n");
		sb.append("Address: ").append(address).append("\n");
		sb.append("Experience: ").append(experience).append(" years\n");
		sb.append("---------------------------------------");
		return sb.toString();
	}

}
