package com.homebills.entities.representation;

import com.homebills.entities.base.Bill;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by maksm_000 on 03.08.2015.
 */
public class BillRO implements Serializable {

    private long id;
    private double cost;
    private long productId;
    private long categoryId;
    private Date createDate;

    public BillRO() {
    }

    public BillRO(Bill bill) {
        this.id = bill.getId();
        this.cost = bill.getCost();
        this.createDate = bill.getCreateDate();
        this.productId = bill.getProductId();
        this.categoryId = bill.getCategoryId();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BillRO billRO = (BillRO) o;

        if (id != billRO.id) return false;
        if (Double.compare(billRO.cost, cost) != 0) return false;
        if (productId != billRO.productId) return false;
        if (categoryId != billRO.categoryId) return false;
        return !(createDate != null ? !createDate.equals(billRO.createDate) : billRO.createDate != null);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        temp = Double.doubleToLongBits(cost);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (int) (productId ^ (productId >>> 32));
        result = 31 * result + (int) (categoryId ^ (categoryId >>> 32));
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        return result;
    }
}
