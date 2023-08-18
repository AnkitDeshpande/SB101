package com.masaischool.ui;

import java.time.LocalDate;
import java.util.Scanner;

import com.masaischool.dto.Employee;
import com.masaischool.exception.NoEmployeeFoundException;
import com.masaischool.exception.SomethingWentWrongException;
import com.masaischool.service.EmployeeService;
import com.masaischool.service.EmployeeServiceImpl;

public class UIMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice;
		
		do {
			System.out.println("1. Add Employee");
			System.out.println("2. view All Employee");
			System.out.println("3. Update Employee");
			System.out.println("4. Delete Employee");
			System.out.println("5. Search Employee by Id");
			System.out.println("0. Exit");
			System.out.print("Enter selection ");
			choice = sc.nextInt();
			
			switch(choice){
				case 1:
					addEmployee(sc);
					break;
				case 2:
					//viewAllEmployee();
					break;
				case 3:
					updateEmployee(sc);
					break;
				case 4:
					//deleteEmployee();
					break;
				case 5:
					//viewEmployeeById();
					break;
				case 0:
					System.out.println("Thanks for using our service, please visit again");
					break;
				default:
					System.out.println("Invalid selection, please try again");
				
			}
			
		}while(choice != 0);
		sc.close();
	}
	
	static void addEmployee(Scanner sc) {
		//Code to take input Employee details
		System.out.println("Please enter name ");
		String name = sc.next();
		System.out.println("Please enter salary ");
		double salary = sc.nextDouble();
		System.out.println("Please enter state ");
		String state = sc.next();
		System.out.println("Please enter joining date (YYYY-MM-DD)");
		LocalDate joiningDate = LocalDate.parse(sc.next());
		
		//It is good to create object of Employee class to contains all information
		Employee employee = new Employee(name, salary, state, joiningDate);
		
		//Create an object of EmployeeService
		EmployeeService employeeService = new EmployeeServiceImpl();
		try {
			employeeService.addEmployee(employee);
			System.out.println("Employee added successfully");
		}catch(SomethingWentWrongException ex) {
			System.out.println(ex.getMessage());
		}		
	}
	
	static void updateEmployee(Scanner sc) {
		//Code to take input Employee details
		System.out.println("Please enter employee id");
		int employeeId = sc.nextInt();
		System.out.println("Please enter name ");
		String name = sc.next();
		System.out.println("Please enter salary ");
		double salary = sc.nextDouble();
		System.out.println("Please enter state ");
		String state = sc.next();
		System.out.println("Please enter joining date (YYYY-MM-DD)");
		LocalDate joiningDate = LocalDate.parse(sc.next());
		
		//It is good to create object of Employee class to contains all information
		Employee employee = new Employee(employeeId, name, salary, state, joiningDate);
		
		//Create an object of EmployeeService
		EmployeeService employeeService = new EmployeeServiceImpl();
		try {
			employeeService.updateEmployee(employee);
			System.out.println("Employee updated successfully");
		}catch(SomethingWentWrongException | NoEmployeeFoundException ex) {
			System.out.println(ex.getMessage());
		}		
	}
}
