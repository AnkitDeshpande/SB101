package in_class_examples;

import java.util.ArrayList;
import java.util.List;

public class ContraVarianceEx {

	static void copy(List<? extends Number> source, List<? super Number> destination) {
		// in Contravariance reading is not allowed but writing is allowed.(Except in
		// the reference variable of Object class)
		for(Number s : source) {
			destination.add(s);
		}
		System.out.println(destination);
	}

	public static void main(String[] args) {
		List<Integer> intList = new ArrayList<>();
		intList.add(10);
		intList.add(20);
		intList.add(30);
		intList.add(40);
		intList.add(50);

		List<Long> longList = new ArrayList<>();
		longList.add(100000L);
		longList.add(1020000L);
		longList.add(168000L);
		longList.add(1098000L);
		longList.add(1075100L);

		List<Object> ls = new ArrayList<>();
		List<Number> ls1 = new ArrayList<>();
		
		copy(intList, ls);
		copy(longList, ls1);
	}
}
