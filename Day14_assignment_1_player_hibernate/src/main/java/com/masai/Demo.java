package com.masai;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class Demo {
	static EntityManagerFactory emfactory;

	static {
		emfactory = Persistence.createEntityManagerFactory("player");
	}

	public static void namesInUpperCase() {
		try (EntityManager em = emfactory.createEntityManager()) {
			String upperQuery = "SELECT UPPER(p.Name) FROM Player p";
			Query query = em.createQuery(upperQuery);
			List<String> list = query.getResultList();
			for(String name: list) {
				System.out.print(name + " ");
			}			
		}catch(IllegalStateException | IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public static void minAgeOfPlayeer() {
		try (EntityManager em = emfactory.createEntityManager()) {
			String minQuery = "Select min(p.Age) from Player p";
			Query query = em.createQuery(minQuery);
			int minAge = (int) query.getSingleResult();
			System.out.println(minAge);
		} catch (IllegalStateException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void playerBetnRange() {
		try (EntityManager em = emfactory.createEntityManager()) {
			String rangeQuery = "Select p from Player p where p.Age between :start and :end";
			//String rangeQuery = "Select p from Player p where p.Age between 18 and 25"; 
			//above line will also work just remove line no  47 && 48
			Query query = em.createQuery(rangeQuery);
			query.setParameter("start", 18);
			query.setParameter("end", 25);
			List<Player> list = query.getResultList();
			for(Player p : list) {
				System.out.println(p);
			}
		} catch (IllegalStateException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void nameLike() {
		try (EntityManager em = emfactory.createEntityManager()) {
			String likeQuery = "Select p.Name from Player p where p.Name like '%o%'";
			Query query = em.createQuery(likeQuery);
			
			List<String> ls = query.getResultList();
			for(String n : ls) {
				System.out.println(n + " ");
			}
		} catch (IllegalStateException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		EntityManager entitymanager = emfactory.createEntityManager();
		System.out.println();
		namesInUpperCase();
		System.out.println();
		minAgeOfPlayeer();
		System.out.println();
		playerBetnRange();
		System.out.println();
		nameLike();
		System.out.println();
	}
}
