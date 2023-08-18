package com.masai;

import java.util.List;

public class intermediateOps {
	public static void main(String[] args) {
		List<Integer> list = List.of(2, 1, 3, 4, 5, 1, 2, 3, 4, 6, 4, 8, 6, 1, 3, 6, 1, 3, 2, 1);
		list.stream().distinct().sorted().forEach(System.out::println);
		System.out.println();

		// filter
		list.stream().filter(i -> i % 2 == 0).distinct().forEach(System.out::println);
		System.out.println();

		List<String> list1 = List.of("mumbai", "Delhi", "kolkata", "Chennai");
		list1.stream().map(str -> str.toUpperCase()).forEach(i -> System.out.println(i));
		System.out.println();

		// reduce
		System.out.println(list.stream().reduce((n, m) -> n + m));
	}
}