package com.homebills.app.service.impl;

import com.homebills.app.component.handler.CategoryHandler;
import com.homebills.app.service.CategoryService;
import com.homebills.entities.representation.CategoryRO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by maksm_000 on 07.06.2015.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryHandler categoryHandler;

    public List<CategoryRO> getAll() {
        return categoryHandler.getAll();
    }

    public CategoryRO save(CategoryRO category) {
        return categoryHandler.save(category);
    }
}
