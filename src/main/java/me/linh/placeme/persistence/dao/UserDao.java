package me.linh.placeme.persistence.dao;

import me.linh.placeme.persistence.dao.common.HibernateDao;
import me.linh.placeme.persistence.model.User;

/**
 * Dao for User model
 * @author linhtran
 * 
 */
public interface UserDao extends HibernateDao<User> {

	public User findByEmail(String email);
	public User findByUsername(String username);
}
