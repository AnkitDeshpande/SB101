package com.masai.second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@FunctionalInterface
interface Intr {
	Student convert(String str);
}

interface intr2 {
	void arrange(List<Student> list);

	void print(List<Student> list, int roll);
}

public class Main {
	public static void main(String[] args) {

		Intr i = (String str) -> {
			String[] arr = str.split(",");
			int rollNo = Integer.parseInt(arr[0]);
			String name = arr[1];
			String subject = arr[2];
			double marks = Double.parseDouble(arr[3]);
			return new Student(rollNo, name, subject, marks);
		};

		List<Student> ls = new ArrayList<>();
		ls.add(i.convert("1,Ankit,Science,98"));
		ls.add(i.convert("2,Sanket,science,95"));
		ls.add(i.convert("3,Balu,Maths,94"));
		ls.add(i.convert("4,Ravi,History,95"));
		ls.add(i.convert("5,Snehal,History,97"));

		Function<List<Student>, Map<String, List<Student>>> f = list -> {
			Map<String, List<Student>> map = new HashMap<>();

			for (Student s : list) {
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

		Map<String, List<Student>> map = f.apply(ls);
		for (Map.Entry<String, List<Student>> entry : map.entrySet()) {
			String subject = entry.getKey();
			List<Student> subjectStudents = entry.getValue();
			System.out.println("Subject: " + subject);
			for (Student s : subjectStudents) {
				System.out.println(s);
			}
			System.out.println();
		}

		System.out.println("==========================================");

		intr2 i2 = new intr2() {

			@Override
			public void print(List<Student> list, int roll) {
				// TODO Auto-generated method stub
				boolean found = list.stream().anyMatch(i -> i.getRollNo() == roll);
				if (found) {
					System.out.println("Student found");
				} else {
					System.out.println("Student not found");
				}
			}

			@Override
			public void arrange(List<Student> list) {
				// TODO Auto-generated method stub
				list.stream()
						.sorted(Comparator.comparingDouble(Student::getMarks).reversed()
								.thenComparing(Student::getName, Comparator.reverseOrder())
								.thenComparing(Student::getRollNo, Comparator.reverseOrder()))
						.collect(Collectors.toList()).forEach(x -> System.out.print(x + "\n"));
			}
		};

		i2.arrange(ls);
		i2.print(ls, 2);
		i2.print(ls, 10);
		i2.print(ls, 3);
		System.out.println("==========================================");

	}
}
