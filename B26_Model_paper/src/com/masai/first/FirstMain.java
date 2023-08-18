package com.masai.first;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FirstMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Create a List of Integer values such that it has some positive and some
		 * negative values. Create a List of Double values such that it has some
		 * positive and some negative values. Create an empty List of Number types.
		 */
		List<Integer> intList = Arrays.asList(-25, -65, -74, -12, -43, -95, 2, 6, 598, 7, 6, 54, 12, 4, -14, -36, -27);
		List<Double> douList = Arrays.asList(-20.5, -62.5, -78.4, -10.2, -49.3, -93.5, 20.6, 69.4, 598.7, 7.2, 6.8);
		List<Number> numList = new ArrayList<>();

		/*
		 * Call findNegativeOnly method from the main method & print elements of the
		 * third list
		 */
		findNegativeOnly(intList, douList, numList);
	}

	/*
	 * Create a method findNegativeOnly that will copy only negative elements from
	 * the both the list (of Integer values & Double values) and write to the third
	 * list (of Number). The method has three parameters such that a. The first &
	 * the second parameter can point to list of Integer type as well of Double type
	 * b. The third parameter can point to list of Number type or its super type
	 */
	private static void findNegativeOnly(List<Integer> intList, List<Double> douList, List<? super Number> numList) {
		// TODO Auto-generated method stub
		System.out.print("The first list is : ");
		intList.stream().forEach(t -> System.out.print(t + " "));
		System.out.println();

		System.out.print("The second list is : ");
		douList.stream().forEach(t -> System.out.print(t + " "));
		System.out.println();

		numList.addAll(intList.stream().filter(i -> i < 0).collect(Collectors.toList()));
		numList.addAll(douList.stream().filter(i -> i < 0).collect(Collectors.toList()));

		System.out.print("The negative elements are : ");
		numList.stream().forEach(t -> System.out.print(t + " "));
	}

}
