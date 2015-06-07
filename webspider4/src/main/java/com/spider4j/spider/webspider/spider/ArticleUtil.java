package com.spider4j.spider.webspider.spider;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.spider4j.spider.web.util.Application;
import com.spider4j.spider.webspider.model.Article;

/**
 * 
 * 文章数据操作.
 * 
 * @author 成天华
 * @date 2014-10-8 下午5:22:09
 */
public class ArticleUtil {

    private static Logger logger = LoggerFactory.getLogger(ArticleUtil.class);

    /**
     * 爬虫目录
     */
    public static String filePath = "/data/article/";
    
    public static void write(Article article, String fileName) {
        String data = "";
        try {
            data = Application.gson.toJson(article) + "\r\n";
        } catch (Exception e) {
            logger.warn("", e);
            data = "\r\n";
        }
        
        try {
            FileUtils.writeStringToFile(new File(fileName), data, "utf-8", true);
        } catch (IOException e) {
            logger.warn("", e);
        }
    }
}
