package com.masai.functionalinterfaces;

import java.util.function.Predicate;

public class PredicateDemo {
	public static void main(String[] args) {
		Predicate<Integer> intPredicate = i -> i >= 18;
		System.out.println(intPredicate.test(20)?"Eligible":"Not eligible");
	}
}
