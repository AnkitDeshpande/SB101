package com.masai;

import java.util.*;

public class CollectionNonRefiable {

	public static void main(String[] args) {

		List<Integer> intList = new ArrayList<>();
		intList.add(10);
		intList.add(20);
		intList.add(30);
		intList.add(40);
		intList.add(50);
		// intList.add("23"); type information is available to compiler for collection
		// objects

		List<Number> numList;
		// numList = intList; //Type mismatch: cannot convert from List<Integer> to
		// List<Number>

		// type erasure: Once compilation is done then the type information about the
		// collection object of
		// dropped by compiler because it is too heavy to maintain and ultimately leads
		// to poor performance of the system.
		// So type information about the collection object is not available to the run
		// time system
		// that's why collection is called Non-Refiable type.

		// why this behavior
		// say this statement works
		// numList = intList;
		// numList.add(10.05); //heap pollution, run time system will not be able to
		// find it because no type information
		// for(Integer i: intList){ //ClassCastException
		// System.out.println(i);
		// }
	}

}
