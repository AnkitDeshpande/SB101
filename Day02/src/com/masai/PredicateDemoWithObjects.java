package com.masai;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemoWithObjects {
	public static void main(String[] args) {
		List<Student> s = new ArrayList<>();

		s.add(new Student(1, "Ankit", 1000));
		s.add(new Student(2, "sanket", 900));
		s.add(new Student(3, "Balu", 450));
		s.add(new Student(4, "Ravi", 750));

		Predicate<Student> p = st -> st.getMarks() < 600;
		s.removeIf(p);

		for (Student s1 : s) {
			System.out.println(s1);
		}
	}
}
