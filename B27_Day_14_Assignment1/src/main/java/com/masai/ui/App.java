package com.masai.ui;

import java.util.Scanner;

import com.masai.entity.Employee;
import com.masai.exception.NorecordsFoundException;
import com.masai.exception.SomethingWentWrongException;
import com.masai.service.EmployeeService;
import com.masai.service.EmployeeServiceImpl;

public class App {

	private static void create(Scanner sc) {
		System.out.println("Enter employee id :");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter employee name :");
		String name = sc.nextLine();
		System.out.println("Enter employee address :");
		String address = sc.nextLine();
		System.out.println("Enter employee salary :");
		int salary = sc.nextInt();
		try {
			Employee e = new Employee(id, name, address, salary);
			EmployeeService es = new EmployeeServiceImpl();
			es.save(e);
		} catch (SomethingWentWrongException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void read(Scanner sc) {
		System.out.println("Enter employee id :");
		int id = sc.nextInt();
		sc.nextLine();
		try {
			EmployeeService es = new EmployeeServiceImpl();
			System.out.println(es.getAddressOfEmployee(id));
		} catch (SomethingWentWrongException | NorecordsFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void bonus(Scanner sc) {
		System.out.println("Enter employee id :");
		int id = sc.nextInt();
		System.out.println("Enter Bonus for employee :");
		int bonus = sc.nextInt();
		sc.nextLine();
		try {
			EmployeeService es = new EmployeeServiceImpl();
			System.out.println(es.giveBonusToEmployee(id, bonus));
		} catch (SomethingWentWrongException | NorecordsFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void delete(Scanner sc) {
		System.out.println("Enter employee id :");
		int id = sc.nextInt();
		sc.nextLine();
		try {
			EmployeeService es = new EmployeeServiceImpl();
			if (es.deleteEmployee(id)) {
				System.out.println("Employee Deleted.");
			} else {
				throw new NorecordsFoundException("Employee not available with the given ID.");
			}
		} catch (SomethingWentWrongException | NorecordsFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ch = 0;

		do {

			System.out.println("==== Employee Console System ====");
			System.out.println("1. Add Employee :");
			System.out.println("2. Find Employee by id :");
			System.out.println("3. Give bonus to Employee :");
			System.out.println("4. Delete Employee by ID");
			System.out.println("0. Exit");
			System.out.print("Enter your choice: ");
			ch = sc.nextInt();
			sc.nextLine(); // Consume the newline character

			switch (ch) {
			case 1:
				create(sc);
				break;
			case 2:
				read(sc);
				break;
			case 3:
				bonus(sc);
				break;
			case 4:
				delete(sc);
				break;
			case 0:
				System.out.println("Exiting the program...");
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
				break;
			}

			System.out.println();

		} while (ch != 0);
	}

}
