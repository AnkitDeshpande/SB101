package com.masai.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Book")
public class Book {
	@Id
	@Column(name = "book_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 75, nullable = false, unique = true)
	private String title;
	@Column(length = 40, nullable = false)
	private String author;
	@Column(nullable = false, precision = 7, scale = 2) // DECIMAL(7,2) ---> xxxxx.yy (max value = 99999.99)
	private BigDecimal price;
	@Column(name = "publish_date")
	private LocalDate publishDate;

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(String title, String author, BigDecimal price, LocalDate publishDate) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
		this.publishDate = publishDate;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
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

	@Override
	public String toString() {
		return "book [id=" + id + ", title=" + title + ", author=" + author + ", price=" + price + ", publishDate="
				+ publishDate + "]";
	}

}
