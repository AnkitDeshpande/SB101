package com.masai.dao;


import java.math.BigDecimal;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;

import com.masai.entity.Book;
import com.masai.exception.NoRecordsFoundException;
import com.masai.exception.SomeThingWentWrongException;
import com.masai.utitlity.EMUtils;



public class BookDAOImpl implements BookDDAO {

	@Override
	public void addBook(Book book) throws SomeThingWentWrongException {
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			em = EMUtils.getEntityManager();
			System.out.println(em);
			et = em.getTransaction();
			et.begin();
			em.persist(book);
			et.commit();
		} catch (PersistenceException e) {
			et.rollback();
			throw new SomeThingWentWrongException("Unable to add book, Try again later.");
		}catch(Exception ep){
			System.out.println(ep.getMessage());
		}finally {
			if(em!=null) {
				em.close();
			}
		}
	}

	@Override
	public Book getBookById(int id) throws SomeThingWentWrongException, NoRecordsFoundException {

		return null;
	}

	@Override
	public void updateBookPrice(int id, BigDecimal price) throws SomeThingWentWrongException, NoRecordsFoundException {

	}

	@Override
	public void deleteBookById(int id) throws SomeThingWentWrongException, NoRecordsFoundException {

	}

}
