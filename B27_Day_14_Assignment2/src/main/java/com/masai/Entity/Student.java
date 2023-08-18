package com.masai.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentCode;
	@Column(length = 50, nullable = false)
	private String email;
	@Column(length = 50, nullable = false)
	private String address;
	@Column(length = 30, nullable = false)
	private String course;
	@Column(nullable = false)
	private int level;

	public Student() {
		super();
	}

	public Student(String email, String address, String course, int level) {
		super();
		this.email = email;
		this.address = address;
		this.course = course;
		this.level = level;
	}

	public int getStudentCode() {
		return studentCode;
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

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "Student [studentCode=" + studentCode + ", email=" + email + ", address=" + address + ", course="
				+ course + ", level=" + level + "]";
	}

}
