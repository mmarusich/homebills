package com.homebills.app.component.dataaccess;

import com.homebills.entities.base.Category;

import java.util.List;

/**
 * Created by maksm_000 on 07.06.2015.
 */
public interface CategoryDao {

    List<Category> loadAll();

    long store(Category category);

    Category findById(long id);
}
