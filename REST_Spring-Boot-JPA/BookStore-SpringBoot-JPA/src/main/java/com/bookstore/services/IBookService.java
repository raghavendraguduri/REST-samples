package com.bookstore.services;

import java.util.List;

import com.bookstore.entity.Book;


public interface IBookService {
	
	List<Book> getbooks();
	Book createbook(Book book);
	Book updatebook(int id,Book book);//Here ID number is not given by user but will be hidden in UI.
	boolean deletebook(int id);//same as above.
	
	

}
