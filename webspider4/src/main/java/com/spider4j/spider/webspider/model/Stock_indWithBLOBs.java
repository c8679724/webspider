package com.spider4j.spider.webspider.model;

public class Stock_indWithBLOBs extends Stock_ind {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column stock_ind.url
     *
     * @mbggenerated
     */
    private String url;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column stock_ind.icon_url
     *
     * @mbggenerated
     */
    private String iconUrl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column stock_ind.intro
     *
     * @mbggenerated
     */
    private String intro;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column stock_ind.content
     *
     * @mbggenerated
     */
    private String content;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column stock_ind.extjson
     *
     * @mbggenerated
     */
    private String extjson;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column stock_ind.url
     *
     * @return the value of stock_ind.url
     *
     * @mbggenerated
     */
    public String getUrl() {
        return url;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column stock_ind.url
     *
     * @param url the value for stock_ind.url
     *
     * @mbggenerated
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column stock_ind.icon_url
     *
     * @return the value of stock_ind.icon_url
     *
     * @mbggenerated
     */
    public String getIconUrl() {
        return iconUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column stock_ind.icon_url
     *
     * @param iconUrl the value for stock_ind.icon_url
     *
     * @mbggenerated
     */
    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl == null ? null : iconUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column stock_ind.intro
     *
     * @return the value of stock_ind.intro
     *
     * @mbggenerated
     */
    public String getIntro() {
        return intro;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column stock_ind.intro
     *
     * @param intro the value for stock_ind.intro
     *
     * @mbggenerated
     */
    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column stock_ind.content
     *
     * @return the value of stock_ind.content
     *
     * @mbggenerated
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column stock_ind.content
     *
     * @param content the value for stock_ind.content
     *
     * @mbggenerated
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column stock_ind.extjson
     *
     * @return the value of stock_ind.extjson
     *
     * @mbggenerated
     */
    public String getExtjson() {
        return extjson;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column stock_ind.extjson
     *
     * @param extjson the value for stock_ind.extjson
     *
     * @mbggenerated
     */
    public void setExtjson(String extjson) {
        this.extjson = extjson == null ? null : extjson.trim();
    }
}