package com.masai.assignment_no_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StudentOperation {

	static Optional<List<Student>> findStudent(List<Student> studentList) {

		List<Student> passedStudent = studentList.stream().filter(st -> st.getMarks() >= 55)
				.collect(Collectors.toList());

		return Optional.ofNullable(passedStudent.isEmpty() ? null : passedStudent);
	}

	static int getOutstandingStudentCount(List<Student> studentList) throws NoStudentPassedException {

		List<Student> list = findStudent(studentList)
				.orElseThrow(() -> new NoStudentPassedException("No student is passed"));
		return list.size();
	}

	public static void main(String[] args) {
		List<Student> ls = new ArrayList<>();
		ls.add(new Student(1, "Ankit", 75));
		ls.add(new Student(2, "Sanket", 65));
		ls.add(new Student(3, "Balu", 45));
		ls.add(new Student(4, "Ravi", 45));
		ls.add(new Student(5, "Rutuja", 45));

		Optional<List<Student>> list = findStudent(ls);

		System.out.println(list);
		System.out.println();
		
//-------------------------------------------------------------------------------------------------------------------
		try {
			System.out.println("Total Student Passed : "+getOutstandingStudentCount(ls));
		} catch (NoStudentPassedException e) {
			e.printStackTrace();
		}
	}
}
