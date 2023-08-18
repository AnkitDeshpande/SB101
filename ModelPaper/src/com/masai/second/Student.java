package com.masai.second;

import java.util.Objects;

public class Student {
	private int rollNo;
	private String name;
	private String subject;
	private double marks;

	public Student(int rollNo, String name, String subject, double marks) {
		this.rollNo = rollNo;
		this.name = name;
		this.subject = subject;
		this.marks = marks;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public double getMarks() {
		return marks;
	}

	public void setMarks(double marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Roll No: " + rollNo + ", Name: " + name + ", Subject: " + subject + ", Marks: " + marks + "\n";
	}

	@Override
	public int hashCode() {
		return Objects.hash(marks, name, rollNo, subject);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Double.doubleToLongBits(marks) == Double.doubleToLongBits(other.marks)
				&& Objects.equals(name, other.name) && rollNo == other.rollNo && Objects.equals(subject, other.subject);
	}
	
}
