package me.linh.placeme.persistence.dao.common;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Preconditions;

/**
 * Hibernate common Dao
 * @author linhtran
 *
 * @param <T>
 */
@SuppressWarnings("unchecked")
@Transactional
@Repository
public abstract class HibernateDaoImpl<T extends Serializable> implements HibernateDao<T> {

	private Class<T> clazz;

	@Autowired
    private SessionFactory sessionFactory;

    // API

    protected final void setClazz(final Class<T> clazzToSet) {
        clazz = Preconditions.checkNotNull(clazzToSet);
    }

    public final T findOne(final long id) {
        return (T) getCurrentSession().get(clazz, id);
    }

    public final List<T> findAll() {
        return getCurrentSession().createQuery("from " + clazz.getName()).list();
    }

    public final Object create(final T entity) {
        Preconditions.checkNotNull(entity);
        // getCurrentSession().persist(entity);
        return getCurrentSession().save(entity);
    }

    public final T update(final T entity) {
        Preconditions.checkNotNull(entity);
        return (T) getCurrentSession().merge(entity);
    }

    public final void delete(final T entity) {
        Preconditions.checkNotNull(entity);
        getCurrentSession().delete(entity);
    }

    public final void deleteById(final long entityId) {
        final T entity = findOne(entityId);
        Preconditions.checkState(entity != null);
        delete(entity);
    }

    protected final Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
    
    public void setSessionFactory(SessionFactory sessionFactory) {
    	this.sessionFactory = sessionFactory;
    }
}
