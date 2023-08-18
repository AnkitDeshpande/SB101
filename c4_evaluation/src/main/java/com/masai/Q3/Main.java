package com.masai.Q3;

import java.util.List;

import com.masai.Q2.Used_car;

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

	private static void addVehicle() {
		EntityManager em = null;
		EntityTransaction et = null;
		try {

			em = emf.createEntityManager();
			et = em.getTransaction();

			et.begin();

			Truck t1 = new Truck("Tata", "Ace", 3400000, 45);
			Truck t2 = new Truck("Tata", "Magic", 2158955, 25);
			Truck t3 = new Truck("Ashoka", "A4075", 3192500, 38);

			PassangerCar p1 = new PassangerCar("Toyota", "Itios", 785000, 5, 15);
			PassangerCar p2 = new PassangerCar("Suzuki", "Brezza", 1025499, 5, 18);
			PassangerCar p3 = new PassangerCar("Toyota", "Innova", 2195625, 8, 17);

			em.persist(t1);
			em.persist(t2);
			em.persist(t3);

			em.persist(p1);
			em.persist(p2);
			em.persist(p3);

			et.commit();

		} catch (IllegalArgumentException | IllegalStateException | PersistenceException e) {
			et.rollback();
			System.out.println(e.getMessage());
		} finally {
			em.close();
		}
	}

	private static void findByloadingCapacity() {
		try (EntityManager em = emf.createEntityManager()) {
			String q1 = "Select  v.brand, v.model, v.price from Vehicle v where v.seating_capacity > 6 OR v.loadingCapacity < 50";
			Query Q = em.createQuery(q1);
			List<Object[]> ls = Q.getResultList();
			for (Object[] v : ls) {
				System.out.println("brand : " + v[0] + ", model : " + v[1] + ", price : " + v[2]);
			}
		} catch (IllegalArgumentException | IllegalStateException | PersistenceException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void findBygroundClearance() {
		try (EntityManager em = emf.createEntityManager()) {
			String q1 = "Select v.id, v.brand, v.model, v.groundClearance from Vehicle v where v.groundClearance<20 and v.price  between 750000 AND 3950000";
			Query Q = em.createQuery(q1);
			List<Object[]> ls = Q.getResultList();
			for (Object[] v : ls) {
				System.out.println(
						"Id : " + v[0] + ", brand : " + v[1] + ", model : " + v[2] + ", groundClearance : " + v[3]);
			}
		} catch (IllegalArgumentException | IllegalStateException | PersistenceException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void findByCosliest() {

//		Display brand, total vehicles of this brand, price of costliest vehicle for 
//		this brand such that you need to include only those brand which has minimum
//		2 vehicles in descending order of brand. Display maximum 2 records.
		try (EntityManager em = emf.createEntityManager()) {
			String q1 = "Select v.brand, count(v.brand), max(v.price) from Vehicle v where count(v.brand)>=2 order by v.brand limit 2";
			Query Q = em.createQuery(q1);
			List<Object[]> ls = Q.getResultList();
			for (Object[] v : ls) {
				System.out
						.println("brand : " + v[0] + ", Number of Vehicles : " + v[1] + ", Costliest Price : " + v[2]);
			}
		} catch (IllegalArgumentException | IllegalStateException | PersistenceException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		addVehicle();
		System.out.println();

		findByloadingCapacity();
		System.out.println();

		findBygroundClearance();
		System.out.println();

//		findByCosliest();
//		System.out.println();
	}

}
