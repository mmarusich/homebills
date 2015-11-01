package com.homebills.app.component.dataaccess.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.List;

/**
 * @author Maxim Marusich
 */
public class AbstractHibernateDAO<T extends Serializable> {

    private final Class<T> cls;
    @Qualifier("sessionFactory")
    @Autowired
    private SessionFactory sessionFactory;

    public AbstractHibernateDAO(Class<T> cls) {
        this.cls = cls;
    }

    public long save(final T entity) {
        return (Long) this.getCurrentSession().save(entity);
    }

    public void saveOrUpdate(final T entity) {
        this.getCurrentSession().saveOrUpdate(entity);
    }

    public T getById(final long id) {
        return (T) this.getCurrentSession().get(this.cls, id);
    }

    public <V extends T> V getById(final long id, final Class<V> cls) {
        return (V) this.sessionFactory.getCurrentSession().get(cls, id);
    }

    public List<T> getAll() {
        return this.getCurrentSession()
                .createQuery("FROM " + this.cls.getName()).list();
    }

    protected <V> V executeQueryForOne(final Query query) {

        List<V> entities = query.setFetchSize(1).list();

        if(CollectionUtils.isEmpty(entities)) {
            return null;
        }

        return entities.get(0);
    }

    protected <V> List<V> executeQuery(final Query query) {
        return query.list();
    }

    public void create(final T entity) {
        this.getCurrentSession().persist(entity);
    }

    public void update(final T entity) {
        this.getCurrentSession().merge(entity);
    }

    public void delete(final T entity) {
        this.getCurrentSession().delete(entity);
    }

    public void deleteById(final Long entityId) {
        final T entity = this.getById(entityId);
        this.delete(entity);
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected final Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    protected final Class<T> getCls() {
        return this.cls;
    }
}
