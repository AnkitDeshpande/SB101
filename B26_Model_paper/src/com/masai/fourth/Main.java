package com.masai.fourth;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		List<Data> list = new ArrayList<>();

		list.add(new Data(9, 90.0f, "Ninth"));
		list.add(new Data(5, 50.0f, "Fifth"));
		list.add(new Data(6, 60.0f, "sixth"));
		list.add(new Data(4, 40.0f, "Fourth"));
		list.add(new Data(3, 30.0f, "Third"));
		list.add(new Data(1, 10.0f, "First"));
		list.add(new Data(8, 80.0f, "Eight"));
		list.add(new Data(2, 20.0f, "Second"));
		list.add(new Data(10, 100.0f, "Tenth"));
		list.add(new Data(7, 70.0f, "Seventh"));

		list.stream().sorted((d1, d2) -> d1.getFloatVar() > d2.getFloatVar() ? 1 : -1).skip(2).limit(5)
				.forEach(System.out::println);
		System.out.println();

		System.out
				.println("Sum of all Integer values is : " + list.stream().mapToInt(value -> value.getIntVar()).sum());
		System.out.println();

		System.out.println(
				"Sum of all float values is : " + list.stream().mapToDouble(value -> value.getFloatVar()).sum());
		System.out.println();

	}
}
