package assignment_no_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@FunctionalInterface
interface PrintList {
	void display(List<String> city);
}

public class PrintCities {
	public static void main(String[] args) {
		List<String> ls = Arrays.asList("Mumbai", "Delhi", "Kolkata", "Chennai", "Vishakhapatnam");

		PrintList p1 = (cities) -> cities.forEach(System.out::println);
		p1.display(ls);

	}
}
