package com.masai.UI;

import java.util.Scanner;

import com.masai.Entity.Employee;
import com.masai.Exception.NoRecordsFoundException;
import com.masai.Exception.SomeThingWentWrongException;
import com.masai.Service.EmployeeService;
import com.masai.Service.EmployeeServiceImpl;

public class MainUI {

	private static void save(Scanner sc) {
		System.out.println("Enter Name of Employee:");
		String name = sc.nextLine();

		System.out.println("Enter Address of Employee:");
		String address = sc.nextLine();

		System.out.println("Enter Salary of Employee:");
		int salary = sc.nextInt();

		try {
			EmployeeService es = new EmployeeServiceImpl();
			es.save(new Employee(name, address, salary));
			System.out.println("Employee Added SuccessFully.");
		} catch (SomeThingWentWrongException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void getAddressOfEmployee(Scanner sc) {
		System.out.println("Enter ID of Employee:");
		int id = sc.nextInt();

		try {
			EmployeeService es = new EmployeeServiceImpl();
			System.out.println(es.getAddressOfEmployee(id));
		} catch (SomeThingWentWrongException | NoRecordsFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void giveBonusToEmployee(Scanner sc) {
		System.out.println("Enter ID of Employee:");
		int id = sc.nextInt();
		System.out.println("Enter Amount.");
		int bonus = sc.nextInt();
		try {
			EmployeeService es = new EmployeeServiceImpl();
			System.out.println(es.giveBonusToEmployee(id, bonus));
		} catch (SomeThingWentWrongException | NoRecordsFoundException e) {
			System.out.println(e.getMessage());
		}

	}

	private static void deleteEmployee(Scanner sc) {
		System.out.println("Enter ID of Employee:");
		int id = sc.nextInt();
		try {
			EmployeeService es = new EmployeeServiceImpl();
			System.out.println(es.deleteEmployee(id));
		} catch (SomeThingWentWrongException | NoRecordsFoundException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		do {
			System.out.println("1. Add Employee");
			System.out.println("2. Get Address Of Employee By id");
			System.out.println("3. Give Bonus To Employee By id");
			System.out.println("4. Delete Employee By id");
			System.out.println("0. Exit");
			System.out.print("Enter Selection ");
			choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 1:
				save(sc);
				break;
			case 2:
				getAddressOfEmployee(sc);
				break;
			case 3:
				giveBonusToEmployee(sc);
				break;
			case 4:
				deleteEmployee(sc);
				break;
			case 0:
				System.out.println("Thanks for using our services");
				break;
			default:
				System.out.println("Invalid selection, try again");
			}
		} while (choice != 0);
		sc.close();
	}

}
