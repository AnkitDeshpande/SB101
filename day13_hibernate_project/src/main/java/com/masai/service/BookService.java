package com.masai.service;

import java.math.BigDecimal;

import com.masai.entity.Book;
import com.masai.exception.NoRecordsFoundException;
import com.masai.exception.SomeThingWentWrongException;

public interface BookService {
	public void addBook(Book book) throws SomeThingWentWrongException;

	public Book getBookById(int id) throws SomeThingWentWrongException, NoRecordsFoundException;

	public void updateBookPrice(int id, BigDecimal price) throws SomeThingWentWrongException, NoRecordsFoundException;

	public void deleteBookById(int id) throws SomeThingWentWrongException, NoRecordsFoundException;
}
