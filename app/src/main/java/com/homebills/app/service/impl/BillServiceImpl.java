package com.homebills.app.service.impl;

import com.homebills.app.component.handler.BillHandler;
import com.homebills.app.service.BillService;
import com.homebills.entities.representation.BillRO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by maksm_000 on 01.11.2015.
 */
@Service
public class BillServiceImpl implements BillService {

    @Autowired
    private BillHandler billHandler;

    @Override
    public BillRO save(BillRO billRO) {
        return billHandler.save(billRO);
    }
}
