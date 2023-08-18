package com.masai.Question1;

import java.util.ArrayList;
import java.util.List;

public class PartB {
	static void getExceptionList(Exception[] exArr, List<? super Exception> Ex1, List<? super RuntimeException> Ex2) {
		for (Exception e : exArr) {
			if (e.getClass().equals(ArithmeticException.class)) {
				Ex1.add(e);
			} else {
				Ex2.add((RuntimeException) e);
			}
		}
	}

	static void printExceptionList(List<? extends Throwable> thr) {
		thr.stream().forEach(th -> System.out.println(th.getMessage()));
		System.out.println();
	}

	public static void main(String[] args) {
		Exception[] exArr = new Exception[6];
		exArr[0] = new RuntimeException("RE1");
		exArr[1] = new RuntimeException("RE2");
		exArr[2] = new ArithmeticException("AE1");
		exArr[3] = new ArithmeticException("AE2");
		exArr[4] = new ArithmeticException("AE3");
		exArr[5] = new ArithmeticException("AE4");

		List<Exception> Ex1 = new ArrayList<>();
		List<Exception> Ex2 = new ArrayList<>();

		getExceptionList(exArr, Ex1, Ex2);

		printExceptionList(Ex1);

		printExceptionList(Ex2);
	}
}
