package me.linh.placeme.persistence.service;

import me.linh.placeme.persistence.dao.UserDao;
import me.linh.placeme.persistence.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * User service
 * @author linhtran
 *
 */
@Service
@Transactional
public class UserService {

	@Autowired
	private UserDao userDao;
	
	/**
	 * Create new user
	 * @param user User object
	 * @return
	 */
	public Long createUser(User user) {
		return (Long) userDao.create(user);
	}
	
	/**
	 * Check email exist or not
	 * @param email
	 * @return
	 */
	public Boolean emailExist(String email) {
		
		return !(userDao.findByEmail(email) == null);
	}
}
