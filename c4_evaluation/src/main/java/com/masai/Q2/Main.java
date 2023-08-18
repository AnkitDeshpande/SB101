package com.masai.Q2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

public class Main {

	static EntityManagerFactory emf;

	static {
		emf = Persistence.createEntityManagerFactory("Eval");
	}

	private static void addCars() {
		EntityManager em = null;
		EntityTransaction et = null;
		try {

			em = emf.createEntityManager();
			et = em.getTransaction();

			et.begin();
			BigDecimal b = BigDecimal.valueOf(135000.00);
			Used_car u1 = new Used_car("RJ-14 MH 8596", "Hyundai", "Santro", 2010, b, 5);

			em.persist(u1);

			et.commit();

		} catch (IllegalArgumentException | IllegalStateException | PersistenceException e) {
			et.rollback();
			System.out.println(e.getMessage());
		} finally {
			em.close();
		}
	}

	private static void findById(String id) {
		try (EntityManager em = emf.createEntityManager()) {
			String q1 = "Select u from Used_car u where id = :id";
			Query Q = em.createQuery(q1);
			Q.setParameter("id", id);
			Used_car u1 = (Used_car) Q.getSingleResult();
			System.out.println(u1);
		} catch (IllegalArgumentException | IllegalStateException | PersistenceException e) {
			System.out.println(e.getMessage());
		}
	}

	static void findCarByYearAndPriceRange(int startPrice, int endPrice) {
		try (EntityManager em = emf.createEntityManager()) {
			Query Q = em.createNamedQuery("findCarByYearAndPriceRange", Used_car.class);

			Q.setParameter("s", startPrice);
			Q.setParameter("e", endPrice);

			List<Used_car> ls = (List<Used_car>) Q.getResultList();

			for (Used_car u : ls) {
				System.out.println(u);
			}
		} catch (IllegalArgumentException | IllegalStateException | PersistenceException e) {
			System.out.println(e.getMessage());
		}
	}

	static void findCarByModelNameAndCompany(String modelName, List<String> companyName) {

	}

	private static void deleteAll() {

		EntityManager em = null;
		EntityTransaction et = null;

		try {

			em = emf.createEntityManager();
			et = em.getTransaction();

			et.begin();
				
			String Q = "Delete from Used_car u where mfg_year = 2008";
			Query Q2 = em.createQuery(Q);
			em.remove(Q2);
			
			et.commit();
			
		} catch (IllegalArgumentException | IllegalStateException | PersistenceException e) {
			et.rollback();
			System.out.println(e.getMessage());
		} finally {

		}
	}

	public static void main(String[] args) {
		addCars();
		System.out.println();

		findById("MH-14 YU 7435");
		System.out.println();

		findCarByYearAndPriceRange(120000, 495000);
		System.out.println();
		
//		List<String> ls = new ArrayList<>();
//		ls.add("Hyundai");
//		ls.add("Suzuki");
//		findCarByModelNameAndCompany("",ls);

		deleteAll();
		System.out.println();

	}

}
