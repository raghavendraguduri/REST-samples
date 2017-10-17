package com.bookstore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.dao.IBookDAO;
import com.bookstore.entity.Book;

@Service
public class BookService implements IBookService {

	@Autowired 
	private IBookDAO dao;// we are creating a variable for the interface and not the class as it is more flexible if there would any changes
	//to our class in future.
	
	public List<Book> getbooks() {
		// TODO Auto-generated method stub
		
		return dao.getBooks();
		
		
	}

	public Book createbook(Book book) {
		
		return dao.insertBook(book);
	}

	public Book updatebook(int id, Book book) {
		// TODO Auto-generated method stub
		
		
		
		return dao.updateBook(id,book);
	}

	public boolean deletebook(int id) {
		// TODO Auto-generated method stub
		
		return dao.deleteBook(id);
	}
	
	
	

}
