package com.masai.assignment_no_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class MethodRefDemo {

	public static void main(String[] args) {

		// Implementation of CreateEmployeeObject should be provided as method reference
		// to constructor. Get an object of employee by callling the getObject() method.

		CreateEmployeeObject ceo = Employee::new;
		Employee e1 = ceo.getObject(1, "Ankit", 50000);

//----------------------------------------------------------------------------------------------------------------------------

		// Implementation of ShowDetails should be provided as method reference to
		// non-static method for particular object. print the details of object created
		// in above step using getEmployeeDetailsInString() method

		ShowDetails sd = e1::toString;
		System.out.println(sd.getEmployeeDetailsInString());

//----------------------------------------------------------------------------------------------------------------------------

		// Create three more objects of Employee class using getObject() method of
		// CreateEmployeeObject interface, Create a List of Employee and add all four
		// objects to this

		List<Employee> empList = new ArrayList<>();

		CreateEmployeeObject ceo2 = Employee::new;
		Employee e2 = ceo2.getObject(2, "Sanket", 35000);

		CreateEmployeeObject ceo3 = Employee::new;
		Employee e3 = ceo2.getObject(3, "Ravi", 27000);

		CreateEmployeeObject ceo4 = Employee::new;
		Employee e4 = ceo4.getObject(4, "Rutuja", 25000);

		empList.add(e1);
		empList.add(e2);
		empList.add(e3);
		empList.add(e4);

		// System.out.println(empList);

//----------------------------------------------------------------------------------------------------------------------------

		// Use Collection.sort() method to sort the List of Employees in the natural
		// ordering.

		Collections.sort(empList, (o1, o2) -> Double.compare(o1.getSalary(), o2.getSalary())); // error

//----------------------------------------------------------------------------------------------------------------------------

		// Implementation of FindMin should be provided as method reference to static
		// method
		FindMin f1 = EmployeeOperations::getEmployeeWithMinimumSalary;

//----------------------------------------------------------------------------------------------------------------------------

		System.out.println("Employee with minimum Salary : " + f1.getMinSalariedEmployee(empList));

//----------------------------------------------------------------------------------------------------------------------------
	}
}