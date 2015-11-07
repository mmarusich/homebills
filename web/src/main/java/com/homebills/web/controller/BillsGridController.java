package com.homebills.web.controller;

import com.homebills.app.service.BillsGridService;
import com.homebills.entities.representation.BillGridRO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by maksm_000 on 03.08.2015.
 */
@Controller
@RequestMapping(value = "bill/grid")
public class BillsGridController {

    @Autowired
    private BillsGridService billsGridService;

    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    List<BillGridRO> getBills(@RequestParam long categoryId, @RequestParam int limit, @RequestParam(value = "start") int offset,
                              @RequestParam String sort, @RequestParam String dir) {
        return billsGridService.getData(categoryId, limit, offset, sort, dir);
    }


}
