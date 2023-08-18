package assignment_no_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateConsumerDemo {
	static void displayCountryList(List<Country> list) {
		list.forEach(c -> System.out.println(
				c.getCountryName() + " from the " + c.getContinentName() + " of " + c.getArea() + " square KM"));
	}

	static List<Country> filterCountry(List<Country> list, Predicate<Country> filterByArea) {
		List<Country> ls = new ArrayList<>();

		for (Country c : list) {
			if (filterByArea.test(c)) {
				ls.add(c);
			}
		}

		return ls;
	}

	public static void main(String[] args) {
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
		List<Country> filtered = new ArrayList<>();
		do {
			System.out.println("1. By Area Range");
			System.out.println("2. By content in country name");
			System.out.println("3. By continent name");
			System.out.println("4. Clear Filter ");
			System.out.println("5. Print Country List");
			System.out.println("0. Exit");
			System.out.print("Enter selection ");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.print("Enter minimum area: ");
				double minArea = sc.nextDouble();
				System.out.print("Enter maximum area: ");
				double maxArea = sc.nextDouble();

				Predicate<Country> filterByArea = c -> c.getArea() >= minArea && c.getArea() <= maxArea
						&& c.getContinentName() == "Asia";
				filtered = filterCountry(countryList, filterByArea);
				filtered.forEach(c -> System.out.println(c.getCountryName() + " from the " + c.getContinentName()
						+ " of " + c.getArea() + " square KM"));

				break;
			case 2:
				System.out.println("Enter any character/string that country name has a");
				String str = sc.next();
				Predicate<Country> p1 = c -> c.getCountryName().contains(str);
				filtered = filterCountry(countryList, p1);
				filtered.forEach(c -> System.out.println(c.getCountryName() + " from the " + c.getContinentName()
						+ " of " + c.getArea() + " square KM"));
				break;
			case 3:
				System.out.println("Enter continent name :");
				String name = sc.next();

				Predicate<Country> p2 = c -> c.getContinentName().equals(name);
				filtered = filterCountry(countryList, p2);
				filtered.forEach(c -> System.out.println(c.getCountryName() + " from the " + c.getContinentName()
						+ " of " + c.getArea() + " square KM"));
			case 4:
				filtered = countryList;
				System.out.println("Filter cleared! you can add filter from start");
				break;
			case 5:
				displayCountryList(countryList);
				break;
			case 0:
				System.out.println("Have a nice day.");
				break;
			default:
				System.out.println("Invalid Choice.");
			}
		} while (choice != 0);
		sc.close();
	}
}
