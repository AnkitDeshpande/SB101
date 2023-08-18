package com.masai;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class InsertStudent {
	static EntityManagerFactory emf;
	static {
		emf = Persistence.createEntityManagerFactory("Student");
	}
	private static void addStudent() {
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			em = emf.createEntityManager();
			et = em.getTransaction();
			
			et.begin();
			
			FullTimeStudent f1 = new FullTimeStudent("Ankit", "Sambhajinagar", 1000, 250000);
			FullTimeStudent f2 = new FullTimeStudent("Sanket", "Pune", 1000, 250000);
			
			PartTimeStudent p1 = new PartTimeStudent("Ravi", "Sillod", 500, 150000);
			PartTimeStudent p2 = new PartTimeStudent("Balu", "Sonai", 500, 150000);
			
			em.persist(f1);
			em.persist(f2);
			
			em.persist(p1);
			em.persist(p2);
			
			et.commit();
			
		} catch (Exception e) {
			et.rollback();
			System.out.println(e.getMessage());
		}finally {
			em.close();
		}
	}
	public static void main(String[] args) {
		addStudent();
	}

	
}
