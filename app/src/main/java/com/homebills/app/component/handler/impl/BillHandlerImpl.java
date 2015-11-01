package com.homebills.app.component.handler.impl;

import com.homebills.app.component.dataaccess.BillDao;
import com.homebills.app.component.handler.BillHandler;
import com.homebills.entities.base.Bill;
import com.homebills.entities.representation.BillRO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by maksm_000 on 01.11.2015.
 */
@Component
public class BillHandlerImpl implements BillHandler {

    @Autowired
    private BillDao billDao;

    @Override
    public BillRO save(BillRO billRO) {
        long id = billDao.store(parse(billRO));
        billRO.setId(id);
        return billRO;
    }

    private Bill parse(BillRO billRO) {
        Bill bill = new Bill();
        bill.setCategoryId(billRO.getCategoryId());
        bill.setProductId(billRO.getProductId());
        bill.setCost(billRO.getCost());
        bill.setCreateDate(billRO.getCreateDate());
        return bill;
    }
}
