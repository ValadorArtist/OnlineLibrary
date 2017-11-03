package spring.mvc.library.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookLendingDaoClass implements BookLendingDao {

	@Autowired
	private SessionFactory sessionFactory;
}
