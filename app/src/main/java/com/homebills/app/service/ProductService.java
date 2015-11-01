package com.homebills.app.service;

import com.homebills.entities.representation.ProductRO;

import java.util.List;

/**
 * Created by maksm_000 on 09.08.2015.
 */
public interface ProductService {

    List<ProductRO> getByCategoryId(long categoryId, String query);

    ProductRO save(ProductRO productRO);

    boolean checkName(long categoryId, String name);
}
