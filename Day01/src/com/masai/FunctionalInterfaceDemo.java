package com.masai;

@FunctionalInterface
interface Intr1 {
	void sayHello(String name);
	// void sayHi(String name);

	boolean equals(Object o);

	default void fun1() {
		System.out.println("Inside fun1 of intr1");
	}

	static void fun2() {
		System.out.println("Inside fun2 of intr1");
	}
}

public class FunctionalInterfaceDemo {
	public static void main(String[] args) {
		Intr1 ii = new Intr1() { // class body starts here
			public void sayHello(String name) {
				System.out.println("Hello! " + name);
			}
		}; // class body ends here

		ii.sayHello("Masai");

		System.out.println(ii.equals(ii));

		ii.fun1();
		Intr1.fun2();

		Intr1 ij = new Intr1() { // class body starts here
			public void sayHello(String name) {
				System.out.println("Hi! " + name);
			}
		}; // class body ends here
		ij.sayHello("Sambhajinagar");
	}
}