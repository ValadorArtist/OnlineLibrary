package spring.mvc.library.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.mvc.library.data.users;

@Repository
public class usersDaoClass implements usersDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public users getUser(String login) {
		users user = null;
		Session currentSession = sessionFactory.getCurrentSession();
		Query<users> theQuery = 
				currentSession.createQuery("from users where login=? AND libraryUser=? AND Access=1", users.class);
		theQuery.setParameter(0, login);
		theQuery.setParameter(1, login);
		try{
			user = theQuery.getSingleResult();
		}catch( NoResultException nre){
			return user;
		}
		return user;
	}
	
	@Override
	public String checkUser(users User) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		@SuppressWarnings({ "deprecation", "rawtypes" })
		Query theQuery = currentSession.createSQLQuery("Call `check`(?1, ?2)");
		theQuery.setParameter("1", User.getLogin());
		theQuery.setParameter("2", User.getPassword());
		String result = (String) theQuery.getSingleResult();
		return result;
	}

	@Override
	public void addUser(users User) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(User);
	}

	@Override
	public void activateUser(String userName) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Query<users> theQuery = 
				currentSession.createQuery("from users u where u.login=?1 AND u.libraryUser=?2", users.class);
		theQuery.setParameter("1", userName);
		theQuery.setParameter("2", userName);
		users User = theQuery.getSingleResult();
		User.setAccess(true);
		currentSession.update(User);
	}

	@Override
	public List<users> getAccessLibrary(String login) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Query<users> theQuery = 
				currentSession.createQuery("from users Where login=?",users.class);
		theQuery.setParameter(0, login);
		
		List<users> ListUsers = theQuery.getResultList();
		
		return ListUsers;
	}
	
	

}
