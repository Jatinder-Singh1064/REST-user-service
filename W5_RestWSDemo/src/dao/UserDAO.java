package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.User;

public class UserDAO {
	
	static HashMap<String, User> userMap = new HashMap<String, User>();

	public UserDAO() {
		User user1 = new User();
		user1.setId("1");
		user1.setName("John");
		user1.setAge(40);
		
		User user2 = new User();
		user2.setId("2");
		user2.setName("Alice");
		user2.setAge(35);
		
		userMap.put("1", user1);
		userMap.put("2", user2);
	}
	
	public User createUser(User user) {
		userMap.put(user.getId(), user);
		return userMap.get(user.getId());
	}
	
	public  User updateUser(User user) {
		System.out.println(user.getId());
		System.out.println(user.getName());
		System.out.println(user.getAge());
		if(user.getId().isEmpty()) {
			return null;
		}
		userMap.put(user.getId(), user);
		return userMap.get(user.getId());
	}

	public List<User> getAllUsers() {
		List<User> userList = new ArrayList<User>(userMap.values());
		return userList;
	}

	public void removeUser(String id) {
		userMap.remove(id);		
	}

	public int getCurrentUserCount() {
		return userMap.size();
	}
}
