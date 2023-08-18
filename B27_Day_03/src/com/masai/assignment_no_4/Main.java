package com.masai.assignment_no_4;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

	static void printStudents(List<Student> studentList, Predicate<Student> p1, Predicate<Student> p2) {
		List<Student> stList1 = studentList.stream().filter(p1).collect(Collectors.toList());

		List<Student> stList2 = stList1.stream().filter(p2).collect(Collectors.toList());

		Consumer<Student> c1 = st -> System.out.println(st);
		
		stList2.forEach(c1);
	}

	public static void main(String[] args) {
		List<Student> list = new ArrayList<>();

		list.add(new Student("Ankit", 25, 80.70));
		list.add(new Student("Sanket", 15, 80.00));
		list.add(new Student("Balu", 17, 65.50));
		list.add(new Student("Ravi", 19, 88.50));
		list.add(new Student("Rutuja", 22, 45.5));
		list.add(new Student("Snehal", 25, 50.67));
		list.add(new Student("Abhi", 16, 35.00));
		list.add(new Student("Rohit", 35, 30.59));
		list.add(new Student("Virat", 35, 60.70));
		list.add(new Student("Dhoni", 40, 96.70));

		Predicate<Student> p1 = st -> st.getAge() < 20;

		Predicate<Student> p2 = st -> st.getGrade() >= 80;

		printStudents(list, p1, p2);

	}
}