package com.masai.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.masai.dto.Book;
import com.masai.exceptions.NorecordsFoundException;
import com.masai.exceptions.SomethingWentWrongException;
import com.masai.utility.DB;

public class BookDaoImpl implements BookDao {

	@Override
	public void create(Book book) throws SomethingWentWrongException {
		Connection con = null;
		try {
			con = DB.connect();
			String query = "Insert into book values(?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, book.getBookCode());
			ps.setString(2, book.getName());
			ps.setBigDecimal(3, book.getPrice());
			ps.setDate(4, Date.valueOf(book.getPublishDate()));
			ps.setInt(5, book.getNumberOfPages());
			ps.setString(6, book.getWriterName());

			System.out.println(
					ps.executeUpdate() > 0 ? "Book added successfully" : "Book cannot be added, try again later.");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(con);
		}
	}

	@Override
	public void update(Book book) throws SomethingWentWrongException, NorecordsFoundException {
		Connection con = null;
		try {
			String query = "Update Book set name = ?, price = ?, publish_date = ?, number_of_pages = ?, writer_name = ? where book_code = ?";
			if (findById(book.getBookCode()) != null) {
				con = DB.connect();
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(6, book.getBookCode());
				ps.setString(1, book.getName());
				ps.setBigDecimal(2, book.getPrice());
				ps.setDate(3, Date.valueOf(book.getPublishDate()));
				ps.setInt(4, book.getNumberOfPages());
				ps.setString(5, book.getWriterName());
				System.out.println(
						ps.executeUpdate() > 0 ? "Book Updated successfully" : "Book update failed, try again later.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(con);
		}
	}

	@Override
	public void delete(String bookCode) throws SomethingWentWrongException, NorecordsFoundException {
		Connection con = null;
		try {
			con = DB.connect();
			String query = "Delete from Book where book_code = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, bookCode);
			System.out.println(ps.executeUpdate() > 0 ? "Book Deleted Successfully." : "Book cannot be deleted.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(con);
		}
	}

	@Override
	public Book findById(String bookCode) throws SomethingWentWrongException, NorecordsFoundException {
		Connection con = null;
		try {
			con = DB.connect();
			String query = "Select * from book where book_code = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, bookCode);

			ResultSet rs = ps.executeQuery();
			if (!rs.next()) {
				throw new NorecordsFoundException("Book doesn't exist.");
			} else {
				Book book = new Book();
				book.setBookCode(rs.getString(1));
				book.setName(rs.getString(2));
				book.setPrice(rs.getBigDecimal(3));
				book.setPublishDate(rs.getDate(4).toLocalDate());
				book.setNumberOfPages(rs.getInt(5));
				book.setWriterName(rs.getString(6));
				return book;
			}

		} catch (Exception e) {
			throw new NorecordsFoundException("Book doesn't Exist.");
		} finally {
			DB.close(con);
		}
	}

	@Override
	public List<Book> findByRangeAndYear(int minPages, int maxPages, int year) throws SomethingWentWrongException {
		List<Book> list = null;
		Connection con = null;
		try {
			con = DB.connect();
			String query = "Select * from book where number_of_pages between ? and ? and year(publish_date) = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, minPages);
			ps.setInt(2, maxPages);
			ps.setInt(3, year);

			ResultSet rs = ps.executeQuery();

			if (!rs.next()) {
				throw new NorecordsFoundException("Empty result set");
			} else {
				list = new ArrayList<Book>();
				do {
					Book book = new Book();
					book.setBookCode(rs.getString(1));
					book.setName(rs.getString(2));
					book.setPrice(rs.getBigDecimal(3));
					book.setPublishDate(rs.getDate(4).toLocalDate());
					book.setNumberOfPages(rs.getInt(5));
					book.setWriterName(rs.getString(6));
					list.add(book);
				} while (rs.next());
				return list;
			}

		} catch (Exception e) {
			// throw new SomethingWentWrongException("Empty list.");
			e.printStackTrace();
		} finally {
			DB.close(con);
		}
		return list;
	}

}
