package com.spider4j.spider.webspider.model;

/**
 * 
 * 评论
 * 
 * @author 成天华
 * @date 2014-10-8 上午7:38:13
 */
public class Comment {

    /**
     * 评论发表人的头像(URL)
     */
    private String ico$url;

    /**
     * 评论人
     */
    private String writer;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 评论时间
     */
    private String releaseTime;

    /**
     * 转发数
     */
    private int transmitNum;

    /**
     * 评论的评论(与comments2不共存)
     */
    private String comments1;

    /**
     * 评论的评论(与comments1不共存)
     */
    private Comment[] comments2;

    public String getIco$url() {
        return ico$url;
    }

    public void setIco$url(String ico$url) {
        this.ico$url = ico$url;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public int getTransmitNum() {
        return transmitNum;
    }

    public void setTransmitNum(int transmitNum) {
        this.transmitNum = transmitNum;
    }

    public String getComments1() {
        return comments1;
    }

    public void setComments1(String comments1) {
        this.comments1 = comments1;
    }

    public Comment[] getComments2() {
        return comments2;
    }

    public void setComments2(Comment[] comments2) {
        this.comments2 = comments2;
    }

}
