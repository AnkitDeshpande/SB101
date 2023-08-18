package com.masai.preclass;

import java.util.ArrayList;
import java.util.List;

public class Student {
	private int roll;
	private String name;
	private int marks;

	public Student(int roll, String name, int marks) {
		super();
		this.roll = roll;
		this.name = name;
		this.marks = marks;
	}

	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student [roll=" + roll + ", name=" + name + ", marks=" + marks + "]";
	}
}

class Main {
	public static void main(String[] args) {
		List<Student> ls = new ArrayList<>();
		ls.add(new Student(1, "Ankit", 450));
		ls.add(new Student(2, "Sanket", 400));
		ls.add(new Student(1, "Balu", 350));
		ls.add(new Student(1, "Ravi", 500));

		ls.stream().filter(st -> st.getMarks() >= 400).forEach(System.out::println);
		System.out.println();
		ls.stream().filter(st -> st.getMarks() <= 400).sorted((a, b) -> a.getMarks() >= b.getMarks() ? -1 : 1) // descending order
				.forEach(System.out::println);
	}
}
