package Assignment_no_2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Demo {

	static void findStudentWithSameState(List<Student> st, List<? extends Student> ls1, List<? extends Student> ls2,
			String state) {

		st.addAll(ls1.stream().filter(student -> student.getState().equals(state)).collect(Collectors.toList()));
		st.addAll(ls2.stream().filter(student -> student.getState().equals(state)).collect(Collectors.toList()));

	}

	public static void main(String[] args) {
		List<SchoolStudent> ss1 = new ArrayList<>();
		ss1.add(new SchoolStudent(1, "Ankit", "Maharashtra", "State Board"));
		ss1.add(new SchoolStudent(2, "Sanket", "Maharashtra", "State Board"));
		ss1.add(new SchoolStudent(3, "Shubham", "Bihar", "CBSE"));
		ss1.add(new SchoolStudent(4, "Harpreet", "Punjab", "ICSE"));
		ss1.add(new SchoolStudent(5, "Balu", "Maharashtra", "State Board"));

		List<CollegeStudent> cs1 = new ArrayList<>();
		cs1.add(new CollegeStudent(1, "Mayur", "Maharashtra", "DBATU"));
		cs1.add(new CollegeStudent(2, "Virat", "Delhi", "Delhi University"));
		cs1.add(new CollegeStudent(3, "Rohit", "Telangana", "Telengana University"));
		cs1.add(new CollegeStudent(4, "Dhoni", "Jharkhand", "Jharkhand University"));
		cs1.add(new CollegeStudent(5, "Ravi", "Maharashtra", "BAMU"));

		List<Student> res = new ArrayList<>();

		findStudentWithSameState(res, ss1, cs1, "Maharashtra");

		res.stream().forEach(System.out::println);
	}
}
