package com.masai.Assignment3;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Main {
	static EntityManagerFactory emf;

	static {
		emf = Persistence.createEntityManagerFactory("day15");
	}

	private static void insert(Scanner sc) {
		sc.nextLine();
		System.out.println("Enter name :");
		String name = sc.nextLine();
		System.out.println("Enter gender :");
		String gender = sc.nextLine();
		System.out.println("Enter salary :");
		int salary = sc.nextInt();
		sc.nextLine();

		System.out.println("Enter Home address details. ");
		System.out.println("Enter state : ");
		String homestate = sc.nextLine();
		System.out.println("Enter city : ");
		String homeCity = sc.nextLine();
		System.out.println("Enter pincode : ");
		String homePin = sc.nextLine();
		System.out.println("Enter type (Home/Office) : ");
		String homeType = sc.nextLine();

		System.out.println("Enter Office address details. ");
		System.out.println("Enter state : ");
		String officeState = sc.nextLine();
		System.out.println("Enter city : ");
		String officeCity = sc.nextLine();
		System.out.println("Enter pincode : ");
		String officePin = sc.nextLine();
		System.out.println("Enter type (Home/Office) : ");
		String officeType = sc.nextLine();

		Address home = new Address(homestate, homeCity, homePin, homeType);
		Address office = new Address(officeState, officeCity, officePin, officeType);

//		 Set<Address> addresses;
//		addresses.add(home);
//		addresses.add(office);

		Employee emp = new Employee(name, gender, salary);
		emp.getEmpAddress().add(home);
		emp.getEmpAddress().add(office);

		EntityManager em = null;
		EntityTransaction et = null;
		try {
			em = emf.createEntityManager();
			et = em.getTransaction();

			et.begin();
			em.persist(emp);
			et.commit();

		} catch (Exception e) {
			et.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int ch = 0;
		do {
			System.out.println("Enter 0 to exit else enter 1 to insert Employee.");
			ch = sc.nextInt();

			switch (ch) {
			case 1:
				insert(sc);
				break;
			case 0:
				System.out.println("Exiting");
				break;
			default:
				System.out.println("Invalid Entry");
			}

		} while (ch != 0);

	}

}
