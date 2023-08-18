package com.assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

class Country {

	private String countryName;
	private String continentName;
	private double area;

	public Country(String countryName, String continentName, double area) {
		super();
		this.countryName = countryName;
		this.continentName = continentName;
		this.area = area;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getContinentName() {
		return continentName;
	}

	public void setContinentName(String continentName) {
		this.continentName = continentName;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

}

public class PredicateConsumerDemo {
	
	static void displayCountryList(List<Country> list) {
		
	}
	
	static List<Country> filterCountry(List<Country> list, Predicate<Country> filterByArea){
		return list;
	}
	
	public static void main(String args[]) {
		// TODO Auto-generated method stub
		List<Country> countryList = new ArrayList<>();
		// Add countries from Asia
		countryList.add(new Country("China", "Asia", 9596961));
		countryList.add(new Country("Japan", "Asia", 377975));
		countryList.add(new Country("India", "Asia", 3287263));
		countryList.add(new Country("Russia", "Asia", 17098246));

		// Add countries from Europe
		countryList.add(new Country("Belgium", "Europe", 30528));
		countryList.add(new Country("Denmark", "Europe", 43094));
		countryList.add(new Country("Germany", "Europe", 357168));
		countryList.add(new Country("Norway", "Europe", 385203));

		// Add countries from Africa
		countryList.add(new Country("Egypt", "Africa", 1010408));
		countryList.add(new Country("Morocco", "Africa", 446300));
		countryList.add(new Country("South Africa", "Africa", 1221037));
		countryList.add(new Country("Kenya", "Africa", 580367));

		Scanner sc = new Scanner(System.in);
		int choice = -1;
		do {
			System.out.println("1. By Area Range");
			System.out.println("2. By content in country name");
			System.out.println("3. By continent name");
			System.out.println("4. Clear Filter ");
			System.out.println("5. Print Country List");
			System.out.println("0. Exit");
			System.out.print("Enter selection ");
			choice = sc.nextInt();
			// write code here as per the instructions given below
		} while (choice != 0);
		sc.close();
	}

}
