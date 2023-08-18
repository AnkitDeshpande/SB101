package com.masai.ui;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

import com.masai.entity.Book;
import com.masai.exception.*;
import com.masai.service.BookService;
import com.masai.service.BookServiceImpl;

public class MainUI {

	static void addBook(Scanner sc) {
		System.out.print("Enter title ");
		String title = sc.nextLine();
		System.out.print("Enter author ");
		String author = sc.nextLine();
		System.out.print("Enter price ");
		BigDecimal price = new BigDecimal(sc.nextDouble());
		sc.nextLine();
		System.out.print("Enter publishing date ");
		LocalDate publishDate = LocalDate.parse(sc.next());
		
		BookService bs = new BookServiceImpl();
		try {
			Book b = new Book(title, author, price, publishDate);
			bs.addBook(b);
			System.out.println("Book Added Successfully");
		} catch (SomeThingWentWrongException e) {
			System.out.println(e.getMessage());
		}
	}
	
	static void findBookById(Scanner sc) {
		
	}
	
	static void updateBookPriceById(Scanner sc) {
		
	}
	
	static void deleteBookById(Scanner sc) {
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int choice = 0;
		do {
			System.out.println("1. Add Book");
			System.out.println("2. View Book By id");
			System.out.println("3. update Book price By id");
			System.out.println("4. Delete Book By id");
			System.out.println("0. Exit");
			System.out.print("Enter Selection ");
			choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 1:
				addBook(sc);
				break;
			case 2:
				findBookById(sc);
				break;
			case 3:
				updateBookPriceById(sc);
				break;
			case 4:
				deleteBookById(sc);
				break;
			case 0:
				System.out.println("Thanks for using our services");
				break;
			default:
				System.out.println("Invalid selection, try again");
			}
		} while (choice != 0);

		sc.close();
	}

}
