package com.masai;

import java.util.ArrayList;
import java.util.List;

public class ContraVarianceDemo {

	static void copy(List<? extends Number> source, List<? super Number> destination) {
		// List<? super Number> destination
		// the variable destination can point to List of Number or List of any super
		// type of Number
		// No reading operation is allowed (except for when using reference variable of
		// Object class)
		// Writing operation is allowed but you can add object of Number or its subclass
		// but not of any super class
		for (Number num : source) { // contraVariance cannot perform read operation b ut can perfrom write operation
									// i.e opposite of coVariance.
			destination.add(num);
		}
	}

	public static void main(String[] args) {
		List<Integer> intList = new ArrayList<>();
		intList.add(10);
		intList.add(20);
		intList.add(30);
		intList.add(40);
		intList.add(50);

		List<Object> objList = new ArrayList<>();

		copy(intList, objList);

		List<Long> longList = new ArrayList<>();
		longList.add(10000L);
		longList.add(20000L);
		longList.add(30000L);
		longList.add(40000L);
		longList.add(50000L);

		List<Number> numList = new ArrayList<>();
		copy(longList, numList);
		System.out.println(objList);
		System.out.println(numList);
	}
}
