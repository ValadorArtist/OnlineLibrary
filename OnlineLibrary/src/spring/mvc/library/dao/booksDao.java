package spring.mvc.library.dao;

import java.util.List;

import spring.mvc.library.data.books;

public interface booksDao {

	public void addBook(books Book);
	public List<books> getAllBooks();
	public List<books> getBooks(String LibraryUser);
	public books getBookById(int Id);
}
