package com.homebills.app.component.handler;

import com.homebills.entities.representation.BillGridRO;

import java.util.List;

/**
 * Created by maksm_000 on 07.11.2015.
 */
public interface BillsGridHandler {

    List<BillGridRO> getData(long categoryId, int limit, int offset, String sort, String dir);
}
