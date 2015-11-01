package com.homebills.app.component.dataaccess.impl;

import com.homebills.app.component.dataaccess.ProductDao;
import com.homebills.entities.base.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by maksm_000 on 09.08.2015.
 */
@Repository("productDao")
public class ProductDaoImpl extends AbstractHibernateDAO<Product> implements ProductDao {

    private static final String GET_BY_CATEGORY_ID_SQL = "FROM " + Product.class.getName() + " WHERE categoryId = :categoryId AND name LIKE :query";

    public ProductDaoImpl() {
        super(Product.class);
    }

    @Override
    public List<Product> findByCategoryId(long categoryId, String query, int limit) {
        return executeQuery(getCurrentSession().createQuery(GET_BY_CATEGORY_ID_SQL)
                .setLong("categoryId", categoryId)
                .setString("query", "%" + query + "%")
                .setMaxResults(limit));
    }

    @Override
    public long store(Product product) {
        return doSave(product);
    }

    @Override
    public List<Product> findByName(long categoryId, String name) {
        return executeQuery(getCurrentSession().createQuery(GET_BY_CATEGORY_ID_SQL)
                .setLong("categoryId", categoryId)
                .setString("query", name));
    }
}
