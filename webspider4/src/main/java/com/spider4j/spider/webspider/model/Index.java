package com.spider4j.spider.webspider.model;

import java.util.Date;
import com.spider4j.spider.web.util.Application;

public class Index {

    private String id;
    private String url;
    private String host;
    private UrlType urlType;
    private Date date;

    public static void main(String[] args) {
        Index index = new Index();
        index.setUrl("");
        index.setUrlType(UrlType.Article);
        System.out.println(Application.gson.toJson(index));
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public UrlType getUrlType() {
        return urlType;
    }

    public void setUrlType(UrlType urlType) {
        this.urlType = urlType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public int hashCode() {
        return this.url.hashCode();
    }

    @Override
    public boolean equals(Object obj) {

        Index index = (Index) obj;
        return this.url.equals(index.getUrl());
    }
}
