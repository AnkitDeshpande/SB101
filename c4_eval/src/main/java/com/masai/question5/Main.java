package com.masai.question5;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.masai.question4.Account;

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

		Manager m1 = new Manager("Naveen", LocalDate.parse("2022-01-02"), null);
		Manager m2 = new Manager("Dheeraj", LocalDate.parse("2023-01-02"), null);

		Project p1 = new Project("Automation", 270, null);
		Project p2 = new Project("AIDrive", 480, null);
		Project p3 = new Project("RoboCall", 171, null);

		Set<Project> set1 = new HashSet<>();
		set1.add(p1);
		set1.add(p3);

		Set<Project> set2 = new HashSet<>();
		set2.add(p1);
		set2.add(p2);

		m1.setProjects(set1);
		m2.setProjects(set2);

		Set<Manager> mSet1 = new HashSet<>();
		mSet1.add(m1);

		Set<Manager> mSet2 = new HashSet<>();
		mSet2.add(m1);
		mSet2.add(m2);

		Set<Manager> mSet3 = new HashSet<>();
		mSet3.add(m2);

		p1.setManagers(mSet2);
		p2.setManagers(mSet3);
		p3.setManagers(mSet1);

		try {
			em = emf.createEntityManager();
			et = em.getTransaction();

			et.begin();
			em.persist(m1);
			em.persist(m2);
			et.commit();
			System.out.println("Managers and Products added successfully.");
		} catch (Exception e) {
			et.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	private static void display() {
		try (EntityManager em = emf.createEntityManager()) {
			Query q = em.createQuery("from Project m");
			List<Project> m = (List<Project>) q.getResultList();
			for (Project mn : m) {
				System.out.println(
						"ID :" + mn.getId() + "\t Name : " + mn.getName() + "\t Duration : " + mn.getDuration());
				Set<Manager> set = mn.getManagers();
				for (Manager p : set) {
					System.out.println("\t manager Id : " + p.getId() + "\t Name : " + p.getName()
							+ "\t Joining Date : " + p.getJoining_date());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
//		insert();
//		System.out.println();
		display();
	}

}
