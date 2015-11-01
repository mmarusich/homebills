package com.homebills.app.service;

import com.homebills.entities.representation.CategoryRO;

import java.util.List;

/**
 * Created by maksm_000 on 07.06.2015.
 */
public interface CategoryService {

    List<CategoryRO> getAll();

    CategoryRO save(CategoryRO category);

}
