package com.spider4j.spider.webspider.dao;

import com.spider4j.spider.webspider.model.UrlInd;

public interface UrlIndDAO {

    void insert(UrlInd record) throws Exception;

    UrlInd selectByPrimaryKey(String url) throws Exception;

    void updateByPrimaryKey(UrlInd record) throws Exception;
}