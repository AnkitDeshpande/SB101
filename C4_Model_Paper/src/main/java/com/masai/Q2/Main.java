package com.masai.Q2;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class Main {
	
	static EntityManagerFactory emf;
	
	static{
		emf = Persistence.createEntityManagerFactory("Insurance");
	}
	
	private static void addSubscription() {
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			
			em = emf.createEntityManager();
			et = em.getTransaction();
			
			et.begin();
			
			Subscription newSubscription = new Subscription("Gold24", 275, 275.00, LocalDate.parse("2022-01-01"), LocalDate.parse("2022-02-01"));
			em.persist(newSubscription);
			et.commit();
					
			
		} catch (Exception e) {
			et.rollback();
		}finally {
			em.close();
		}
	}
	
	private static void findSubById() {
		try (EntityManager em = emf.createEntityManager()){
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Id : ");
			int id = sc.nextInt();
			String q = "Select s from Subscription s where id = :id";
			Query query = em.createQuery(q);
			query.setParameter("id", id);
			Subscription s1 = (Subscription) query.getSingleResult();
			
			System.out.println(s1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	static void findSubscriptionForDateRange(LocalDate firstStartDate, LocalDate secondStartDate) {
		try (EntityManager em = emf.createEntityManager()){
			String q = "Select s from Subscription s where s.startDate between :f1 and :f2";
			Query query = em.createQuery(q);
			query.setParameter("f1", firstStartDate);
			query.setParameter("f2", secondStartDate);
			
			List<Subscription> ls = query.getResultList();
			
			for(Subscription s : ls) {
				System.out.println(s);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static void main(String[] args) {
		addSubscription();
		System.out.println();
		findSubById();
		System.out.println();
		findSubscriptionForDateRange(LocalDate.parse("2022-02-01"), LocalDate.parse( "2022-04-01"));
		System.out.println();

	}
}
