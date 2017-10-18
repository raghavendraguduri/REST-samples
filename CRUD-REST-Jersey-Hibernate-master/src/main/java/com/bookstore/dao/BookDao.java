package com.bookstore.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bookstore.model.Book;


public class BookDao {

	public void addBook(Book book){
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.save(book);
		tx.commit();
		session.close();
		
	}
	
	public Book getLastInsertedBook(){
		
		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from Book order by id DESC");
		query.setMaxResults(1);
		Book book = (Book) query.uniqueResult();
		return book;
		
	}
	
	public Book getBookById(int bookId){
		
		Session session = SessionUtil.getSession();
		String hql = "from Book where id = :id";
		Query query = session.createQuery(hql);
		query.setInteger("id", bookId);
		Book book = (Book) query.list().get(0);
		return book;
		
	}
	
	public List<Book> getBooks(){
		
		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from Book");
		List<Book> books = (List<Book>)query.list();
		session.close();
		return books;
	}
	
	public int deleteBook(int bookId){
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "delete from Book where id = :id";
		Query query = session.createQuery(hql);
		query.setInteger("id", bookId);
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected : "+rowCount);
		tx.commit();
		session.close();
		
		return rowCount;
	}
	
	public int updateBook(int id, Book book){
		if(id < 0)
			return 0;
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "update Book set name = :name, author = :author, publication = :publication, category = :category, noOfPages = :noOfPages, price = :price where id = :id";
		Query query = session.createQuery(hql);
		query.setInteger("id", id);
		query.setString("name", book.getName());
		query.setString("author", book.getAuthor());
		query.setString("category", book.getCategory());
		query.setString("publication", book.getPublication());
		query.setInteger("noOfPages", book.getNoOfPages());
		query.setInteger("price", book.getPrice());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected : "+rowCount);
		tx.commit();
		session.close();
		
		return rowCount;
		
	}
	public static void main(String[] args) {
		
		BookDao bd = new BookDao();
		Book b = new Book(2, "ada", "adasd", "werwr", "gddsgs", 300, 30);
		int row = bd.updateBook(2,b);
		System.out.println(row);
	}
	
	
}
