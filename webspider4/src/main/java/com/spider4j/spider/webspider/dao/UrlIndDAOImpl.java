package com.spider4j.spider.webspider.dao;

import org.crazycake.jdbcTemplateTool.JdbcTemplateTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.spider4j.spider.webspider.model.UrlInd;

@Component
public class UrlIndDAOImpl implements UrlIndDAO{

    @Autowired
    private JdbcTemplateTool jdbcTemplateTool;

    public void insert(UrlInd record) throws Exception {

        jdbcTemplateTool.save(record);
    }

    public UrlInd selectByPrimaryKey(String url) throws Exception {
        
        return jdbcTemplateTool.get(UrlInd.class, url);
    }

    public void updateByPrimaryKey(UrlInd record) throws Exception {
      
        jdbcTemplateTool.update(record);
    }
}