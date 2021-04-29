package com.bookstore.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bookstore.configuration.HibernateUtils;
import com.bookstore.entities.Book;
import com.bookstore.entities.Publisher;
import com.bookstore.entities.Writer;

public class Driver {
	public static void main(String[] args) {
		//hibernatepersist();
		hibernateGet();
	}
	public static void hibernatepersist() {
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		Publisher publisher = new Publisher();
		publisher.setFullName("Metis Yayınları");
		publisher.setNumberOfBooks(0);
		
		Writer writer = new Writer();
		writer.setFullName("George Orwell");
		writer.setNumberOfBooks(0);
		
		Book book = new Book();
		book.setFullName("Hayvan Çiftliği");
		book.setReleaseYear(1949);
		book.setPublisher(publisher);
		book.setWriter(writer);
		
		session.persist(publisher);
		session.persist(writer);
		session.persist(book);
		transaction.commit();
		session.beginTransaction();
		
		Publisher publisher2 = new Publisher();
		publisher2.setFullName("İthaki Yayınları");
		publisher2.setNumberOfBooks(0);
		
		session.persist(publisher2);
	
		transaction.commit();
		session.close();
		HibernateUtils.getSessionFactory().close();
	}
	
	public static void hibernateGet() {
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		Book book = session.get(Book.class, "B0006");
		System.out.println(book.getFullName() + " Is the book");
		
		
		transaction.commit();
		session.close();
		HibernateUtils.getSessionFactory().close();
	}
	

}
