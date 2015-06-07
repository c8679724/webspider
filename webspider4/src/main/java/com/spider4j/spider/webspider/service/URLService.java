package com.spider4j.spider.webspider.service;

import java.util.List;

public interface URLService {

    public void addUrls(String host, String... urls);

    public boolean isNewURLByURL(String url);
    
    public String[] isNewURLByURL(String... urls);

    public List<String> getUrlsOflessTime(String host, int hour);

    public List<String> getUrlsOfTimeIsNull(String host);

    public void updateURLToNow(String url);
}
