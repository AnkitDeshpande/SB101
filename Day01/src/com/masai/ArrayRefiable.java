package com.masai;

/*
 * Object
 *		Number
 *			Integer
 *			Double
 */
public class ArrayRefiable {
	// referece variable: compile time
	// class-name ref-var-name;

	// object creation: run time
	// var-name = new class-name(arg-list);

	// class-name ref-var = new class-name(arg-list);

	// statement: compile will never have information about the data type of object
	// because object ois created at run time in java

	public static void main(String[] args) {
		// Super class reference variable can point to child class object
		// If S is super type, T is sub type then using reference variable of S we can
		// point to object of type T
		Number number; // reference variable of number class
		number = Integer.valueOf(10); // reference variable: Number object: Integer
		System.out.println(number);

		System.out.println();
		// ============================================================

		// Do the same for array also
		Number numArr[] = new Number[3]; // array of 3 references of number type
		numArr[0] = Integer.valueOf(100);
		numArr[1] = Float.valueOf(10.5f);
		numArr[2] = Double.valueOf(101.5);

		for (Number num : numArr) {
			System.out.println(num);
		}

		System.out.println();

		// ============================================================

		// If S is super type, T is sub type then using reference variable of S[] we can
		// point to object of type T[]
		Integer intArr[] = { 10, 20, 30, 40, 50 }; // Array of Integer object with 5 elements
		Number numbers[] = intArr;
		numbers[0] = 15;
		numbers[1] = 105.25; // Heap pollution, ArrayStoreException

		// type information for array is available to the run time system that's why the
		// run time system was able to
		// check for the heap pollution and generate exception
		// For any data type whose type information is available to the run time system
		// is called Refiable type.
		// Array is Refiable data type

		for (int i = 0; i < intArr.length; i++) {
			System.out.println(numbers[i] + " " + intArr[i]);
		}
	}
}
