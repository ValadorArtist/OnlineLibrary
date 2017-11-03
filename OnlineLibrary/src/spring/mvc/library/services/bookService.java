package spring.mvc.library.services;

import java.util.List;

import spring.mvc.library.data.books;

public interface bookService {
	
	public void addBook(books Book);
	public List<books> getAllBooks();
	public List<books> getBooks(String libraryUser);
	public books getBookById(int Id);
}
