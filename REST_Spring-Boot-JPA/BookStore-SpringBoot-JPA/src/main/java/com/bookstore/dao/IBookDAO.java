package com.bookstore.dao;

import java.util.List;

import com.bookstore.entity.Book;

public interface IBookDAO {
	
	List<Book> getBooks();
	Book insertBook(Book book);
	Book updateBook(int id,Book book);
	boolean deleteBook(int id);
	
	
	

}
