package com.homebills.app.component.dataaccess;

import com.homebills.entities.base.Product;

import java.util.List;

/**
 * Created by maksm_000 on 09.08.2015.
 */
public interface ProductDao {

    List<Product> findByCategoryId(long categoryId, String query);

    List<Product> findByName(long categoryId, String name);

    long store(Product product);
}
