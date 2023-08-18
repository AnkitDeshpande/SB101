package com.masai.UI;

import java.util.Scanner;

import com.masai.Entity.Student;
import com.masai.Exception.NoRecordFoundException;
import com.masai.Exception.SomethingWentWrongException;
import com.masai.Service.MasaiService;
import com.masai.Service.MasaiServiceImpl;

public class MainUI {
	private static void findStudentById(Scanner sc) {
		System.out.println("Enter Student code : ");
		int id = sc.nextInt();
		MasaiService ms = new MasaiServiceImpl();
		try {
			System.out.println(ms.findStudentById(id));
		} catch (NoRecordFoundException | SomethingWentWrongException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void saveStudent(Scanner sc) {
		System.out.println("Enter Email: ");
		String email = sc.next();
		sc.nextLine(); 
		System.out.println("Enter Address: ");
		String addr = sc.nextLine();
		System.out.println("Enter Course name: ");
		String crs = sc.nextLine();
		System.out.println("Enter Level: ");
		int lvl = sc.nextInt();

		MasaiService ms = new MasaiServiceImpl();
		try {
			System.out.println(ms.saveStudent(new Student(email, addr, crs, lvl)));
		} catch (SomethingWentWrongException e) {
			System.out.println(e.getMessage());
		}

	}

	private static void deleteStudentById(Scanner sc) {
		System.out.println("Enter Student code : ");
		int id = sc.nextInt();
		MasaiService ms = new MasaiServiceImpl();
		try {
			System.out.println(ms.deleteStudentById(id));
		} catch (NoRecordFoundException | SomethingWentWrongException e) {
			System.out.println(e.getMessage());
		}

	}

	private static void updateStudentLevel(Scanner sc) {
		System.out.println("Enter Student code : ");
		int id = sc.nextInt();
		System.out.println("Enter Level: ");
		int lvl = sc.nextInt();

		MasaiService ms = new MasaiServiceImpl();
		try {
			System.out.println(ms.updateStudentLevel(id, lvl));
		} catch (NoRecordFoundException | SomethingWentWrongException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int ch = 0;

		do {
			System.out.println("0. Exit");
			System.out.println("1. find Student By Id");
			System.out.println("2. save Student");
			System.out.println("3. delete Student By Id");
			System.out.println("4. update Student Level");
			ch = sc.nextInt();
			switch (ch) {
			case 0:
				System.out.println("Bye bye");
				break;
			case 1:
				findStudentById(sc);
				break;
			case 2:
				saveStudent(sc);
				break;
			case 3:
				deleteStudentById(sc);
				break;
			case 4:
				updateStudentLevel(sc);
				break;
			default:
				System.out.println("Invalid Input");
			}
		} while (ch != 0);

		sc.close();
	}

}
