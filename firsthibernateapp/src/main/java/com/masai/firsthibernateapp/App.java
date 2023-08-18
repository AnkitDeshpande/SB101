package com.masai.firsthibernateapp;

import java.util.Scanner;

import org.hibernate.event.spi.PersistContext;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;

public class App {

	static EntityManagerFactory entityManagerFactory = null;

	static {
		entityManagerFactory = Persistence.createEntityManagerFactory("abc"); // -- (1)
	}

	static void insertStudent(Student student) {
		EntityManager entityManager = null;

		EntityTransaction transaction = null;

		try {
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(student);
			transaction.commit();
			System.out.println("Student addded successfully.");
		} catch (PersistenceException pe) {
			System.out.println(pe.getMessage());
			transaction.rollback();
		} finally {
			entityManager.close();

		}

	}

	static void deleteStudent(int roll) {
		EntityManager entityManager = null;

		EntityTransaction transaction = null;

		try {
			entityManager = entityManagerFactory.createEntityManager();
			Student Student = entityManager.find(Student.class, roll);
			if (Student == null) {
				System.out.println("Invalid Roll number. ");
				return;
			}
			transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.remove(Student);
			transaction.commit();
			System.out.println("Student deleted successfully.");
		} catch (PersistenceException pe) {
			System.out.println(pe.getMessage());
			transaction.rollback();
		} finally {
			entityManager.close();

		}

	}

	static void redStudentByRoll(int roll) {
		EntityManager entityManager = entityManagerFactory.createEntityManager(); // -- (2)

		Student s1 = entityManager.find(Student.class, roll);

		if (s1 == null) {
			System.out.println("No Student found with given roll no.");
		} else {
			System.out.println(s1);
		}

		entityManager.close(); // --- (3)
	}

	static void update(int roll, String name) {
		EntityManager entityManager = null;

		EntityTransaction transaction = null;

		try {
			entityManager = entityManagerFactory.createEntityManager();
			Student student = entityManager.find(Student.class, roll);
			if (student == null) {
				System.out.println("Invalid Roll number. ");
				return;
			}
			transaction = entityManager.getTransaction();
			transaction.begin();
			student.setName(name);
			transaction.commit();
			System.out.println("Student updated successfully.");
		} catch (PersistenceException pe) {
			System.out.println(pe.getMessage());
			transaction.rollback();
		} finally {
			entityManager.close();

		}

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int ch = 0;

		do {
			System.out.println("1. Insert operation. ");
			System.out.println("2. View Student with roll number. ");
			System.out.println("3. Update by roll number. ");
			System.out.println("4. delete by roll number. ");
			System.out.println("Enter your choice : ");
			ch = sc.nextInt();
			switch (ch) {
			case 1:
				System.out.println("Enter Roll no : ");
				int roll = sc.nextInt();
				System.out.println("Enter name : ");
				String name = sc.next();
				System.out.println("Enter marks : ");
				int marks = sc.nextInt();
				Student st = new Student(roll, name, marks);
				insertStudent(st);
				break;

			case 2:
				System.out.println("Enter a roll no : ");
				int roll1 = sc.nextInt();
				redStudentByRoll(roll1);
				break;
			case 3:
				System.out.println("Enter Roll no : ");
				int roll11 = sc.nextInt();
				System.out.println("Enter name : ");
				String name1 = sc.next();
				update(roll11, name1);
				break;
			case 4:

				System.out.println("Enter a roll no : ");
				int roll111 = sc.nextInt();
				deleteStudent(roll111);
				break;
			case 0:
				System.out.println("BYE-BYE");
				break;
			default:
				System.out.println("Invalid Selection.");
			}

		} while (ch != 0);

		sc.close();
	}
}
