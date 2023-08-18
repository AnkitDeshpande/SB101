package com.masai.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

public class Book {
	private String bookCode;
	private String name;
	private BigDecimal price;
	private LocalDate publishDate;
	private int numberOfPages;
	private String writerName;

	public Book() {
	}

	public Book(String bookCode, String name, BigDecimal price,
			LocalDate publishDate, int numberOfPages,
			String writerName) {
		this.bookCode = bookCode;
		this.name = name;
		this.price = price;
		this.publishDate = publishDate;
		this.numberOfPages = numberOfPages;
		this.writerName = writerName;
	}

	public String getBookCode() {
		return bookCode;
	}

	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public LocalDate getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	public String getWriterName() {
		return writerName;
	}

	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}

	@Override
	public String toString() {
		return "Book{" + "bookCode='" + bookCode + '\'' + ", name='" + name + '\'' + ", price=" + price
				+ ", publishDate=" + publishDate + ", numberOfPages=" + numberOfPages + ", writerName='" + writerName
				+ '\'' + '}';
	}
}
