package assignment_no_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		List<Student> ls = new ArrayList<>();

		Scanner sc = new Scanner(System.in);

		for (int i = 1; i <= 10; i++) {
			System.out.println("Enter details for student " + i + ":");
			System.out.print("Roll No.: ");
			int rollNo = sc.nextInt();
			System.out.print("Name: ");
			String name = sc.next();
			System.out.print("Marks: ");
			int marks = sc.nextInt();
			ls.add(new Student(rollNo, name, marks));
		}

		Function<List<Student>, Map<String, List<Student>>> fn = t -> {
			Map<String, List<Student>> mp = new HashMap<>();
			mp.put("Fail", ls.stream().filter(st -> st.getMarks() < 165).collect(Collectors.toList()));
			mp.put("Pass",
					ls.stream().filter(st -> st.getMarks() >= 165 && st.getMarks() < 400).collect(Collectors.toList()));
			mp.put("Topper", ls.stream().filter(st -> st.getMarks() >= 400).collect(Collectors.toList()));
			return mp;
		};

		Consumer<Map<String, List<Student>>> c1 = result -> {
			System.out.println("Toppers : ");
			result.get("Topper").forEach(stud -> System.out.println(stud.getName()));
			System.out.println("------------------------------------------------------");
			
			System.out.println("Passed Student : ");
			result.get("Pass").forEach(stud -> System.out.println(stud.getName()));
			System.out.println("------------------------------------------------------");

			System.out.println("Failed Students : ");
			result.get("Fail").forEach(stud -> System.out.println(stud.getName()));
			System.out.println("------------------------------------------------------");
		};

		c1.accept(fn.apply(ls)); // apply oracle docs ---> Applies this(fn) function to the given argument(ls).
	}
}
