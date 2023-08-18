package com.masai;

@FunctionalInterface
interface Intr {
	void sayHello(String name);

	// void bar(int i);
	boolean equals(Object o);

	default void fun1() {
		System.out.println("Inside the default method fun1 of Intr");
	};

	static void fun2() {
		System.out.println("Inside the static method fun2 of Intr");
	}
}

interface Intr2 extends Intr {

}

public class FunctionInterfaceDemo implements Intr2 {
	@Override
	public void sayHello(String name) {
		System.out.println("Welcome " + name);
	}

	public static void main(String[] args) {
		Intr i1 = new FunctionInterfaceDemo();
		i1.sayHello("Ankit");

		Intr2 i2 = new FunctionInterfaceDemo();
		System.out.println(i1.equals(i2));

		i2.fun1();
		Intr.fun2();
	}
}