package service;

import java.util.List;

import dao.UserDAO;
import model.User;

public class UserService {

	UserDAO userDao = new UserDAO();
	
	public User createUser(User user) {
		User userResponse = userDao.createUser(user);
		return userResponse;
	}

	public List<User> getAllUsers() {
		List<User> userList = userDao.getAllUsers();
		return userList;
	}

	public User updateUser(User user) {
		User userResponse = userDao.updateUser(user);
		return userResponse;
	}

	public void removeUser(String id) {
		userDao.removeUser(id);	
	}
}
