package com.masai.Q3;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class Main {

	private static void addPizza() {

		EntityManager em = null;
		EntityTransaction et = null;

		try {

			em = EMUtils.connect();
			et = em.getTransaction();

			et.begin();

			SupremePizza s1 = new SupremePizza(199, 4.5, 6, "non-veg", 2, 1);
			SupremePizza s2 = new SupremePizza(249, 3.5, 8, "non-veg", 3, 2);
			SupremePizza s3 = new SupremePizza(399, 3.9, 10, "non-veg", 4, 3);

			VeggiesPizza v1 = new VeggiesPizza(99, 4.8, 6, "veg", 3, 270);
			VeggiesPizza v2 = new VeggiesPizza(149, 4.5, 8, "veg", 4, 375);
			VeggiesPizza v3 = new VeggiesPizza(199, 3.0, 10, "veg", 5, 475);

			em.persist(s1);
			em.persist(s2);
			em.persist(s3);

			em.persist(v1);
			em.persist(v2);
			em.persist(v3);

			et.commit();

		} catch (Exception e) {
			et.rollback();
			System.out.println(e.getMessage());
		} finally {

		}

	}

	/**
	 * 
	 */
	private static void displayDetails() {
		try (EntityManager em = EMUtils.connect()) {
			String Q1 = "Select p.diameter, p.rating, p.price, p.type from Pizza p where p.forNumberOfPeople > :n or p.totalCalories < :m";
			Query q = em.createQuery(Q1);
			q.setParameter("n", 1);
			q.setParameter("m", 400);
			List<Object[]> ls = q.getResultList();
			for (Object[] p : ls) {
				System.out.println("Diameter: " + p[0] + ", " + "Rating: " + p[1] + ", " + "Price: " + p[2] + ", "
						+ "Type: " + p[3]);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void displayDetails2() {
		try (EntityManager em = EMUtils.connect()) {
			String Q1 = "Select p.id, p.totalVeggies, p.totalCalories from Pizza p where p.totalVeggies >= 4 or p.rating >= 3.5";
			Query q = em.createQuery(Q1);
			List<Object[]> ls = q.getResultList();
			for (Object[] p : ls) {
				System.out.println("id: " + p[0] + ", " + "totalVeggies: " + p[1] + ", " + "totalCalories: " + p[2]);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		addPizza();
		System.out.println();

		displayDetails();
		System.out.println();
		
		displayDetails2();
	}

}
