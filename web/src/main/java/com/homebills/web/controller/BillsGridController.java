package com.homebills.web.controller;

import com.homebills.app.service.BillService;
import com.homebills.entities.representation.BillRO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

/**
 * Created by maksm_000 on 03.08.2015.
 */
@Controller
@RequestMapping(value = "bill")
public class BillsGridController {

    @Autowired
    private BillService billService;

    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    List<BillRO> getBills(@RequestParam long categoryId, @RequestParam int limit, @RequestParam(value = "start") int offset,
                          @RequestParam String sort, @RequestParam String dir) {
        return Collections.EMPTY_LIST;
    }

    @RequestMapping(method = RequestMethod.POST)
    public
    @ResponseBody
    BillRO create(@RequestBody BillRO billRO) {
        return billService.save(billRO);
    }
}
