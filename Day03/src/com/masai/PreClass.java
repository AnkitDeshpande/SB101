package com.masai;

import java.util.*;
import java.util.stream.*;

public class PreClass {
	public static void main(String[] args) {
		List<String> ls = Arrays.asList("Java", "Python", "Spring", "Hibernate");
		Stream<String> st1 = ls.stream();
		// Stream<String> st2 = st1.filter(s -> s.length() % 2 != 0);
		// st2.forEach(s->System.out.println(s));

		// combining above 2 lines

		st1.filter(s -> s.length() % 2 != 0).forEach(s -> System.out.println(s));

		System.out.println("===================");

		Stream<String> st3 = ls.stream();
		st3.forEach(s -> System.out.println(s.toUpperCase()));

		System.out.println("===================");

		System.out.println(ls); // no effect on original list == op-> [Java, Python, Spring, Hibernate]
	}
}
