package com.masai.dao;

import java.util.List;

import com.masai.dto.Book;
import com.masai.exceptions.NorecordsFoundException;
import com.masai.exceptions.SomethingWentWrongException;

public interface BookDao {
	void create(Book book) throws SomethingWentWrongException;

	void update(Book book) throws SomethingWentWrongException, NorecordsFoundException;

	void delete(String bookCode) throws SomethingWentWrongException, NorecordsFoundException;

	Book findById(String bookCode) throws SomethingWentWrongException, NorecordsFoundException;

	List<Book> findByRangeAndYear(int minPages, int maxPages, int year) throws SomethingWentWrongException;
}