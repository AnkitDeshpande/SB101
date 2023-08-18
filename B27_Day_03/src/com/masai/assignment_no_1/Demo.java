package com.masai.assignment_no_1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Demo {
	public static void main(String[] args) {

		// 1. Create a List of 5 product objects.
		List<Product> list = new ArrayList<>();

		list.add(new Product(101, "Shreekhand", 15, 160));
		list.add(new Product(102, "Ice-Cream", 10, 30));
		list.add(new Product(104, "Shreekhand", 15, 160));
		list.add(new Product(105, "Milk-bags", 23, 25));
		list.add(new Product(103, "Good-day biscuits", 10, 10));

		// 2. From the product list filter the products whose quantity is more than 10
		// in a
		// separate List of Products.
		List<Product> ls = new ArrayList<>();
		ls = list.stream().filter(p -> p.getQuantity() > 10).collect(Collectors.toList());
		ls.forEach(i -> System.out.println(i));

		System.out.println("-------------------------------------------------------------------------------------");

		// 3. Sort the Filtered List of Products by the price in ascending order.
		List<Product> filteredList = ls.stream().sorted((p1, p2) -> p1.getPrice() > p2.getPrice() ? 1 : -1)
				.collect(Collectors.toList());

		System.out.println("-------------------------------------------------------------------------------------");

		// 4. Print all the products one by one from both Lists (original list and
		// Filtered
		// list)
		System.out.println("Original List : ");
		list.forEach(System.out::println);
		System.out.println();
		System.out.println("Filtered List : ");
		filteredList.forEach(System.out::println);
		System.out.println("-------------------------------------------------------------------------------------");
	}
}
