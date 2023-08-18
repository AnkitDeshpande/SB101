package com.masai.assignment_no_2;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FruitMain {
	public static void main(String[] args) {
		List<Fruit> fruits = Arrays.asList(new Fruit("Orange", 10, 89), new Fruit("Papaya", 20, 90),
				new Fruit("Apple", 10, 45), new Fruit("Watermelon", 10, 56), new Fruit("Guava", 10, 40),
				new Fruit("Pomegranate", 10, 200));

		// (i) Generate a Map using Stream API that contains fruit name as key and total
		// price of that fruit (price * quantity) as value
		Map<String, Integer> map = fruits.stream()
				.collect(Collectors.toMap(Fruit::getName, f -> f.getQuantity() * f.getPrice()));

		map.forEach((key, value) -> System.out.println(key + " : " + value));
		System.out.println();

		// (ii) compute total price of each product (that is price * quantity) and then
		// find total price for all fruits using Stream
		int sum = fruits.stream().mapToInt(fr -> fr.getQuantity() * fr.getPrice()).sum();
		System.out.println("Sum of all the products :" + sum);
		System.out.println();

		/*
		 * // (iii) find all fruits whose per kg price is more than or same as 50/-,
		 * sort // the filtered list according to natural ordering and then print the
		 * third and // the fourth fruit details
		 */
		fruits.stream().filter(fr -> fr.getPrice() > 50).sorted((f1, f2) -> f1.getPrice() > f2.getPrice() ? 1 : -1)
				.forEach(System.out::println);
		System.out.println();
	}
}
