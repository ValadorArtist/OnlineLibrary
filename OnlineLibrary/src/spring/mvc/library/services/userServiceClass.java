package spring.mvc.library.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.mvc.library.dao.usersDao;
import spring.mvc.library.data.users;


@Service
public class userServiceClass implements userService {
	
	@Autowired
	private usersDao usersDao;
	
	@Override
	@Transactional
	public users getUser(String login) {
		
		return usersDao.getUser(login);
	}

	@Override
	@Transactional
	public String checkUser(users User) {
		return usersDao.checkUser(User);
	}
	
	@Override
	@Transactional
	public void addUser(users User) {
		usersDao.addUser(User);
	}

	@Override
	@Transactional
	public void activateUser(String name) {
		usersDao.activateUser(name);
		
	}

	@Override
	@Transactional
	public List<users> getAccessUsers(String login) {
		return usersDao.getAccessLibrary(login);
	}

}
