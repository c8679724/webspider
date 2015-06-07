package com.spider4j.spider.webspider.model;

import java.util.Date;

/**
 * 
 * 文章.
 * 
 * @author 成天华
 * @date 2014-10-8 上午7:39:13
 */
public class Article {

    /**
     * ID(URL经过md5计算后的结果)
     */
    private String id;

    /**
     * 文章URL
     */
    private String url;

    /**
     * 文章的所属网站
     */
    private String host;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 文章的标识图片(URL)
     */
    private String icoUrl;

    /**
     * 文章的标识图片标题
     */
    private String icoTitle;

    /**
     * 文章所属栏目
     */
    private String category;

    /**
     * 文章的关键字
     */
    private String keyword;

    /**
     * 发布者
     */
    private String writer;

    /**
     * 撰稿者
     */
    private String reporter;

    /**
     * 来源
     */
    private String articleSource;

    /**
     * 发布时间
     */
    private String releaseTime;

    /**
     * 页面浏览数
     */
    private int pageView;

    /**
     * 评论数(小于实际评论数，通过微博评论的可能不能收录)
     */
    private int commentNum;

    /**
     * 转发数
     */
    private int transmitNum;

    /**
     * 赞数
     */
    private int praiseNum;

    /**
     * 不认同数
     */
    private int disagreeNum;

    /**
     * 文章简介
     */
    private String introduce;

    /**
     * 文章正文
     */
    private String articleBody;

    /**
     * 评论
     */
    private Comment[] comments;

    /**
     * 条目采集时间
     */
    private Date createTime;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

    public String getArticleSource() {
        return articleSource;
    }

    public void setArticleSource(String articleSource) {
        this.articleSource = articleSource;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public int getPageView() {
        return pageView;
    }

    public void setPageView(int pageView) {
        this.pageView = pageView;
    }

    public int getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }

    public int getTransmitNum() {
        return transmitNum;
    }

    public void setTransmitNum(int transmitNum) {
        this.transmitNum = transmitNum;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getArticleBody() {
        return articleBody;
    }

    public void setArticleBody(String articleBody) {
        this.articleBody = articleBody;
    }

    public Comment[] getComments() {
        return comments;
    }

    public void setComments(Comment[] comments) {
        this.comments = comments;
    }

    public int getPraiseNum() {
        return praiseNum;
    }

    public void setPraiseNum(int praiseNum) {
        this.praiseNum = praiseNum;
    }

    public int getDisagreeNum() {
        return disagreeNum;
    }

    public void setDisagreeNum(int disagreeNum) {
        this.disagreeNum = disagreeNum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIcoUrl() {
        return icoUrl;
    }

    public void setIcoUrl(String icoUrl) {
        this.icoUrl = icoUrl;
    }

    public String getIcoTitle() {
        return icoTitle;
    }

    public void setIcoTitle(String icoTitle) {
        this.icoTitle = icoTitle;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

}
