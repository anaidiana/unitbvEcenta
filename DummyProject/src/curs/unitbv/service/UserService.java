package curs.unitbv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curs.unitbv.beans.UserBean;
import curs.unitbv.dao.UserDAO;

@Service
public class UserService {

	@Autowired
	private UserDAO userDao;

	public UserBean findUser(String userId) {
		return userDao.findUser(userId);
	}

	public UserBean loginUser(String userId, String password) {
		UserBean user = findUser(userId);
		if (user != null && user.getPassword().equals(password)) {
			return user;
		}
		return null;
	}

}
