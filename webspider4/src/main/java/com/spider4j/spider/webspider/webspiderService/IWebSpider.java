package com.spider4j.spider.webspider.webspiderService;

public interface IWebSpider {

    public void init();

    public void start();

    public void stop();

    public String getStatus();
}
