package com.masai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToDoubleBiFunction;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTerminalOps {
	public static void main(String[] args) {
		List<Integer> ls = Arrays.asList(1, 1, 2, 3, 4, 5);
		Stream<Integer> st = ls.stream();

		// consumer --void accept(T t)
		Consumer<Integer> c = i -> System.out.print(i + " ");
		st.forEach(c);
		System.out.println("==============================");

		Predicate<Integer> p = i -> i % 2 == 0;

		System.out.println("Every elements matches the given predicate? ->" + ls.stream().allMatch(p));
		System.out.println("any elements matches the given predicate? ->" + ls.stream().anyMatch(p));
		System.out.println("no elements matches the given predicate? ->" + ls.stream().noneMatch(p));
		System.out.println("count elements stream ->" + ls.stream().count());

		System.out.println("==============================");

		BinaryOperator<Integer> bo = (i1, i2) -> i1 + i2;
		BinaryOperator<Integer> bo1 = (i1, i2) -> i1 * i2;
		System.out.println("Addition of all numbers -> " + ls.stream().reduce(0, bo));
		System.out.println("Multiplication of all numbers -> " + ls.stream().reduce(1, bo1));

		System.out.println("==============================");

		ToDoubleFunction<Integer> tdf = i -> i * 1.00;
		System.out.println(ls.stream().collect(Collectors.averagingDouble(tdf)));
		System.out.println(
				Arrays.asList(1.5, 2.5, 1.5, 6.3).stream().collect(Collectors.averagingInt(i -> i.intValue())));
		System.out.println(ls.stream().collect(Collectors.summingDouble(tdf)));
		System.out
				.println(Arrays.asList(1.5, 2.5, 1.5, 6.3).stream().collect(Collectors.summingInt(i -> i.intValue())));

		System.out.println("==============================");

		ls.stream().distinct().toList().forEach(i -> System.out.print(i + " "));

		System.out.println();
		System.out.println("==============================");

		List<Student> s = new ArrayList<>();

		s.add(new Student(1, "Ankit", 1000));
		s.add(new Student(2, "sanket", 900));
		s.add(new Student(3, "Balu", 450));
		s.add(new Student(4, "Ravi", 750));
		
		Function<Student, Integer> keyMapper = Student::getRoll;
		Function<Student, String> valueMapper = Student::getName;
		
		Map<Integer, String> map = s.stream().collect(Collectors.toMap(keyMapper, valueMapper));
		System.out.println(map);
//		map.forEach((K, V)->System.out.println());

	}
}
