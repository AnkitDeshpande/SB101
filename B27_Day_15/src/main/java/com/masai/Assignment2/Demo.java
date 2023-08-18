package com.masai.Assignment2;

import java.util.List;
import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class Demo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("day15");
		EntityManager entitymanager = emfactory.createEntityManager();
		Query query = entitymanager.createNamedQuery("customerById");
		query.setParameter("id", 1);
		Customer singleResult = (Customer) query.getSingleResult();
		System.out.println(singleResult);

		System.out.println();
		System.out.println("Customer list --->");
		Query q = entitymanager.createNativeQuery("SELECT * FROM Customer", Customer.class);
		List<Customer> customers = q.getResultList();
		customers.stream().forEach(System.out::println);

	}
}