package com.homebills.app.component.handler.impl;

import com.homebills.app.component.handler.BillsGridHandler;
import com.homebills.entities.representation.BillGridRO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by maksm_000 on 07.11.2015.
 */
@Component
public class BillsGridHandlerImpl implements BillsGridHandler {

    private static final String GET_DATA_SQL = "SELECT " +
            "   bill.id, " +
            "   bill.cost, " +
            "   bill.create_date AS createDate, " +
            "   bill.product_id AS productId, " +
            "   bill.category_id AS categoryId, " +
            "   product.name AS productName, " +
            "   category.name AS categoryName " +
            "       FROM " +
            "           bill " +
            "           LEFT JOIN product ON product.id = bill.product_id " +
            "           LEFT JOIN category ON category.id = product.category_id " +
            "   WHERE category.id = ? " +
            "   ORDER BY %s %s" +
            "   LIMIT %s OFFSET %s";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<BillGridRO> getData(long categoryId, int limit, int offset, String sort, String dir) {
        return jdbcTemplate.query(String.format(GET_DATA_SQL, sort, dir, limit, offset), getEntityRowMapper(), categoryId);
    }

    public RowMapper getEntityRowMapper() {
        return ParameterizedBeanPropertyRowMapper.newInstance(BillGridRO.class);
    }
}
