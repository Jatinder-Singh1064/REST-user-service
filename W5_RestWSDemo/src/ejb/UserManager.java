package ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import dao.UserDAO;

/**
 * Session Bean implementation class UserManager
 */
@Stateless(mappedName = "user")
@LocalBean
public class UserManager {
	
	UserDAO userDao = new UserDAO();

	public int getMaxUserCount() {
		return 100;
	}

	public int getCurrentUserCount() {
		return userDao.getCurrentUserCount();	
	}

}

