package com.masai;

@FunctionalInterface // functional Interface can only have 1 abstract method
interface inter {
	public int findSum();
}

class impleMentClass implements inter {

	@Override
	public int findSum() {
		// TODO Auto-generated method stub
		return 23 + 45;
	}

}

public class FunctionalProgramming {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		inter i1 = new inter() {

			@Override
			public int findSum() {
				// TODO Auto-generated method stub
				return 90 + 30;
			}

		};
		System.out.println(i1.findSum());

		inter i2 = () -> 34 + 45;
		System.out.println(i2.findSum());
	}

}
