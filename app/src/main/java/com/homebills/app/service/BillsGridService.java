package com.homebills.app.service;

import com.homebills.entities.representation.BillGridRO;

import java.util.List;

/**
 * Created by maksm_000 on 07.11.2015.
 */
public interface BillsGridService {

    List<BillGridRO> getData(long categoryId, int limit, int offset, String sort, String dir);
}
