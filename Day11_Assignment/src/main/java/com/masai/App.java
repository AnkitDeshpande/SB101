package com.masai;

import java.sql.Connection;
import com.masai.dto.Lawyer;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

import com.masai.exception.NoRecordsFoundException;
import com.masai.exception.SomeThingWentWrongException;
import com.masai.service.lawyerService;
import com.masai.service.lawyerServiceImp;

public class App {

	private static void getLawyerList(Scanner sc) {
		lawyerService ls = new lawyerServiceImp();
		try {
			List<Lawyer> lst2 = ls.getLawyerList();
			lst2.stream().forEach(lawyer -> System.out.println(lawyer.toString()));
		} catch (SomeThingWentWrongException e) {
			System.out.println(e.getMessage());
		}
		int ch;
		do {
			System.out.println("1. Get Lawyers list with experience more than 5 and with letter J.");
			System.out.println("2. exit");
			ch = sc.nextInt();
			switch (ch) {
			case 1:
				
				try {
					List<Lawyer> lst = ls.getLawyerByExp();
					lst.stream().forEach(lawyer -> System.out.println(lawyer.toString()));
				} catch (SomeThingWentWrongException | NoRecordsFoundException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				System.out.println("Bye");
				break;
			default:
				System.out.println("Invalid input.");
			}
		} while (ch != 2);

	}

	private static void findLawyerById(Scanner sc) {
		System.out.println("Enter Laywer Id.");
		int id = sc.nextInt();
		lawyerService ls = new lawyerServiceImp();
		try {
			System.out.println(ls.findLawyerById(id));
		} catch (SomeThingWentWrongException | NoRecordsFoundException e) {
			System.out.println(e.getMessage());
		}

	}

	private static void saveLawyer(Scanner sc) {
		System.out.println("Enter Id.");
		int id = sc.nextInt();
		System.out.println("Enter Name.");
		String name = sc.next();
		System.out.println("Enter email.");
		String email = sc.next();
		System.out.println("Enter Address.");
		String addr = sc.next();
		System.out.println("Enter Experience.");
		int exp = sc.nextInt();
		Lawyer l = new Lawyer(id, name, email, addr, exp);
		lawyerService ls = new lawyerServiceImp();
		try {
			
			System.out.println(ls.saveLawyer(l));
		} catch (SomeThingWentWrongException e) {
			System.out.println(e.getMessage());
		}

	}

	private static void deleteLawyerById(Scanner sc) {
		System.out.println("Enter Laywer Id.");
		int id = sc.nextInt();
		lawyerService ls = new lawyerServiceImp();
		try {
			ls.deleteLawyerById(id);
			System.out.println("Laywer deleted successfully.");
		} catch (SomeThingWentWrongException | NoRecordsFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void updateLawyerExperience(Scanner sc) {
		System.out.println("Enter Id.");
		int id = sc.nextInt();
		System.out.println("Enter Experience.");
		int exp = sc.nextInt();
		lawyerService ls = new lawyerServiceImp();
		try {
			ls.updateLawyerExperience(id, exp);
			System.out.println("Laywer updated successfully.");
		} catch (SomeThingWentWrongException | NoRecordsFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ch;
		do {
			System.out.println("0. Exit");
			System.out.println("1. Get Lawyers list");
			System.out.println("2. Find a lawyer");
			System.out.println("3. Save a lwayer");
			System.out.println("4. Delete a lwayer");
			System.out.println("5. Update a lwayer");
			ch = sc.nextInt();

			switch (ch) {
			case 1:
				getLawyerList(sc);
				break;

			case 2:
				findLawyerById(sc);
				break;

			case 3:
				saveLawyer(sc);
				break;

			case 4:
				deleteLawyerById(sc);
				break;

			case 5:
				updateLawyerExperience(sc);
				break;
			case 0:
				System.out.println("Have a nice day.");
				break;
			default:
				System.out.println("Invalid input.");
			}
		} while (ch != 0);
		sc.close();
	}

}
