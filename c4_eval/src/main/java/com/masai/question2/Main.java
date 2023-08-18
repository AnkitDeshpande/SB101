package com.masai.question2;

import java.math.BigDecimal;
import java.util.Arrays;
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

	private static void delete() {
		EntityManager em = null;
		EntityTransaction et = null;

		try {
			em = emf.createEntityManager();
			et = em.getTransaction();

			Query q = em.createQuery("Delete from Cars c where mfgYear <= 2008");
			et.begin();
			if (q.executeUpdate() > 0) {
				System.out.println("Deleted successfully.");
				et.commit();
				;
			} else {
				System.out.println("No cars found.");
				et.rollback();
			}

		} catch (Exception e) {
			et.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	private static void update(String reg) {
		EntityManager em = null;
		EntityTransaction et = null;

		try {

			em = emf.createEntityManager();
			et = em.getTransaction();

			et.begin();
			Cars car = em.find(Cars.class, reg);
			if (car == null) {
				System.out.println("Invalid registraion Number");
				et.rollback();
			} else {
				car.setCName("Toyota");
				car.setModel("Itios");
				em.merge(car);
				et.commit();
				System.out.println("Car Updated successfully.");
			}
		} catch (Exception e) {
			et.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	static void findCarByModelNameAndCompany(String modelName, List<String> companyName) {
		try (EntityManager em = emf.createEntityManager()) {
			Query query = em.createNamedQuery("findByName");

			query.setParameter("ch", modelName);
			query.setParameter("list", companyName);
			List<Object[]> list = (List<Object[]>) query.getResultList();
			if (list.size() != 0) {
				list.stream().forEach(System.out::println);
			} else {
				System.out.println("Empty Set.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void findCarByYearAndPriceRange(int startPrice, int endPrice) {
		try (EntityManager em = emf.createEntityManager()) {
			Query query = em.createNamedQuery("findRange");
			query.setParameter("start", startPrice);
			query.setParameter("end", endPrice);

			List<Cars> list = query.getResultList();
			if (list.size() != 0) {
				list.stream().forEach(System.out::println);
			} else {
				System.out.println("Empty Set.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void getCarById() {
		try (EntityManager em = emf.createEntityManager()) {

			Cars car = em.find(Cars.class, "MH-14 YU 7435");
			if (car != null) {
				System.out.println(car);
			} else {
				System.out.println("Invalid Registration Id.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void insert() {
		EntityManager em = null;
		EntityTransaction et = null;

		Cars c1 = new Cars("RJ-14 MH 8596", "Hyundai", "Santro", 2010, BigDecimal.valueOf(135000.00), 5);

		try {

			em = emf.createEntityManager();
			et = em.getTransaction();

			et.begin();
			em.persist(c1);
			et.commit();

			System.out.println("Car added successfully.");
		} catch (Exception e) {
			et.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}

	}

	public static void main(String[] args) {
		insert();
		System.out.println();
		getCarById();
		System.out.println();
		findCarByYearAndPriceRange(125000, 200000);
		System.out.println();
		findCarByModelNameAndCompany("a", Arrays.asList("Suzuki", "Hyundai"));
		System.out.println();
		update("MH-14 YU 7435");
		System.out.println();
		delete();
	}

}
