package com.masai;

import java.util.function.Predicate;

public class PredicateDemo {
	public static void main(String[] args) {
		String s = "Ankit";
		
		Predicate<String> p = str -> str.length()>=6;
		
		System.out.println(p.test(s));
		System.out.println(p.test("Rohit@45"));
	}
}
