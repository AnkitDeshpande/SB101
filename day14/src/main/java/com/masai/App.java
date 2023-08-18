package com.masai;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {
	
	static EntityManagerFactory emf;
	static {
		emf = Persistence.createEntityManagerFactory("emp");
	}
    public static void main( String[] args ){
    	
        EntityManager em = emf.createEntityManager();
        em.close();
    }
}
