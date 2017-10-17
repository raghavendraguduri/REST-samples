package com.bookstore.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookstore.entity.Book;
import com.bookstore.services.IBookService;


@Controller
@RequestMapping("BookService")
public class BookStoreController {
@Autowired	
	private IBookService ibs;

//read
@GetMapping("Books")

public ResponseEntity<List<Book>> getbooklist(){
	List<Book> booklist = ibs.getbooks();
	return new ResponseEntity<List<Book>>(booklist, HttpStatus.OK);
} 
	
//create
@PostMapping("Books")
public ResponseEntity<Book> createBook(@RequestBody Book book){
	
	Book b = ibs.createbook(book);
	return new ResponseEntity<Book>(b, HttpStatus.OK);
	
}
	
//update	
@PutMapping("Books/{ID}")
//we accept ID from the URL and accept it into the path variable ID
//so we are mapping "ID" using end point to path variable and assigning it to variable id.
public ResponseEntity<Book>updateBook(@PathVariable("ID") int id,@RequestBody Book book){
	Book b=ibs.updatebook(id, book);
	
	
	return new ResponseEntity<Book>(b, HttpStatus.OK);
}

@DeleteMapping("Books/{ID}")

public ResponseEntity<?> deleteBook(@PathVariable("ID") int id){
	
	boolean isDeleted=ibs.deletebook(id);
	String msg = null;
	if(isDeleted) {
		msg = "Book has been deleted successfully";
	}else {
		msg = "Error while deleting book";
	}
	return new ResponseEntity<>(msg,HttpStatus.OK);
}

}
