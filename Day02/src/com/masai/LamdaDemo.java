package com.masai;

@FunctionalInterface
interface Intr{
	void sayHello(String name);
}

public class LamdaDemo {
	public static void main(String[] args) {
		Intr i1 = (String name)->{
			System.out.println("Hello "+ name);
		};
		
		Intr i2 = name -> System.out.println("Hi "+name);
		
		i1.sayHello("Ankit");
		i2.sayHello("Ankit");
	}
}
