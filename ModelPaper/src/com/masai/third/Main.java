package com.masai.third;

import com.masai.second.Student;
import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
interface StudRef {
	Student create(int rollNo, String name, String subject, double marks);
}

@FunctionalInterface
interface StudRef2 {
	int hash(Student s);
}

public class Main {
	public static void main(String[] args) {
		List<Student> ls = new ArrayList<>();
		StudRef StudRef = Student::new;
		ls.add(StudRef.create(1, "Ankit", "Science", 95));
		ls.add(StudRef.create(2, "Sanket", "Math", 94));
		ls.add(StudRef.create(3, "Balu", "Math", 90));
		ls.add(StudRef.create(4,"Ravi", "Science", 93));
		ls.add(StudRef.create(5, "Snehal", "History", 36));
		
		StudRef2 studRef2 = Student::hashCode;
		
		for(Student s: ls) {
			int hash = studRef2.hash(s);
			System.out.println(s+"-Hash Code : "+hash);
		}
		
	}
}
