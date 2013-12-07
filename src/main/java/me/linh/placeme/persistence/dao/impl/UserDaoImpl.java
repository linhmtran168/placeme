package me.linh.placeme.persistence.dao.impl;

import me.linh.placeme.persistence.dao.UserDao;
import me.linh.placeme.persistence.dao.common.HibernateDaoImpl;
import me.linh.placeme.persistence.model.User;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends HibernateDaoImpl<User> implements UserDao{

	public UserDaoImpl() {
		super();

		setClazz(User.class);
	}
	
	/**
	 * Find a user by email
	 * @param email
	 * @return
	 */
	public User findByEmail(String email) {
		Session session = getCurrentSession();
		User user = (User) session.createQuery(
				"from User user where user.email = ?")
				.setString(0, email)
				.uniqueResult();
		return user;
	}
	
	/**
	 * Find a user by username
	 * @param username
	 * @return
	 */
	public User findByUsername(String username) {
		Session session = getCurrentSession();
		User user = (User) session.createQuery(
				"from User user where user.username = ?")
				.setString(0, username)
				.uniqueResult();

		return user;
	}

}
