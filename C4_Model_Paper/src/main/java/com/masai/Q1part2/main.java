package com.masai.Q1part2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class main {

	static EntityManagerFactory emf;

	static {
		emf = Persistence.createEntityManagerFactory("Insurance");
	}

	/**
	 * 
	 */
	private static void addMobile() {
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			em = emf.createEntityManager();
			et = em.getTransaction();

			et.begin();

			Company c1 = new Company("Nokia", 1865);
			Company c2 = new Company("Samsung", 1938);

			Mobile m1 = new Mobile("M31", 13400);
			Mobile m2 = new Mobile("A31", 21400);
			Mobile m3 = new Mobile("M6610", 16542);
			Mobile m4 = new Mobile("MGenZ", 21587);
			
			
			c1.getMobile().add(m3);
			c1.getMobile().add(m4);
			c2.getMobile().add(m1);
			c2.getMobile().add(m2);
			
			m1.companyName = c2;
			m2.companyName = c2;
			
			m3.companyName = c1;
			m4.companyName = c1;
			
			em.persist(c1);
			em.persist(c2);
			
			et.commit();
		} catch (Exception e) {
			et.rollback();
			System.out.println(e.getMessage());
		} finally {
			em.close();
		}

	}

	public static void main(String[] args) {
		addMobile();
		System.out.println();
	}
}
