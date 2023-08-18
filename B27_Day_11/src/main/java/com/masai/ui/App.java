package com.masai.ui;

import java.util.List;
import java.util.Scanner;

import com.masai.dto.Lawyer;
import com.masai.exceptions.NorecordsFoundException;
import com.masai.exceptions.SomethingWentWrongException;
import com.masai.service.CourtService;
import com.masai.service.CourtServiceImpl;

public class App {
	private static void getLawyerList() {
		CourtService cs = new CourtServiceImpl();
		try {
			List<Lawyer> list = cs.getLawyerList();
			list.stream().filter(l -> l.getExperience() > 5).forEach(System.out::println);
		} catch (NorecordsFoundException | SomethingWentWrongException e) {
			e.printStackTrace();
		}
	}

	private static void findLawyerById(Scanner scanner) {
		System.out.print("Enter Lawyer ID to find: ");
		int lawyerId = scanner.nextInt();
		scanner.nextLine();

		CourtService cs = new CourtServiceImpl();
		try {
			Lawyer lawyer = cs.findLawyerById(lawyerId);
			System.out.println(lawyer);
		} catch (NorecordsFoundException e) {
			e.printStackTrace();
		}
	}

	private static void saveLawyer(Scanner scanner) {
		System.out.println("Enter Lawyer Details:");
		System.out.print("ID: ");
		int id = scanner.nextInt();
		scanner.nextLine(); // Consume the newline character

		System.out.print("Name: ");
		String name = scanner.nextLine();

		System.out.print("Email: ");
		String email = scanner.nextLine();

		System.out.print("Address: ");
		String address = scanner.nextLine();

		System.out.print("Experience (in years): ");
		int experience = scanner.nextInt();
		scanner.nextLine(); // Consume the newline character

		Lawyer lawyer = new Lawyer(id, name, email, address, experience);
		CourtService cs = new CourtServiceImpl();
		try {
			System.out.println(cs.saveLawyer(lawyer));
		} catch (SomethingWentWrongException e) {
			e.printStackTrace();
		}
	}

	private static void deleteLawyerById(Scanner scanner) {
		System.out.print("Enter Lawyer ID to delete: ");
		int lawyerId = scanner.nextInt();
		scanner.nextLine();
		CourtService cs = new CourtServiceImpl();
		try {
			System.out.println(cs.deleteLawyerById(lawyerId));
		} catch (NorecordsFoundException e) {
			e.printStackTrace();
		}
	}

	private static void updateLawyerExperience(Scanner scanner) {
		System.out.print("Enter Lawyer ID to update Experience: ");
		int lawyerId = scanner.nextInt();
		System.out.println("Enter Updated lawyer Experience : ");
		int exp = scanner.nextInt();
		scanner.nextLine();
		CourtService cs = new CourtServiceImpl();
		try {
			System.out.println(cs.updateLawyerExperience(lawyerId, exp));
		} catch (NorecordsFoundException | SomethingWentWrongException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int choice;
		do {
			System.out.println("==== Lawyer Console System ====");
			System.out.println("1. Get Lawyer List");
			System.out.println("2. Find Lawyer by ID");
			System.out.println("3. Save Lawyer");
			System.out.println("4. Delete Lawyer by ID");
			System.out.println("5. Update Lawyer Experience");
			System.out.println("0. Exit");
			System.out.print("Enter your choice: ");
			choice = scanner.nextInt();
			scanner.nextLine(); // Consume the newline character

			switch (choice) {
			case 1:
				getLawyerList();
				break;
			case 2:
				findLawyerById(scanner);
				break;
			case 3:
				saveLawyer(scanner);
				break;
			case 4:
				deleteLawyerById(scanner);
				break;
			case 5:
				updateLawyerExperience(scanner);
				break;
			case 0:
				System.out.println("Exiting the program...");
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
				break;
			}

			System.out.println();
		} while (choice != 0);
		scanner.close();
	}

}
