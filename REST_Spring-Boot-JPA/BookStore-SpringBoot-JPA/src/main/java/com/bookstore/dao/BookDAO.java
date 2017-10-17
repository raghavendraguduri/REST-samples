package com.bookstore.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bookstore.entity.Book;

@Transactional
@Repository
//These annotations are used to get the hibernate object 
public class BookDAO implements IBookDAO {
	
@PersistenceContext
//To store data in the enitites the scope of the persistence of the data is controlled by the word context.
//This annotation is used for the entity manager

private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Book> getBooks() {
		// TODO Auto-generated method stub
		String hql = "FROM Book";
		Query query = em.createQuery(hql);
		List<Book> books = (List<Book>)query.getResultList();
		return books;
	}
	
	//write one method will give you the last inserted record from database
	private Book getLastInsertedBook() {
		
		String hql="FROM Book order by id DESC ";
		
		Query query=em.createQuery(hql);
		query.setMaxResults(1);//this will take the first record after desecending order sorting
		Book book=(Book)query.getSingleResult();//Auto casting the object retreived into book type(this is downcasting since it is specified in the brackets)
		
		return book;
	}

	public Book insertBook(Book book) {
		// TODO Auto-generated method stub
		//Persist means to insert data into DB
		em.persist(book);
		
		
		Book b=getLastInsertedBook();
		return b;
		//since the return type of the above method is void we need to write another method which will return us the latest inserted record
		
		
	}
	
	
	// write one private method which will take id as an argument and return book object.
	private Book getBookById(int id) {
		Book book = em.find(Book.class, id);
		return book;
	}

	public Book updateBook(int ID,Book book) {

		Book bookToBeUpdated = getBookById(ID); // this object we got from database by given id
		
		// here i am setting values which we got from user and setting in book object which we got from database
		bookToBeUpdated.setName(book.getName());
		bookToBeUpdated.setAuthor(book.getAuthor());
		bookToBeUpdated.setCategory(book.getCategory());
		bookToBeUpdated.setPublication(book.getPublication());
		bookToBeUpdated.setPrice(book.getPrice());
		bookToBeUpdated.setTotalPage(book.getTotalPage());
		em.flush();//It will commit the changes into the DB
		
		Book b = getBookById(ID);
		
		return b;
	}

	public boolean deleteBook(int id) {
		// TODO Auto-generated method stub
		
		Book bookToBeDeleted=getBookById(id);
		if(bookToBeDeleted!=null)
			em.remove(bookToBeDeleted);
		boolean isDeleted = em.contains(bookToBeDeleted);// We are checking here that whether entity manager contains the deleted data or not
		if(!isDeleted) {
			return true;
		}
		return false;
	}
	
	
	

}
