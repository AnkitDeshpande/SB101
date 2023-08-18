package com.masai.question3;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class Main {
	static EntityManagerFactory emf;

	static {
		emf = Persistence.createEntityManagerFactory("c4eval");
	}

	private static void insert() {
		EntityManager em = null;
		EntityTransaction et = null;

		Truck t1 = new Truck("Tata", "Ace", 3400000, 45);
		Truck t2 = new Truck("Tata", "Magic", 2158955, 25);
		Truck t3 = new Truck("Ashoka", "A4075", 3192500, 38);

		PassangerCar p1 = new PassangerCar("Toyota", "Itios", 785000, 5, 15);
		PassangerCar p2 = new PassangerCar("Suzuki", "Brezza", 1025499, 5, 18);
		PassangerCar p3 = new PassangerCar("Toyota", "Innova", 2195625, 8, 17);

		try {
			em = emf.createEntityManager();
			et = em.getTransaction();

			et.begin();

			em.persist(t1);
			em.persist(t2);
			em.persist(t3);

			em.persist(p1);
			em.persist(p2);
			em.persist(p3);

			et.commit();

			System.out.println("Vehicle Added successfully");

		} catch (Exception e) {
			et.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}

	}

	private static void displayLoadingCapacityLessThan50() {
		try (EntityManager em = emf.createEntityManager()) {
			Query q = em.createQuery(
					"Select v.brand, v.model, v.price from Vehicle v where v.loadingCapacity < 50 OR v.seating_capacity >6");
			List<Object[]> list = q.getResultList();
			if (list.size() == 0) {
				System.out.println("List is Empty");
			} else {
				for (Object[] l : list) {
					System.out.println("Brand : ->" + l[0] + "Model : ->" + l[1] + "Price : ->" + l[2]);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void displayGroundClearanceLessThan20() {
		try (EntityManager em = emf.createEntityManager()) {
			Query q = em.createQuery(
					"Select v.id, v.brand, v.model, v.groundClearance from Vehicle v where v.groundClearance < 20 and v.price between 750000 and 3950000");
			List<Object[]> list = q.getResultList();
			if (list.size() == 0) {
				System.out.println("List is Empty");
			} else {
				for (Object[] l : list) {
					System.out.println("Id -> : " + l[0] + "\tBrand -> : " + l[1] + "\tModel -> : " + l[2]
							+ "\tGround clearnace -> :" + l[3]);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void displayCostliestvehicle() {
		try (EntityManager em = emf.createEntityManager()) {
			Query q = em.createQuery(
					"Select v.brand, count(v.brand), max(v.price) from Vehicle v group by v.brand having count(v.brand)>=2 order by v.brand desc limit 2");
			List<Object[]> list = q.getResultList();
			if (list.size() == 0) {
				System.out.println("List is Empty");
			} else {
				for (Object[] l : list) {
					System.out.println(
							"brand -> : " + l[0] + "\tBrand count -> : " + l[1] + "\tMaximum amount -> : " + l[2]);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		insert();
		System.out.println();
		displayLoadingCapacityLessThan50();
		System.out.println();
		displayGroundClearanceLessThan20();
		System.out.println();
		displayCostliestvehicle();
	}

}
