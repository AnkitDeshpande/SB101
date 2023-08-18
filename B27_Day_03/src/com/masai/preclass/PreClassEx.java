package com.masai.preclass;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class PreClassEx {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("Ankit", "Sanket", "Ravi", "Balu", "Kiran");
		Stream<String> st = list.stream();
		Stream<String> strArr = st.filter(s -> s.length() % 2 != 0);
		strArr.forEach(s -> System.out.println(s));

		// ===================================================
		System.out.println();
		list.stream().filter(s -> s.length() % 2 != 0).forEach(s -> System.out.println(s.toUpperCase()));
		;
	}
}
