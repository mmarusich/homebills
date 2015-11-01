package com.homebills.app.service.impl;

import com.homebills.app.component.handler.ProductHandler;
import com.homebills.app.service.ProductService;
import com.homebills.entities.representation.ProductRO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by maksm_000 on 09.08.2015.
 */
@Service
public class ProductServiceImpl implements ProductService {
    
    @Autowired
    private ProductHandler productHandler;

    @Override
    public List<ProductRO> getByCategoryId(long categoryId, String query, int limit) {
        return productHandler.getByCategoryId(categoryId, query, limit);
    }

    @Override
    public ProductRO save(ProductRO productRO) {
        return productHandler.save(productRO);
    }

    @Override
    public boolean checkName(long categoryId, String name) {
        return productHandler.checkName(categoryId, name);
    }
}
