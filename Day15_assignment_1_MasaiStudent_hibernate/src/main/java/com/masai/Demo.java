package com.masai;

import java.util.List;
import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class Demo {
	static EntityManagerFactory emf;

	static {
		emf = Persistence.createEntityManagerFactory("Student");
	}

	private static void displayStudentDetails() {
		try(EntityManager em = emf.createEntityManager()) {
			Scanner sc = new Scanner(System.in);
            System.out.print("Enter the name of the student: ");
            String name = sc.nextLine();
            
            String q = "Select s from MasaiStudent s where s.name = :name";
            Query query = em.createQuery(q, MasaiStudent.class);
            query.setParameter("name", name);
            MasaiStudent student = (MasaiStudent) query.getSingleResult();
            
            if(student !=null) {
            	student.displayDetails();
            	System.out.println("Student Have to pay :" + student.payFee());
            }else {
            	System.out.println("Student Not Found!");
            }
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		displayStudentDetails();
	}
}
