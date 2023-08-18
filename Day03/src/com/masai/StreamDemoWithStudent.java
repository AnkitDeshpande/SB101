package com.masai;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemoWithStudent {
	public static void main(String[] args) {
		List<Student> ls = new ArrayList<>();

		ls.add(new Student(1, "Ankit", 1000));
		ls.add(new Student(2, "sanket", 900));
		ls.add(new Student(3, "Balu", 450));
		ls.add(new Student(4, "Ravi", 750));
		ls.add(new Student(5, "Kiran", 650));
		ls.add(new Student(6, "Rohit", 850));

		Stream<Student> st = ls.stream();
		Stream<Student> st2 = st.filter(s -> s.getMarks() > 500);
		st2.forEach(s -> System.out.println(s));

		System.out.println("=============================");

		Stream<Student> st1 = ls.stream();
		// the above line is important because we cannot pollute the line no 21 again.
		// creating new stream is important. if u try to use st.filter(.....), it will
		// throw exception.
		List<Student> l1 = st1.filter(s -> s.getMarks() <= 500).collect(Collectors.toList());
		System.out.println(l1);
		l1.forEach(s -> System.out.println(s.getName().toUpperCase()));

		System.out.println("=============================");
	}
}
