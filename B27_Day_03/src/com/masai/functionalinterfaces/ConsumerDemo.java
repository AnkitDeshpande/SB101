package com.masai.functionalinterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import com.masai.preclass.Student;

class A implements Consumer<Integer>{

	@Override
	public void accept(Integer t) {
		System.out.println(t+t);
	}
	
}

public class ConsumerDemo {
	public static void main(String[] args) {
		Consumer<Integer> c1 = value -> System.out.println(value*value);
		c1.accept(20);
		System.out.println("-----------------------------------------");
		
		A a1 = new A();
		a1.accept(50);
		System.out.println("-----------------------------------------");
		
		List<Student> ls = new ArrayList<>();
		ls.add(new Student(1, "Ankit", 450));
		ls.add(new Student(2, "Sanket", 400));
		ls.add(new Student(1, "Balu", 350));
		ls.add(new Student(1, "Ravi", 500));
		
		ls.forEach(System.out::println);
		System.out.println("-----------------------------------------");
		
		//biconsumer
	}
}
