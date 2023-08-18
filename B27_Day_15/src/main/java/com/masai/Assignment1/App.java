package com.masai.Assignment1;

import java.util.List;
import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class App {

	static EntityManagerFactory emf;

	static {
		emf = Persistence.createEntityManagerFactory("day15");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ch = 0;
		do {
			System.out.println("------------------------------");
			System.out.println("1.Names in Upper case.");
			System.out.println("2.Min age of player.");
			System.out.println("3.Players between age 15 to 25.");
			System.out.println("4.Name with particular letter.");
			System.out.println("0.Exit");
			System.out.println("------------------------------");
			System.out.println("Enter your choice.");

			ch = sc.nextInt();

			switch (ch) {
			case 1:
				nameUpperCase(sc);
				break;
			case 2:
				minAge(sc);
				break;
			case 3:
				ageBetween();
				break;
			case 4:
				nameLike(sc);
				break;
			default:
				System.out.println("Invalid selection.");
			}

		} while (ch != 0);
		sc.close();
	}

	private static void nameUpperCase(Scanner sc) {
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			String q = "Select upper(p.name) from Player p";
			Query query = em.createQuery(q);
			List<String> list = (List<String>) query.getResultList();
			list.forEach(System.out::println);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			em.close();
		}
	}

	private static void minAge(Scanner sc) {
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			String q = "Select min(p.age) from Player p";
			Query query = em.createQuery(q);
			int singleResult = (int) query.getSingleResult();
			System.err.println(singleResult);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			em.close();
		}
	}

	private static void ageBetween() {
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			String q = "Select p from Player p where p.age between :min and :max";
			Query query = em.createQuery(q);
			query.setParameter("min", 18);
			query.setParameter("max", 25);
			List<Player> list = query.getResultList();
			list.forEach(System.out::println);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			em.close();
		}
	}

	private static void nameLike(Scanner sc) {
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			String likeQuery = "Select p.name from Player p where p.name like '%o%'";
			Query query = em.createQuery(likeQuery);

			List<String> ls = query.getResultList();
			ls.forEach(System.out::println);
		} catch (IllegalStateException e) {
			System.out.println(e.getMessage());
		}
	}
}
