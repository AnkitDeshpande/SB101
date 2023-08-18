package com.masai.first;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

	public static void findNegativeOnly(List<? extends Number> ls1, List<? extends Number> ls2,
			List<? super Number> num) {

		System.out.print("The first list is : ");
		ls1.stream().forEach(t -> System.out.print(t + " "));

		System.out.println();

		ls2.forEach(t -> System.out.print(t + " "));
		System.out.println();

		Predicate<Number> n1 = n -> n.doubleValue() < 0;
		System.out.print("The final list is : ");
		ls1.stream().filter(p -> p.doubleValue() < 0).collect(Collectors.toList())
				.forEach(n -> System.out.print(n + " "));
		ls2.stream().filter(p -> p.doubleValue() < 0).collect(Collectors.toList())
				.forEach(n -> System.out.print(n + " "));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> ls = new ArrayList<>();
		ls.add(-10);
		ls.add(20);
		ls.add(-30);
		ls.add(40);
		ls.add(-50);

		List<Double> ls2 = new ArrayList<>();
		ls2.add(10.0);
		ls2.add(-25.0);
		ls2.add(30.0);
		ls2.add(40.0);
		ls2.add(-55.0);

		List<Number> num = new ArrayList<>();

		findNegativeOnly(ls, ls2, num);
	}

}
