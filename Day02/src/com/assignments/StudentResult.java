package com.assignments;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;


class Student {
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

public class StudentResult {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Student> ls = new ArrayList<>();

		Scanner sc = new Scanner(System.in);

		for (int i = 1; i <= 3; i++) {
			System.out.println("Enter details for student " + i + ":");
			System.out.print("Roll No.: ");
			int rollNo = sc.nextInt();
			System.out.print("Name: ");
			String name = sc.next();
			System.out.print("Marks: ");
			int marks = sc.nextInt();
			ls.add(new Student(rollNo, name, marks));
		}

		Function<List<Student>, Map<String, List<Student>>> category = t -> {
			Map<String, List<Student>> result = new HashMap<>();
			result.put("Fail", t.stream().filter(st -> st.getMarks() < 165).collect(Collectors.toList()));
			result.put("Pass",
					t.stream().filter(st -> st.getMarks() >= 165 && st.getMarks() < 400).collect(Collectors.toList()));
			result.put("Topper", t.stream().filter(st -> st.getMarks() >= 400).collect(Collectors.toList()));

			return result;
		};

		
		Consumer<Map<String, List<Student>>> csl = result -> {
			System.out.println("Topper students : ");
			result.get("Topper").forEach(st->System.out.println(st.getName()));
			System.out.println("Passed students : ");
			result.get("Pass").forEach(st->System.out.println(st.getName()));
			System.out.println("Failed students : ");
			result.get("Fail").forEach(st->System.out.println(st.getName()));
		};
		csl.accept(category.apply(ls));
	}

}
