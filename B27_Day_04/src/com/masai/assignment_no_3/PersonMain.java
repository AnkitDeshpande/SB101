package com.masai.assignment_no_3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class PersonMain {
	public static void main(String[] args) {
		List<Person> personList = new ArrayList<>();

		personList.add(new Person("Aarav", 25, 50000.0));
		personList.add(new Person("Diya", 32, 70000.0));
		personList.add(new Person("Aryan", 40, 90000.0));
		personList.add(new Person("Ananya", 28, 60000.0));
		personList.add(new Person("Aadhya", 35, 80000.0));
		personList.add(new Person("Ishaan", 29, 65000.0));
		personList.add(new Person("Advait", 42, 95000.0));
		personList.add(new Person("Sara", 31, 75000.0));
		personList.add(new Person("Arya", 27, 55000.0));
		personList.add(new Person("Kavya", 33, 85000.0));

		// a. Filter the list to include only persons whose age is greater than or equal
		// to 30.
		System.out.println("list to include only persons whose age is greater than or equal to 30.");
		List<Person> filtered = personList.stream().filter(p -> p.getAge() >= 30).collect(Collectors.toList());
		filtered.stream().forEach(System.out::println);
		System.out.println();

		// b. Map the filtered list to a new list of strings containing only the names
		// of the persons.
		System.out.println("list of strings containing only the names :");
		List<String> names = filtered.stream().map(p -> p.getName()).collect(Collectors.toList());
		names.stream().forEach(System.out::println);

		System.out.println();

		// c. Skip the first 3 elements in the mapped list.
		System.out.println("Skiping first 3 :");
		List<String> skipped = names.stream().skip(3).collect(Collectors.toList());
		skipped.stream().forEach(System.out::println);
		System.out.println();

		// d. Sort the remaining elements in the mapped list in ascending order based on
		// the names.
		System.out.println("Sorted based on names : ");
		skipped.stream().sorted().forEach(System.out::println);
	}
}
