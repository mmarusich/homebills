package com.homebills.web.controller;

import com.homebills.app.service.ProductService;
import com.homebills.entities.representation.ProductRO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by maksm_000 on 09.08.2015.
 */
@Controller
@RequestMapping(value = "product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    List<ProductRO> getByCategoryId(@RequestParam long categoryId, @RequestParam String query, @RequestParam int limit) {
        return productService.getByCategoryId(categoryId, query, limit);
    }

    @RequestMapping(value = "/checkName", method = RequestMethod.GET)
    public
    @ResponseBody
    Boolean checkName(@RequestParam long categoryId, @RequestParam String name) {
        return productService.checkName(categoryId, name);
    }

    @RequestMapping(method = RequestMethod.POST)
    public
    @ResponseBody
    ProductRO save(@RequestBody ProductRO productRO) {
        return productService.save(productRO);
    }
}
