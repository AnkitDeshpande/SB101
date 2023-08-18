package com.masai;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.function.Function;

public class FunctionFunctionalInterfaceDemo {
	public static void main(String[] args) {
		List<Student> s = new ArrayList<>();

		s.add(new Student(1, "Ankit", 1000));
		s.add(new Student(2, "sanket", 900));
		s.add(new Student(3, "Balu", 450));
		s.add(new Student(4, "Ravi", 750));
		
		Function<List<Student>,List<Integer>> f = list -> {
			List<Integer> markList = new ArrayList<>();
			for(Student st : s) {
				markList.add(st.getMarks());
			}
			return markList;  
		};
		
		List<Integer> markList = f.apply(s);
		for(Integer mark : markList) {
			System.out.println("Marks of Students are : "+mark);
		}
		
		System.out.println("======================================");
		
		Map<Integer, String> week = new HashMap<>();
		week.put(1, "Monday");
		week.put(2, "Tuesday");
		week.put(4, "Thursday");
		week.put(7, "Sunday");
		
		
		Function<Integer, String> f1 = dayNumber ->{
			String dayName = null;
			switch(dayNumber) {
				case 1 :
					dayName = "mon";
					break;
				case 2 :
					dayName = "tues";
					break;
				case 3 :
					dayName = "wed";
					break;
				case 4 :
					dayName = "thurs";
					break;
				case 5 :
					dayName = "fri";
					break;
				case 6 :
					dayName = "sat";
					break;
				case 7 :
					dayName = "sun";
					break;
			}
			return dayName;
		};
		System.out.println("Original map " + week);
	    week.computeIfAbsent(3, f1);	//return-value: Wed
	    //if key i not present then compute the key-value paiur using mapping function and add to map (computed value must not be null)
	    System.out.println("After adding 3 " +  week);
	    //if key is already present then also do nothing
	    week.computeIfAbsent(1, f1);	//return-value: monday
	    System.out.println("After adding 1 " +  week);
	    //if the computed value is null then do nothing
	    week.computeIfAbsent(8, f1);	//return-value: null
	    System.out.println("After adding 8 " +  week);
	}
}
