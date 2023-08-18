package com.masai.service;

import java.util.List;

import com.masai.dao.BookDao;
import com.masai.dao.BookDaoImpl;
import com.masai.dto.Book;
import com.masai.exceptions.NorecordsFoundException;
import com.masai.exceptions.SomethingWentWrongException;

public class BookServiceImpl implements BookService {

	@Override
	public void create(Book book) throws SomethingWentWrongException {
		BookDao bd = new BookDaoImpl();
		bd.create(book);
	}

	@Override
	public void update(Book book) throws SomethingWentWrongException, NorecordsFoundException {
		BookDao bd = new BookDaoImpl();
		bd.update(book);
	}

	@Override
	public void delete(String bookCode) throws SomethingWentWrongException, NorecordsFoundException {
		BookDao bd = new BookDaoImpl();
		bd.delete(bookCode);
	}

	@Override
	public Book findById(String bookCode) throws SomethingWentWrongException, NorecordsFoundException {
		BookDao bd = new BookDaoImpl();
		return bd.findById(bookCode);
	}

	@Override
	public List<Book> findByRangeAndYear(int minPages, int maxPages, int year) throws SomethingWentWrongException {
		BookDao bd = new BookDaoImpl();
		return bd.findByRangeAndYear(minPages, maxPages, year);
	}

}
