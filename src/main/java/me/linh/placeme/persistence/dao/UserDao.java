package me.linh.placeme.persistence.dao;

import me.linh.placeme.persistence.dao.common.AbstractHibernateDao;
import me.linh.placeme.persistence.model.User;

/**
 * Dao for User model
 * @author linhtran
 * 
 */
public class UserDao extends AbstractHibernateDao<User> {

	public UserDao() {
		super();
		setClazz(User.class);
	}
}
