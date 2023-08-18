package com.masai.second;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@FunctionalInterface
interface fun {
	public Student createObject(String str);
}

@FunctionalInterface
interface fun2 {
	public Map<String, List<Student>> createMap(List<Student> studentList);
}

interface StudentOperations {
	void sortStudents(List<Student> students);

	void findStudent(List<Student> students, int rollNo);
}

public class Main {
	public static void main(String[] args) {

		List<Student> list = new ArrayList<>();

		fun f = str -> {
			String[] var = str.split(",");
			int id = Integer.valueOf(var[0]);
			String name = var[1];
			String Subject = var[2];
			double marks = Double.valueOf(var[3]);
			return new Student(id, name, Subject, marks);
		};

		/*
		 * Create a List of Student type and add 5 objects to it. Object of Student
		 * class should be taken from the lambda expression implemented above.
		 */
		list.add(f.createObject("6,Shiv,Maths,80.50"));
		list.add(f.createObject("1,Ankit,Science,80.50"));
		list.add(f.createObject("2,Sanket,Java,75.10"));
		list.add(f.createObject("3,Ravi,Science,78.49"));
		list.add(f.createObject("4,Balu,Maths,42.87"));
		list.add(f.createObject("5,Rutuja,Economics,67.77"));
		list.add(f.createObject("7,Rutuja,Java,67.77"));

		list.stream().forEach(System.out::println);
		System.out.println();

		/*
		 * Write implementation of the Function Functional interface using lambda
		 * function that takes List of Student as parameter and return a Map that has
		 * subject as key and Student(s) of that subject as value. A subject can have
		 * one or more Students. Print this Map.
		 */

		fun2 f2 = studentList -> studentList.stream().collect(Collectors.groupingBy(t -> t.getSubject()));
		f2.createMap(list).forEach((t, u) -> System.out.println("Key : " + t + " , " + "Value : " + u));
		System.out.println();

		/* Alternative method */
		Function<List<Student>, Map<String, List<Student>>> f3 = list1 -> {
			Map<String, List<Student>> map = new HashMap<>();

			for (Student s : list1) {
				String sub = s.getSubject();

				if (map.containsKey(sub)) {
					map.get(sub).add(s);
				} else {
					List<Student> newList = new ArrayList<>();
					newList.add(s);
					map.put(sub, newList);
				}
			}

			return map;
		};
		f3.apply(list).forEach((t, u) -> System.out.println("Key : " + t + " , " + "Value : " + u));
		System.out.println();

		/*
		 * (v) Create an interface that has two methods a. The first method accept a
		 * List of Student and sort the Students in descending order of marks, if marks
		 * are same then by descending order of name and then in descending order of
		 * rollNo. Use lambda expression implementation of functional interface (if used
		 * any functional interface)
		 * 
		 * b. The second method accept a List of Student and int rollNo, if Student with
		 * rollNo is found then print "Student found" otherwise print
		 * "Student not found".
		 */

		StudentOperations so = new StudentOperations() {

			@Override
			public void sortStudents(List<Student> students) {
				// TODO Auto-generated method stub
				students.stream()
						.sorted((s1, s2) -> s1.getMarks() == s2.getMarks()
								? s1.getName() == s2.getName() ? s1.getRollNo() > s2.getRollNo() ? 1 : 1 : -1
								: 1)
						.collect(Collectors.toList()).forEach(System.out::println);
			}

			@Override
			public void findStudent(List<Student> students, int rollNo) {
				// TODO Auto-generated method stub

				/*
				 * boolean found = students.stream().allMatch(student -> student.getRollNo() ==
				 * rollNo); System.out.println(found ? "Student Found" : "Student not found");
				 * 
				 * this can be written as below.
				 */

				System.out
						.println(students.stream().allMatch(student -> student.getRollNo() == rollNo) ? "Student Found"
								: "Student not found");

			}
		};
		so.sortStudents(list);
		System.out.println();
		so.findStudent(list, 1);
	}
}
