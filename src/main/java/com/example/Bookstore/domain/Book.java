package com.example.Bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title, author, isbn, vuosi;
	private double price;

	public Book(String title, String author, String isbn, String vuosi, double price) {
		super();
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.vuosi = vuosi;
		this.price = price;
	}

	public String getVuosi() {
		return vuosi;
	}

	public void setVuosi(String vuosi) {
		this.vuosi = vuosi;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Book() {
	}

	public String getTitle() {
		return title;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", isbn=" + isbn + ", vuosi=" + vuosi
				+ ", price=" + price + "]";
	}

}
