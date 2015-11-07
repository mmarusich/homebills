package com.homebills.app.service.impl;

import com.homebills.app.component.handler.BillsGridHandler;
import com.homebills.app.service.BillsGridService;
import com.homebills.entities.representation.BillGridRO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by maksm_000 on 07.11.2015.
 */
@Service
public class BillsGridServiceImpl implements BillsGridService {

    @Autowired
    private BillsGridHandler billsGridHandler;

    @Override
    public List<BillGridRO> getData(long categoryId, int limit, int offset, String sort, String dir) {
        return billsGridHandler.getData(categoryId, limit, offset, sort, dir);
    }
}
