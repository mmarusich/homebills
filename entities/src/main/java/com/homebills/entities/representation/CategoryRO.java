package com.homebills.entities.representation;

import com.homebills.entities.base.Category;

import java.io.Serializable;

/**
 * Created by maksm_000 on 07.06.2015.
 */
public class CategoryRO implements Serializable {

    private long id;
    private String name;

    public CategoryRO(Category category) {
        this.id = category.getId();
        this.name = category.getName();
    }

    public CategoryRO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
