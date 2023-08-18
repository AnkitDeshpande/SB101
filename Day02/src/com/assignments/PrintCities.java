package com.assignments;

import java.util.List;
import java.util.ArrayList;

@FunctionalInterface
interface PrintList {
	void display(List<String> city);
}

public class PrintCities {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> ls = new ArrayList<>();
		ls.add("Sambhajinagar");
		ls.add("Mumbai");
		ls.add("Delhi");
		ls.add("Pune");
		ls.add("Bengaluru");

		PrintList p = city -> ls.forEach(System.out::println);
		
		p.display(ls);
	}

}
