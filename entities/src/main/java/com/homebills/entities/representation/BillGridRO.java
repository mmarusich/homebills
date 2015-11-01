package com.homebills.entities.representation;

/**
 * Created by maksm_000 on 01.11.2015.
 */
public class BillGridRO extends BillRO {

    private String productName;
    private String categoryName;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
