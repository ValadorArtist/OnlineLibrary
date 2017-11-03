package spring.mvc.library.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.mvc.library.dao.BookLendingDao;

@Service
public class BookLendingServiceClass implements BookLendingService {

	@Autowired
	private BookLendingDao bookLendingDao;
	
	
	
}
