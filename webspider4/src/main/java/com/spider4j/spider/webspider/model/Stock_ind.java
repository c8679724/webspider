package com.spider4j.spider.webspider.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "stock_ind")
public class Stock_ind {

    private Long id;

    private String md5url;

    private String title;

    private String iconTitle;

    private String category;

    private String keyword;

    private String keyword1;

    private Long wbid;

    private String openid;

    private String writer;

    private String reporter;

    private String releaseTime;

    private Date publishTime;

    private Integer pageView;

    private Integer praNum;

    private Integer cmtNum;

    private Integer retNum;

    private Integer readNum;

    private Byte srctype;

    private Float rank;

    private Float score;

    private Byte hmflag;

    private Byte status;

    private Date updateTime;

    private String url;

    private String iconUrl;

    private String intro;

    private String content;

    private String extjson;

    @Id
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "md5url")
    public String getMd5url() {
        return md5url;
    }

    public void setMd5url(String md5url) {
        this.md5url = md5url == null ? null : md5url.trim();
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    @Column(name = "icon_title")
    public String getIconTitle() {
        return iconTitle;
    }

    public void setIconTitle(String iconTitle) {
        this.iconTitle = iconTitle == null ? null : iconTitle.trim();
    }

    @Column(name = "category")
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    @Column(name = "keyword")
    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }

    @Column(name = "keyword1")
    public String getKeyword1() {
        return keyword1;
    }

    public void setKeyword1(String keyword1) {
        this.keyword1 = keyword1 == null ? null : keyword1.trim();
    }

    @Column(name = "wbid")
    public Long getWbid() {
        return wbid;
    }

    public void setWbid(Long wbid) {
        this.wbid = wbid;
    }

    @Column(name = "openid")
    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    @Column(name = "writer")
    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer == null ? null : writer.trim();
    }

    @Column(name = "reporter")
    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter == null ? null : reporter.trim();
    }

    @Column(name = "release_time")
    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime == null ? null : releaseTime.trim();
    }

    @Column(name = "publish_time")
    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    @Column(name = "page_view")
    public Integer getPageView() {
        return pageView;
    }

    public void setPageView(Integer pageView) {
        this.pageView = pageView;
    }

    @Column(name = "pra_num")
    public Integer getPraNum() {
        return praNum;
    }

    public void setPraNum(Integer praNum) {
        this.praNum = praNum;
    }

    @Column(name = "cmt_num")
    public Integer getCmtNum() {
        return cmtNum;
    }

    public void setCmtNum(Integer cmtNum) {
        this.cmtNum = cmtNum;
    }

    @Column(name = "ret_num")
    public Integer getRetNum() {
        return retNum;
    }

    public void setRetNum(Integer retNum) {
        this.retNum = retNum;
    }

    @Column(name = "read_num")
    public Integer getReadNum() {
        return readNum;
    }

    public void setReadNum(Integer readNum) {
        this.readNum = readNum;
    }

    @Column(name = "srctype")
    public Byte getSrctype() {
        return srctype;
    }

    public void setSrctype(Byte srctype) {
        this.srctype = srctype;
    }

    @Column(name = "rank")
    public Float getRank() {
        return rank;
    }

    public void setRank(Float rank) {
        this.rank = rank;
    }

    @Column(name = "score")
    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    @Column(name = "hmflag")
    public Byte getHmflag() {
        return hmflag;
    }

    public void setHmflag(Byte hmflag) {
        this.hmflag = hmflag;
    }

    @Column(name = "status")
    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    @Column(name = "update_time")
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    @Column(name = "icon_url")
    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl == null ? null : iconUrl.trim();
    }

    @Column(name = "intro")
    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }

    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    @Column(name = "extjson")
    public String getExtjson() {
        return extjson;
    }

    public void setExtjson(String extjson) {
        this.extjson = extjson == null ? null : extjson.trim();
    }
}