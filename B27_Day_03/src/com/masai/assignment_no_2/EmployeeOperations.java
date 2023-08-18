package com.masai.assignment_no_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@FunctionalInterface
interface CreateEmployeeObject {
	Employee getObject(int employeeId, String name, double salary);
}

@FunctionalInterface
interface ShowDetails {
	String getEmployeeDetailsInString();
}

@FunctionalInterface
interface FindMin {
	String getMinSalariedEmployee(List<Employee> employeeList);
}

class EmployeeOperations {
	public static String getEmployeeWithMinimumSalary(List<Employee> employeeList) {
		List<Employee> list = employeeList.stream().sorted((e1, e2) -> e1.getSalary() > e2.getSalary() ? 1 : -1)
				.collect(Collectors.toList());
		Employee e = list.get(0);
		return e.getName();
	}
}
