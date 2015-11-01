package com.homebills.app.component.handler.impl;

import com.homebills.app.component.dataaccess.CategoryDao;
import com.homebills.app.component.handler.CategoryHandler;
import com.homebills.entities.base.Category;
import com.homebills.entities.representation.CategoryRO;
import com.homebills.entities.types.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maksm_000 on 07.06.2015.
 */
@Component
public class CategoryHandlerImpl implements CategoryHandler {

    @Autowired
    private CategoryDao categoryDao;

    public List<CategoryRO> getAll() {
        List<Category> categories = categoryDao.loadAll();
        List<CategoryRO> result = new ArrayList<>();
        for(Category category : categories){
            result.add(new CategoryRO(category));
        }
        return result;
    }

    public CategoryRO save(CategoryRO categoryRO) {
        long id = categoryDao.store(parse(categoryRO));
        categoryRO.setId(id);
        return categoryRO;
    }

    private Category parse(CategoryRO categoryRO) {
        Category category = new Category();
        category.setId(categoryRO.getId());
        category.setName(categoryRO.getName());
        category.setStatus(Status.ACTIVE);
        return category;
    }
}
