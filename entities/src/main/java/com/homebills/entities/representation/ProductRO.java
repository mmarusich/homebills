package com.homebills.entities.representation;

import com.homebills.entities.base.Product;

import java.io.Serializable;

/**
 * Created by maksm_000 on 09.08.2015.
 */
public class ProductRO implements Serializable {

    private long id;
    private String name;
    private long categoryId;

    public ProductRO() {
    }

    public ProductRO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.categoryId = product.getCategoryId();
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

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }
}
