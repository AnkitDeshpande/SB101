package com.masai.fifth;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
	public static void main(String[] args) {

		List<Applicant> appList = new ArrayList<>();

		appList.add(new Applicant(1, "Ankit", 95.00));
		appList.add(new Applicant(2, "SAnket", 65.00));
		appList.add(new Applicant(3, "Rutuja", 45.00));
		appList.add(new Applicant(4, "Balu", 50.00));
		appList.add(new Applicant(5, "Ravi", 65.00));

		List<Employee> empList = new ArrayList<>();

		Function<Applicant, Employee> fn = t -> {
			Employee e = new Employee();
			e.setEmployeeId(t.getApplicantId());
			e.setName(t.getName());
			if (t.getInterviewMarks() >= 85) {
				e.setDesignation("manager");
				e.setSalary(60000 + (50 * t.getInterviewMarks()));
			} else if (t.getInterviewMarks() >= 65) {
				e.setDesignation("clerk");
				e.setSalary(35000 + (30 * t.getInterviewMarks()));
			} else if (t.getInterviewMarks() >= 50) {
				e.setDesignation("Junior clerk");
				e.setSalary(25000 + (20 * t.getInterviewMarks()));
			} else {
				e.setDesignation("No Job");
				e.setSalary(0);
			}
			empList.add(e);
			return e;
		};

		appList.stream().forEach(t -> fn.apply(t));
		empList.forEach(System.out::println);
	}
}
