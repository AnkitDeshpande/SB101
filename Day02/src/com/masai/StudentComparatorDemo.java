package com.masai;
import java.util.*;
public class StudentComparatorDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Student> s = new ArrayList<>();
		
		s.add(new Student(1,"Ankit",1000));
		s.add(new Student(2,"sanket",900));
		s.add(new Student(3,"Balu",450));
		s.add(new Student(4,"Ravi",750));
		
		//Collections.sort(s, new Comparator<Student>()->(Student o1, Student o2) o2.getMarks()-o1.getMarks(););
	}

}
