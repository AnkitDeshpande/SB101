package com.masai.third;

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
interface StudRef {
	Student create(int rollNo, String name, String subject, double marks);
}

@FunctionalInterface
interface StudRef2 {
	int hash(Student s);
}

public class Main {
	public static void main(String[] args) {

		List<Student> list = new ArrayList<>();
		StudRef sr = Student::new;

		list.add(sr.create(1, "Ankit", "Science", 95));
		list.add(sr.create(2, "Sanket", "Math", 94));
		list.add(sr.create(3, "Balu", "Math", 90));
		list.add(sr.create(4, "Ravi", "Science", 93));
		list.add(sr.create(5, "Snehal", "History", 36));

		list.forEach(System.out::println);
		System.out.println();

		StudRef2 sr2 = Student::hashCode;

		list.stream().forEach(st -> System.out.println(sr2.hash(st)));
	}
}
