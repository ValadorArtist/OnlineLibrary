package spring.mvc.library.services;

import java.util.List;

import spring.mvc.library.data.users;

public interface userService {

	public users getUser(String login);
	public String checkUser(users User);
	public void addUser(users User);
	public void activateUser(String name);
	public List<users> getAccessUsers(String login);
}
