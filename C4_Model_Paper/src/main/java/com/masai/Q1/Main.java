package com.masai.Q1;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class Main {
	static EntityManagerFactory emf;

	static {
		emf = Persistence.createEntityManagerFactory("Insurance");
	}

	private static void addEmployee() {
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			em = emf.createEntityManager();
			et = em.getTransaction();

			et.begin();

			Employee e1 = new Employee("Anuj", 24, new Insurance("Term Plan", "LIC", 14500),
					new Insurance("Health Policy", "Max Life", 10500));
			Employee e2 = new Employee("Akshay,", 32, new Insurance("Term Plan", "HDFC Ergo", 20700),
					new Insurance("Health Policy", "LIC", 11800));

			em.persist(e1);
			em.persist(e2);

			et.commit();
		} catch (Exception e) {
			et.rollback();
			System.out.println(e.getMessage());
		} finally {
			em.close();
		}
	}

	private static void DisplayByPolicyName() {
		try (EntityManager em = emf.createEntityManager()) {
			String Q = "SELECT UPPER(e.name) FROM Employee e WHERE e.self.companyName IN ('LIC', 'HDFC Ergo')";
			Query query = em.createQuery(Q);
			List<Employee> ls = query.getResultList();
			System.out.println(ls);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		addEmployee();
		System.out.println();
		DisplayByPolicyName();
		System.out.println();
	}
}
