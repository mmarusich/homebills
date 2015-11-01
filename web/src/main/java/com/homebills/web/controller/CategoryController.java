package com.homebills.web.controller;

import com.homebills.app.service.CategoryService;
import com.homebills.entities.representation.CategoryRO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by maksm_000 on 07.06.2015.
 */
@Controller
@RequestMapping(value = "category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<CategoryRO> getAll(){
        return categoryService.getAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody CategoryRO save(@RequestBody CategoryRO categoryRO){
        return categoryService.save(categoryRO);
    }
}
