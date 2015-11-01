package com.homebills.web.controller;

import com.homebills.app.service.BillService;
import com.homebills.entities.representation.BillRO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by maksm_000 on 01.11.2015.
 */
@Controller
@RequestMapping(value = "bill")
public class BillController {

    @Autowired
    private BillService billService;

    @RequestMapping(method = RequestMethod.POST)
    public
    @ResponseBody
    BillRO create(@RequestBody BillRO billRO) {
        return billService.save(billRO);
    }
}
