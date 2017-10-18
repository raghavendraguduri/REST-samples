package com.bookstore;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.bookstore.dao.BookDao;
import com.bookstore.model.Book;
import com.bookstore.model.HealthCheck;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("bookservice")
public class BookService {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
	private BookDao bd = new BookDao();
    @GET
    @Path("/test")
    @Produces(MediaType.APPLICATION_JSON)
    public HealthCheck healthCheckUp() {
    	
    	HealthCheck check = new HealthCheck("BookStoreService", "1.0", true);
    	return check;
    }
    
    @GET
    @Path("/books")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getBooks(){
    	
    	List<Book> books = bd.getBooks();
    	return books;
    }
    
    @POST
    @Path("books")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Book addBook(Book book){
    	
    	bd.addBook(book);
    	Book b = bd.getLastInsertedBook();
    	return b;
    }
    
    @PUT
    @Path("books/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Book updateBook(@PathParam("id") int id, Book book){
    	int rowCount = bd.updateBook(id, book);
    	Book b = null;
    	if(rowCount == 1) {
    		b = bd.getBookById(id);
    	}
    	return b;
    }
    
    @DELETE
    @Path("books/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteBook(@PathParam("id") int id){
    	String message = null;
    	int rowCount = bd.deleteBook(id);
    	if(rowCount == 1){
    		message = "Book has been deleted Successfully..!!";
    	}else{
    		message = "Error while deleting book from database..!!";
    	}
    	return message;
    }
    
}
