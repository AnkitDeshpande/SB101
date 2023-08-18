package com.masai.question4;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashSet;

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

		Account acc1 = new Account("A001", AccountType.SAVING, "BOB", "church gate", new HashSet<>());
		acc1.getTransactionSet().add(new Transaction(27500, TransactionType.DEBIT, LocalDate.parse("2023-04-07")));
		acc1.getTransactionSet().add(new Transaction(34000, TransactionType.CREDIT, LocalDate.parse("2023-05-08")));

		Account acc2 = new Account("A002", AccountType.CURRENT, "Axis", "South Delhi", new HashSet<>());
		acc2.getTransactionSet().add(new Transaction(27500, TransactionType.DEBIT, LocalDate.parse("2023-04-07")));
		acc2.getTransactionSet().add(new Transaction(35600, TransactionType.CREDIT, LocalDate.parse("2023-04-08")));
		acc2.getTransactionSet().add(new Transaction(28535, TransactionType.DEBIT, LocalDate.parse("2023-04-04")));

		try {
			em = emf.createEntityManager();
			et = em.getTransaction();

			et.begin();
			em.persist(acc1);
			em.persist(acc2);
			et.commit();

			System.out.println("Accounts Added successfully");

		} catch (Exception e) {
			et.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}

	}

	private static void display() {
		try (EntityManager em = emf.createEntityManager()) {
			Query q = em.createQuery("from Account a where acc_no = :acc ");
			q.setParameter("acc", "A001");
			Account acc = (Account) q.getSingleResult();
			System.out.println(acc);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		insert();
		System.out.println();
		display();
	}

}
