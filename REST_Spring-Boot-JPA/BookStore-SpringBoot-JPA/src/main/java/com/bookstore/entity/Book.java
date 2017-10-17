package com.bookstore.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the book database table.
 *This is automated process of import the database and setting the data as variables (column names)
 *Add JPA to the project from project facets in properties -->  Right click on project JPA tools --> Generate entities from table option and 
 *it will automatically generate this class.
 */
@Entity
@Table(name="book")
@NamedQuery(name="Book.findAll", query="SELECT b FROM Book b")
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String author;

	private String category;

	private String name;

	private int price;

	private String publication;

	private int Pages;

	public Book() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPublication() {
		return this.publication;
	}

	public void setPublication(String publication) {
		this.publication = publication;
	}

	public int getTotalPage() {
		return this.Pages;
	}

	public void setTotalPage(int totalPage) {
		this.Pages = totalPage;
	}

}