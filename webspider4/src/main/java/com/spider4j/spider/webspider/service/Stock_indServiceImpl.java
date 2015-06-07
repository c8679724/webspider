package com.spider4j.spider.webspider.service;

import java.util.Date;
import org.apache.commons.codec.digest.DigestUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spider4j.spider.webspider.dao.Stock_indDAO;
import com.spider4j.spider.webspider.model.Stock_ind;

@Service
public class Stock_indServiceImpl implements Stock_indService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private Stock_indDAO stock_indDAO;

    @Override
    public void addHtml(String url, String html) {

        Document document = Jsoup.parse(html);

        Stock_ind stock_ind = new Stock_ind();
        stock_ind.setTitle(document.select("h4.status-title").text());
        stock_ind.setUrl(url);
        stock_ind.setMd5url(DigestUtils.md5Hex(url));
        stock_ind.setContent(html);
        stock_ind.setUpdateTime(new Date());
        try {
            stock_indDAO.insert(stock_ind);
        } catch (Exception e) {
            logger.warn("插入html失败{}:", url, e);
        }
    }

    @Override
    public void addStock_ind(Stock_ind stock_ind) {
        try {
            stock_indDAO.insert(stock_ind);
        } catch (Exception e) {
            logger.warn("插入html失败-->html:{}-->md5:{}", stock_ind.getUrl(), stock_ind.getMd5url(), e);
        }
    }
}
