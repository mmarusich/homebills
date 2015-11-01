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
    private Date createDate;

    public BillRO() {
    }

    public BillRO(Bill bill) {
        this.id = bill.getId();
        this.cost = bill.getCost();
        this.createDate = bill.getCreateDate();
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
}
