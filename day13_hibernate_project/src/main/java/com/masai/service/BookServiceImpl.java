package com.masai.service;


import java.math.BigDecimal;

import com.masai.dao.BookDAOImpl;
import com.masai.dao.BookDDAO;
import com.masai.entity.Book;
import com.masai.exception.NoRecordsFoundException;
import com.masai.exception.SomeThingWentWrongException;

public class BookServiceImpl implements BookService {

	@Override
	public void addBook(Book book) throws SomeThingWentWrongException {
		BookDDAO bd = new BookDAOImpl();
		bd.addBook(book);
	}

	@Override
	public Book getBookById(int id) throws SomeThingWentWrongException, NoRecordsFoundException {
		BookDDAO bd = new BookDAOImpl();
		return bd.getBookById(id);
	}

	@Override
	public void updateBookPrice(int id, BigDecimal price) throws SomeThingWentWrongException, NoRecordsFoundException {
		BookDDAO bd = new BookDAOImpl();
		bd.updateBookPrice(id, price);
	}

	@Override
	public void deleteBookById(int id) throws SomeThingWentWrongException, NoRecordsFoundException {
		BookDDAO bd = new BookDAOImpl();
		bd.deleteBookById(id);
	}

}
