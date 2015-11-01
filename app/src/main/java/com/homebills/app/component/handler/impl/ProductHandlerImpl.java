package com.homebills.app.component.handler.impl;

import com.homebills.app.component.dataaccess.ProductDao;
import com.homebills.app.component.handler.ProductHandler;
import com.homebills.entities.base.Product;
import com.homebills.entities.representation.ProductRO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maksm_000 on 09.08.2015.
 */
@Component
public class ProductHandlerImpl implements ProductHandler {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<ProductRO> getByCategoryId(long categoryId, String query, int limit) {
        List<ProductRO> result = new ArrayList<>();
        List<Product> products = productDao.findByCategoryId(categoryId, query, limit);
        for (Product product : products) {
            result.add(new ProductRO(product));
        }
        return result;
    }

    @Override
    public ProductRO save(ProductRO productRO) {
        Product product = new Product();
        product.setName(productRO.getName());
        product.setCategoryId(productRO.getCategoryId());
        long id = productDao.store(product);
        productRO.setId(id);
        return productRO;
    }


    @Override
    public boolean checkName(long categoryId, String name) {
        List<Product> list = productDao.findByName(categoryId, name);
        return list.isEmpty();
    }
}
