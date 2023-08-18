package com.masai.functionalinterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import com.masai.preclass.*;

public class PredicateDemo2 {
	public static void main(String[] args) {
		List<Student> ls = new ArrayList<>();
		ls.add(new Student(1, "Ankit", 450));
		ls.add(new Student(2, "Sanket", 400));
		ls.add(new Student(1, "Balu", 350));
		ls.add(new Student(1, "Ravi", 500));

		Predicate<Student> p1 = p -> p.getMarks() <= 350;

		for (Student st : ls) {
			if (p1.test(st)) {
				System.out.println(st);
			}
		}

		System.out.println("-----------------------------------------------");
		
		for (Student st : ls) {
			System.out.println(st);
		}
		
		ls.removeIf(p1);   // removes, if satisfies the condition
		
		System.out.println("-----------------------------------------------");
		for (Student st : ls) {
			System.out.println(st);
		}
	}
}
