package com.masai;

import java.util.List;
import java.util.Scanner;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

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

	private static void VegBiryaniDetails() {
		try (EntityManager em = emf.createEntityManager()) {
			String Q = "Select v from VegBiryani v";
			Query query = em.createQuery(Q);
			List<VegBiryani> ls = query.getResultList();
			System.out.println(ls.size());
			for (VegBiryani v : ls) {
				System.out.println(v);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void VegBiryaniById() {
		try (EntityManager em = emf.createEntityManager()) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter VegBiryani ID");
			int id = sc.nextInt();
			String Q = "Select v from VegBiryani v where id = :id";
			Query query = em.createQuery(Q);
			query.setParameter("id", id);
			VegBiryani v1 = (VegBiryani) query.getSingleResult();
			if (v1 != null) {
				System.out.println(v1);
			} else {
				System.out.println("No item Found with Given Id.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		addBiryani();
		System.out.println();
		VegBiryaniDetails();
		System.out.println();
		VegBiryaniById();
		System.out.println();

	}

}
