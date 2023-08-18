package com.masai;


import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;


public class Demo {
	static EntityManagerFactory emf;
	static {
		emf = Persistence.createEntityManagerFactory("Customer");
	}
	private static void findCustomerByIdEX() {
	    try (EntityManager em = emf.createEntityManager()) {
	        Query q = em.createNamedQuery("findCustomerById", Customer.class);
	        q.setParameter("customerId", 1); // Replace 1 with the actual customer ID you want to retrieve
	        Customer c = (Customer) q.getSingleResult();
	        System.out.println(c);
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	    }
	}
	
	private static void ListOfAllTheCustomersEx() {
		try (EntityManager em  =emf.createEntityManager()){
			Query q = em.createNamedQuery("ListOfAllTheCustomers");
			List<Customer> ls = q.getResultList();
			for(Customer cs : ls) {
				System.out.println(cs);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
	}
	public static void main(String[] args) {
		findCustomerByIdEX();
		System.out.println();
		ListOfAllTheCustomersEx();
		System.out.println();
	}

	
}
