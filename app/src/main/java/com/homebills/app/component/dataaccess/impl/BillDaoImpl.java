package com.homebills.app.component.dataaccess.impl;

import com.homebills.app.component.dataaccess.BillDao;
import com.homebills.entities.base.Bill;
import org.springframework.stereotype.Repository;

/**
 * Created by maksm_000 on 01.11.2015.
 */
@Repository
public class BillDaoImpl extends AbstractHibernateDAO<Bill> implements BillDao {

    public BillDaoImpl() {
        super(Bill.class);
    }

    @Override
    public long store(Bill bill) {
        return super.doSave(bill);
    }
}
