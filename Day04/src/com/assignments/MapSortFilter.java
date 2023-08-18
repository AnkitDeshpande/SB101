package com.assignments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Customer {
    private String name;
    private int age;
    private String gender;
    private String city;
	public Customer(String name, int age, String gender, String city) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.city = city;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                " age=" + age +
                " gender=" + gender + '\'' +
                " city=" + city + '\'' +
                "}\n";
    }

    
}

public class MapSortFilter {
	public static void main(String[] args) {
		List<Customer> ls = Arrays.asList(new Customer("Ankit", 25, "Male", "Sambhajinagar"),
				new Customer("Rutuja", 24, "Female", "Nagpur"), new Customer("Sanket", 29, "Male", "Pune"),
				new Customer("Anusha", 21, "Female", "Hyderabad"), new Customer("Prabhas", 36, "Male", "Delhi"),
				new Customer("Samntha", 38, "Female", "Chennai"), new Customer("Rajnikanth", 75, "Male", "Vizag"),
				new Customer("Kajal", 24, "Female", "Mumbai"), new Customer("Yash", 37, "Male", "Bangaluru"),
				new Customer("Snehal", 39, "Female", "Hingoli"));

		Predicate<Customer> p = i -> i.getAge() > 30;

		List<Customer> filtered = ls.stream().filter(p).collect(Collectors.toList());
		List<String> mapped = ls.stream().map(Customer::getName).collect(Collectors.toList());
		List<Customer> sorted = ls.stream().sorted(new Comparator<Customer>() {
			@Override
			public int compare(Customer c1, Customer c2) {
				
				if(c1.getAge()>c2.getAge()) {
					return -1;
				}else if(c1.getAge()<c2.getAge()) {
					return 1;
				}
				return 0;
				
			}
		}).collect(Collectors.toList());
		
		System.out.println("Filtered customers: " + filtered);
		System.out.println("Customer names: " + mapped);
		System.out.println("Sorted customers: " + sorted);
	}
}
