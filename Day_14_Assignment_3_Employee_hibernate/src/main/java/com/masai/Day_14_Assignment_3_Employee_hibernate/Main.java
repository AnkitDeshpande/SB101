package com.masai.Day_14_Assignment_3_Employee_hibernate;

import java.util.HashSet;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Main {
	static EntityManagerFactory emf;
	static {
		emf = Persistence.createEntityManagerFactory("Emp");
	}

	private static void addEmployee() {
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			em = emf.createEntityManager();
			et = em.getTransaction();

			Address a1_home = new Address("Maharashtra", "Sillod", "556398", "homeAddress");
			Address a1_office = new Address("Maharashtra", "Sambhajinagar", "431010", "officeAddress");
			
			
			Address a2_home = new Address("Andhra pradesh", "Vijaywada", "245678", "homeAddress");
			Address a2_office = new Address("Tamilnadu", "Madurai", "657894", "officeAddress");
			
			
			Address a3_home = new Address("Telangana", "Hyderabad", "648852", "homeAddress");
			Address a3_office = new Address("Telangana", "Vishakhapatnam", "457891", "officeAddress");
			
			
			Address a4_home = new Address("Uttarakhand", "Rishikesh", "346791", "homeAddress");
			Address a4_office = new Address("Uttarakhand", "Prayagraj", "468723", "officeAddress");
			
			Employee e1 = new Employee("Ankit", "Male", 50000, new HashSet<Address>());
			e1.getEmpAddress().add(a1_home);
			e1.getEmpAddress().add(a1_office);
			
			Employee e2 = new Employee("Sanket", "Male", 45000, new HashSet<Address>());
			e2.getEmpAddress().add(a2_home);
			e2.getEmpAddress().add(a2_office);
						
			Employee e3 = new Employee("Ravi", "Male", 30000, new HashSet<Address>());
			e3.getEmpAddress().add(a3_home);
			e3.getEmpAddress().add(a3_office);
			
			Employee e4 = new Employee("Rutuja", "Female", 420000, new HashSet<Address>());
			e4.getEmpAddress().add(a4_home);
			e4.getEmpAddress().add(a4_office);
			
			et.begin();
			em.persist(e1);
			em.persist(e2);
			em.persist(e3);
			em.persist(e4);
			et.commit();

		} catch (Exception ex) {
			et.rollback();
			System.out.println(ex.getMessage());
		} finally {
			em.close();
		}
	}

	public static void main(String[] args) {
		addEmployee();
	}

}
