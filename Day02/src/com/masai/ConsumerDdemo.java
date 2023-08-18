package com.masai;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
public class ConsumerDdemo {
	public static void main(String[] args) {
		Consumer<Integer> c = a -> System.out.println(a*a);
		c.accept(0);
		c.accept(-10);
		
		
		//==========================
		System.out.println("==============================");
		
		List<Student> s = new ArrayList<>();

		s.add(new Student(1, "Ankit", 1000));
		s.add(new Student(2, "sanket", 900));
		s.add(new Student(3, "Balu", 450));
		s.add(new Student(4, "Ravi", 750));
		
		//for (Student s1 : s) {
			//System.out.println(s1.getName() + " of roll No " + s1.getRoll() + " has marks "+s1.getMarks());
		//}
		
		Consumer<Student> c1 = s1 ->  System.out.println(s1.getName() + " of roll No " + s1.getRoll() + " has marks "+s1.getMarks());
		s.forEach(c1);
		
		System.out.println("==============================");
		//bionsumer example
		Map<String, Double> map = new HashMap<>();
		map.put("Bharat", 3246562.22);
		map.put("USA", 224662.22);
		map.put("Russia", 5246562.22);
		map.put("Japan", 1246562.22);
		
		BiConsumer<String, Double> bic = (name, area) -> System.out.println("Area of "+name+" is " + area);
		map.forEach(bic);
	}
}
