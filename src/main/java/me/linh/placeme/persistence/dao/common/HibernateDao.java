package me.linh.placeme.persistence.dao.common;

import java.io.Serializable;
import java.util.List;

/**
 * Interface for common dao
 * @author linhtran
 *
 * @param <T> Type of object
 */
public interface HibernateDao<T extends Serializable> {

    T findOne(final long id);

    List<T> findAll();

    Object create(final T entity);

    T update(final T entity);

    void delete(final T entity);

    void deleteById(final long entityId);
}
