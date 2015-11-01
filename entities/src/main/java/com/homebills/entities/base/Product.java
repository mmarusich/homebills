package com.homebills.entities.base;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by maksm_000 on 07.06.2015.
 */
@Entity
public class Product implements Serializable {

    private long id;
    private String name;
    private Category category;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
