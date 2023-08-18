package com.masai.supplier;

import java.util.function.Supplier;

public class SupplierEx2 {
	private void calculateFactorial(int n) {
		int fact = 1;
		for (int i=1; i<=n; i++) {
			fact *= i;
		}
		System.out.println(fact);
	}
	
//	private static Supplier<Integer> calculate() {
//		Supplier<Integer> fact = 1;
//		for (int i=1; i<=n; i++) {
//			fact *= i;
//		}
//		return fact;
//	}
	public static void main(String[] args) {
		SupplierEx2 s1 = new SupplierEx2();
		s1.calculateFactorial(5);
		System.out.println("-----------------");
//		Supplier<Integer> s1 = calcul
	}
}
