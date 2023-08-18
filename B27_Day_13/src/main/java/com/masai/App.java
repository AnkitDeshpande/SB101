package com.masai;

import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class App {

	static EntityManagerFactory emf;

	static {
		emf = Persistence.createEntityManagerFactory("emp");
	}

	private static void create(Scanner sc) {
		System.out.println("Enter employee id :");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter employee name :");
		String name = sc.nextLine();
		System.out.println("Enter employee salary :");
		double salary = sc.nextDouble();

		Employee emp = new Employee(id, name, salary);
		EntityManager em = null;
		EntityTransaction et = null;

		try {
			em = emf.createEntityManager();
			et = em.getTransaction();

			et.begin();
			em.persist(emp);
			et.commit();
			System.out
					.println("-----------------------\n" + "Employee Added successfully" + "\n-----------------------");
		} catch (Exception e) {
			et.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}

	}

	private static void read(Scanner sc) {
		System.out.println("Enter employee id :");
		int id = sc.nextInt();
		sc.nextLine();
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			em = emf.createEntityManager();
			et = em.getTransaction();

			et.begin();
			Employee emp = em.find(Employee.class, id);
			if (emp != null) {
				System.out.println(emp);
			} else {
				throw new IllegalArgumentException("No such employee.");
			}
			et.commit();
		} catch (Exception e) {
			et.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	private static void update(Scanner sc) {
		System.out.println("Enter employee id :");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter employee name :");
		String name = sc.nextLine();
		System.out.println("Enter employee salary :");
		double salary = sc.nextDouble();

		Employee emp = new Employee(id, name, salary);
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			em = emf.createEntityManager();
			et = em.getTransaction();

			et.begin();
			em.merge(emp);
			et.commit();
			System.out.println(
					"-----------------------\n" + "Employee Updated successfully." + "\n-----------------------");
		} catch (Exception e) {
			et.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	private static void delete(Scanner sc) {
		System.out.println("Enter employee id :");
		int id = sc.nextInt();
		sc.nextLine();

		EntityManager em = null;
		EntityTransaction et = null;
		try {
			em = emf.createEntityManager();
			et = em.getTransaction();
			Employee emp = em.find(Employee.class, id);

			et.begin();
			if (emp != null) {
				em.remove(emp);
			} else {
				throw new IllegalArgumentException("No such employee.");
			}
			et.commit();
			System.out.println(
					"-----------------------\n" + "Employee deleted successfully." + "\n-----------------------");
		} catch (Exception e) {
			et.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int choice;
		do {
			System.out.println("==== Employee Console System ====");
			System.out.println("1. Add Employee :");
			System.out.println("2. Find Employee by id :");
			System.out.println("3. Update Employee :");
			System.out.println("4. Delete Employee by ID");
			System.out.println("0. Exit");
			System.out.print("Enter your choice: ");
			choice = scanner.nextInt();
			scanner.nextLine(); // Consume the newline character

			switch (choice) {
			case 1:
				create(scanner);
				break;
			case 2:
				read(scanner);
				break;
			case 3:
				update(scanner);
				break;
			case 4:
				delete(scanner);
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
