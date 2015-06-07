package com.spider4j.spider.webspider.dao;

import org.crazycake.jdbcTemplateTool.JdbcTemplateTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.spider4j.spider.webspider.model.Stock_ind;

@Component
public class Stock_indDAOImpl implements Stock_indDAO {

    @Autowired
    private JdbcTemplateTool jdbcTemplateTool;

    public void insert(Stock_ind record) throws Exception {

        
        jdbcTemplateTool.save(record);
    }
}