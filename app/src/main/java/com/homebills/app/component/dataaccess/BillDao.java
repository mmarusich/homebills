package com.homebills.app.component.dataaccess;

import com.homebills.entities.base.Bill;

/**
 * Created by maksm_000 on 01.11.2015.
 */
public interface BillDao {

    long store(Bill bill);
}
