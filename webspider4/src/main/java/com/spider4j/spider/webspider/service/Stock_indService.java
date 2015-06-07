package com.spider4j.spider.webspider.service;

import com.spider4j.spider.webspider.model.Stock_ind;

public interface Stock_indService {

    public void addHtml(String url, String html);

    public void addStock_ind(Stock_ind stock_ind);
}
