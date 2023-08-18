package com.masai.question1;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {

	static EntityManagerFactory emf;

	static {
		emf = Persistence.createEntityManagerFactory("c4eval");
	}

	public static void main(String[] args) {
		System.out.println("Hello World!");
	}
}
