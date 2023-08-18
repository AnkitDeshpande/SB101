package com.masai;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class PreClassDemo {

	public boolean myFun(Integer i) {
		return i > 0;
	}

	public static void main(String[] args) {
		Predicate<Integer> p1 = new PreClass();
		System.out.println(p1.test(0));

		// Lamda Expression
		Predicate<Integer> p2 = p -> p > 5;
		System.out.println(p2.test(12));

		// method reference
		Predicate<Integer> p3 = new PreClassDemo()::myFun;
		System.out.println(p3.test(5));

		// Student Object
		Predicate<Student> p4 = s -> s.getMarks() > 500;
		System.out.println(p4.test(new Student(1, "Ankit", 450)));

		// Iterable ---> java.lang.Iterable
		// public boolean removeIf(Predicate filter)

		List<Student> ls = new ArrayList<>();
		ls.add(new Student(1, "Ankit", 450));
		ls.add(new Student(2, "Sanket", 400));
		ls.add(new Student(1, "Balu", 350));
		ls.add(new Student(1, "Ravi", 500));

		System.out.println(ls);

		ls.removeIf(s -> s.getMarks() <= 350);

		System.out.println(ls);

//-----------------------------------------------------------------------------------------

		Consumer<Integer> c1 = new ConsumerEx();
		c1.accept(30);

		// lamda expression
		Consumer<Integer> c2 = n -> System.out.println(n + 20);
		c2.accept(80);
		System.out.println();

		// forEach(consumer)
		ls.forEach(n -> System.out.println(n.getMarks() + 50));
		System.out.println();
		ls.forEach(n -> System.out.println(n.getName().toUpperCase()));
		System.out.println();
//-----------------------------------------------------------------------------------------

		Supplier s1 = new SupplierEx();
		System.out.println(s1.get());

		// lamda Expression
		System.out.println();
		Supplier<Integer> s2 = () -> 100;
		System.out.println(s2.get());
		System.out.println();
		
		
//-----------------------------------------------------------------------------------------
		
		Function<String, Integer> f1 = new FunctionalEx();
		System.out.println(f1.apply("23")); // integer 23
		System.out.println();
		
		//lamda expression
		Function<String, Integer> f2 = s -> Integer.parseInt(s);
		System.out.println(f2.apply("56"));
//-----------------------------------------------------------------------------------------
	}

}
