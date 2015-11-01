package com.homebills.app.component.dataaccess.impl;

import com.homebills.app.component.dataaccess.CategoryDao;
import com.homebills.entities.base.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by maksm_000 on 07.06.2015.
 */
@Repository
public class CategoryDaoImpl extends AbstractHibernateDAO<Category> implements CategoryDao {

    private static final String GET_NOT_DELETED_CATEGORIES_SQL = "FROM " + Category.class.getName() + " WHERE status != 1";

    public CategoryDaoImpl() {
        super(Category.class);
    }

    public List<Category> loadAll() {
        return executeQuery(getCurrentSession().createQuery(GET_NOT_DELETED_CATEGORIES_SQL));
    }

    public long store(Category category) {
        return super.save(category);
    }

    @Override
    public Category findById(long id) {
        return getById(id);
    }
}
