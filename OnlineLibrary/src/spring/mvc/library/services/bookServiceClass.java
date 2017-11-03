package spring.mvc.library.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import  spring.mvc.library.dao.booksDao;
import spring.mvc.library.data.books;

@Service
public class bookServiceClass implements bookService {

	@Autowired
	private booksDao booksDao;

	@Override
	@Transactional
	public void addBook(books Book) {
		
		booksDao.addBook(Book);
	}

	@Override
	@Transactional
	public List<books> getBooks(String libraryUser) {
		
		return booksDao.getBooks(libraryUser);
	}

	@Override
	@Transactional
	public List<books> getAllBooks() {
		return booksDao.getAllBooks();
	}

	@Override
	@Transactional
	public books getBookById(int Id) {
		return booksDao.getBookById(Id);
	}
	
}
