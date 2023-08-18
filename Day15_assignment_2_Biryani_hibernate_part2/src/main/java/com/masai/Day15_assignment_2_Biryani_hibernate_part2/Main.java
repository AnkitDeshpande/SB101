package com.masai.Day15_assignment_2_Biryani_hibernate_part2;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;

public class Main {
	static EntityManagerFactory emf;

	static {
		emf = Persistence.createEntityManagerFactory("Biryani");
	}
	private static void addBiryani() {
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			em = emf.createEntityManager();
			et = em.getTransaction();

			et.begin();

			VegBiryani v1 = new VegBiryani(8, 399.99, "Matar");
			VegBiryani v2 = new VegBiryani(9, 599.99, "Butter");

			ChickenBiryani c1 = new ChickenBiryani(7, 499.99, "Chicken Masasla");
			ChickenBiryani c2 = new ChickenBiryani(9, 799.99, "Indian Spices mixed");

			em.persist(v1);
			em.persist(v2);
			em.persist(c1);
			em.persist(c2);

			et.commit();
		} catch (PersistenceException e) {
			et.rollback();
		} finally {
			em.close();
		}
	}

	private static void chickenBiryaniDetails() {
		try {
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void chickenBiryaniById() {
		try {
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void chickenBiryaniLessThan500() {
		try {
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		chickenBiryaniDetails();
		System.out.println();
		chickenBiryaniById();
		System.out.println();
		chickenBiryaniLessThan500();
		System.out.println();
	}

}
