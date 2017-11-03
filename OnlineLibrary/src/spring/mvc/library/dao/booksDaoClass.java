package spring.mvc.library.dao;

import org.hibernate.query.Query;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.mvc.library.data.books;

@Repository
public class booksDaoClass implements booksDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addBook(books Book) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Query<books> theQuery = 
				currentSession.createQuery("from books Where Title=? AND Author=? AND Owner=?",books.class);
		theQuery.setParameter(0, Book.getTitle());
		theQuery.setParameter(1, Book.getAuthor());
		theQuery.setParameter(2, Book.getOwner());
		try{
			theQuery.getSingleResult();
		}catch(NoResultException nrp){
			currentSession.save(Book);
			
		}
	}

	@Override
	public List<books> getBooks(String LibraryUser) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Query<books> theQuery = 
				currentSession.createQuery("from books Where Owner=? and Wypozyczona=?",books.class);
		theQuery.setParameter(0, LibraryUser);
		theQuery.setParameter(1, "false");
		List<books> ListBooks = theQuery.getResultList();
		
		return ListBooks;
	}

	@Override
	public List<books> getAllBooks() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<books> theQuery = 
				currentSession.createQuery("from books Order By Title ASC",books.class);
		List<books> ListBooks = theQuery.getResultList();
		
		return ListBooks;	
	}

	@Override
	public books getBookById(int Id) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Query<books> theQuery = 
				currentSession.createQuery("from books Where Id=?",books.class);
		theQuery.setParameter(0, Id);
		books Book = theQuery.getSingleResult();
		
		return Book;
	}

}
