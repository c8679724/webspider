package com.spider4j.spider.webspider.service;

import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spider4j.spider.webspider.dao.UrlIndDAO;
import com.spider4j.spider.webspider.model.UrlInd;

@Service
public class URLServiceImpl implements URLService {

    private static final Logger logger = LoggerFactory.getLogger(URLServiceImpl.class);

    @Autowired
    private UrlIndDAO urlIndDAO;

    public void addUrls(String host, String... urls) {

        UrlInd urlInd = null;
        for (int i = 0; i < urls.length; i++) {
            urlInd = new UrlInd();
            urlInd.setUrl(urls[i]);
            urlInd.setHost(host);
            try {
                urlIndDAO.insert(urlInd);
            } catch (Exception e) {
                logger.warn("插入url发生异常:{}", urls[i], host, e);
            }
        }

    }

    public List<String> getUrlsOflessTime(String host, int hour) {

        return null;
    }

    public List<String> getUrlsOfTimeIsNull(String host) {

        return null;
    }

    @Override
    public void updateURLToNow(String url) {

        UrlInd urlInd = null;
        try {
            urlInd = urlIndDAO.selectByPrimaryKey(url);
            urlInd.setDate(new Date());
            urlIndDAO.updateByPrimaryKey(urlInd);
        } catch (Exception e) {
            logger.warn("更新url时间失败:{}", url, e);
        }

    }

    @Override
    public boolean isNewURLByURL(String url) {

        UrlInd urlInd = null;
        try {
            urlInd = urlIndDAO.selectByPrimaryKey(url);
        } catch (Exception e) {
            logger.warn("", e);
        }

        if (urlInd != null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public String[] isNewURLByURL(String... urls) {
        return urls;
    }
}
