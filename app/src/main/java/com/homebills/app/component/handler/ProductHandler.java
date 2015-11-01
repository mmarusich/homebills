package com.homebills.app.component.handler;

import com.homebills.entities.representation.ProductRO;

import java.util.List;

/**
 * Created by maksm_000 on 09.08.2015.
 */
public interface ProductHandler {

    List<ProductRO> getByCategoryId(long categoryId, String query, int limit);

    ProductRO save(ProductRO productRO);

    boolean checkName(long categoryId, String name);
}
