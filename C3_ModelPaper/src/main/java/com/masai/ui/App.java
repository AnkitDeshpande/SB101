package com.masai.ui;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.masai.dto.Book;
import com.masai.exceptions.NorecordsFoundException;
import com.masai.exceptions.SomethingWentWrongException;
import com.masai.service.BookService;
import com.masai.service.BookServiceImpl;

public class App {

	private static void create(Scanner scanner) {
		System.out.print("Enter book code: ");
		String bookCode = scanner.nextLine();
		System.out.print("Enter name: ");
		String name = scanner.nextLine();
		System.out.print("Enter price: ");
		BigDecimal price = scanner.nextBigDecimal();
		System.out.print("Enter publish date (YYYY-MM-DD): ");
		LocalDate publishDate = LocalDate.parse(scanner.next());
		System.out.print("Enter number of pages: ");
		int numberOfPages = scanner.nextInt();
		scanner.nextLine(); // Consume the newline character
		System.out.print("Enter writer name: ");
		String writerName = scanner.nextLine();
		Book book = new Book(bookCode, name, price, publishDate, numberOfPages, writerName);
		try {
			BookService bs = new BookServiceImpl();
			bs.create(book);
		} catch (SomethingWentWrongException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void update(Scanner scanner) {
		System.out.print("Enter book code: ");
		String bookCode = scanner.nextLine();
		System.out.print("Enter name: ");
		String name = scanner.nextLine();
		System.out.print("Enter price: ");
		BigDecimal price = scanner.nextBigDecimal();
		System.out.print("Enter publish date (YYYY-MM-DD): ");
		LocalDate publishDate = LocalDate.parse(scanner.next());
		System.out.print("Enter number of pages: ");
		int numberOfPages = scanner.nextInt();
		scanner.nextLine(); // Consume the newline character
		System.out.print("Enter writer name: ");
		String writerName = scanner.nextLine();
		Book book = new Book(bookCode, name, price, publishDate, numberOfPages, writerName);
		try {
			BookService bs = new BookServiceImpl();
			bs.update(book);
		} catch (SomethingWentWrongException | NorecordsFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void delete(Scanner scanner) {
		System.out.print("Enter book code: ");
		String bookCode = scanner.nextLine();
		try {
			BookService bs = new BookServiceImpl();
			bs.delete(bookCode);
		} catch (SomethingWentWrongException | NorecordsFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void findAll(Scanner scanner) {
		System.out.print("Enter the minimum number of pages: ");
		int minPages = scanner.nextInt();
		System.out.print("Enter the maximum number of pages: ");
		int maxPages = scanner.nextInt();
		System.out.print("Enter the year of publication: ");
		int year = scanner.nextInt();
		try {
			BookService bs = new BookServiceImpl();
			List<Book> books = bs.findByRangeAndYear(minPages, maxPages, year);
			books.stream().forEach(System.out::println);
		} catch (SomethingWentWrongException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void findById(Scanner scanner) {
		System.out.print("Enter book code: ");
		String bookCode = scanner.nextLine();
		try {
			BookService bs = new BookServiceImpl();
			Book book = bs.findById(bookCode);
			System.out.println(book);
		} catch (SomethingWentWrongException | NorecordsFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);

		int ch = 0;
		do {
			System.out.println("---------------------------------------------------------");
			System.out.println("1. Add new Book.");
			System.out.println("2. Update book by book code.");
			System.out.println("3. Delete a book.");
			System.out.println("4. Find all books by number of pages & published date");
			System.out.println("5. Find book by book code. ");
			System.out.println("0. Exit");
			System.out.println("---------------------------------------------------------");
			System.out.println("Enter your choice : ");

			ch = sc.nextInt();
			sc.nextLine();

			switch (ch) {
			case 0:
				System.out.println("Have a nice day.");
				break;
			case 1:
				create(sc);
				break;
			case 2:
				update(sc);
				break;
			case 3:
				delete(sc);
				break;
			case 4:
				findAll(sc);
				break;
			case 5:
				findById(sc);
				break;
			default:
				System.out.println("Invalid Input");
			}

		} while (ch != 0);
	}
}
