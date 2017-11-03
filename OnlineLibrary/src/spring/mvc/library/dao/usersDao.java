package spring.mvc.library.dao;

import java.util.List;

import spring.mvc.library.data.users;

public interface usersDao {

	public users getUser(String login);
	public String checkUser(users User);
	public void addUser(users User);
	public void activateUser(String userName);
	public List<users> getAccessLibrary(String login);
}
