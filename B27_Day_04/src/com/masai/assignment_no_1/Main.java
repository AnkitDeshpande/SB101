package com.masai.assignment_no_1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Customer> customerList = new ArrayList<>();

		// Create 10 customers and add them to the list
		customerList.add(new Customer("Rahul Sharma", 25, "Male", "Mumbai"));
		customerList.add(new Customer("Priya Patel", 30, "Female", "Delhi"));
		customerList.add(new Customer("Amit Singh", 35, "Male", "Bangalore"));
		customerList.add(new Customer("Neha Gupta", 28, "Female", "Kolkata"));
		customerList.add(new Customer("Rajesh Kumar", 40, "Male", "Chennai"));
		customerList.add(new Customer("Pooja Mehta", 22, "Female", "Hyderabad"));
		customerList.add(new Customer("Sanjay Verma", 33, "Male", "Ahmedabad"));
		customerList.add(new Customer("Anjali Sharma", 27, "Female", "Pune"));
		customerList.add(new Customer("Vikram Singh", 31, "Male", "Jaipur"));
		customerList.add(new Customer("Sneha Joshi", 29, "Female", "Lucknow"));

		// Create a list of customer with and 10 customers and filter out all customers
		// who are above 30 years of age.

		customerList.stream().filter(ct -> ct.getAge() > 30).forEach(System.out::println);
		System.out.println();

		// Extract the names of all the customers and store them in a new list.
		System.out.println("Names of all the customers :");
		List<String> names = customerList.stream().map(ct -> ct.getName()).collect(Collectors.toList());
		names.stream().forEach(System.out::println);
		System.out.println();

		// Create the customers in the descending order of their age.
		System.out.println("Customers in descending order of their age :");
		customerList.stream().sorted((c1, c2) -> c1.getAge() > c2.getAge() ? -1 : 1).collect(Collectors.toList())
				.forEach(System.out::println);
	}
}
