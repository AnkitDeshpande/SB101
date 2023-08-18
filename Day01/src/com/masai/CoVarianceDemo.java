package com.masai;

import java.util.ArrayList;
import java.util.List;

public class CoVarianceDemo {
	public static void main(String[] args) {
		List<Integer> intList = new ArrayList<>();
		intList.add(10);
		intList.add(20);
		intList.add(30);
		intList.add(40);
		intList.add(50);

		// Create a List that can point to List of Number class or any subclass of
		// Number class
		// List<Number> numLst = intList;
		List<? extends Number> numList = intList; // this is called upper bound
		for (Number num : numList) {
			System.out.print(num + " ");
		}

//		numList.add(60, null);
//		numList.add(60.05);

		// setback of coVariance is we can only perform read operation. no write
		// operation. thats why we get error in line no 22 and 23.

		// Why no addition in allowed?
		// if compiler allow addition then user can add int value of List<? extends
		// Number>
		// or user can add any subtype also that may leads to heap pollution in the long
		// run
		// due to type erasure, no type information is available to the run time so no
		// detection of the heap pollution
		// in future while reading, we may end up with ClassCastException.
		// setback of coVariance is we can only perform read operation. no write
		// operation.
	}
}