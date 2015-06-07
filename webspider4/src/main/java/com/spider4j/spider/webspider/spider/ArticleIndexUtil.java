package com.spider4j.spider.webspider.spider;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.Page;
import com.google.gson.reflect.TypeToken;
import com.spider4j.spider.web.util.Application;
import com.spider4j.spider.webspider.model.Index;

/**
 * 
 * 文章索引数据操作
 * 
 * @author 成天华
 * @date 2014-10-8 下午5:22:26
 */
public class ArticleIndexUtil {

    private static Logger logger = LoggerFactory.getLogger(ArticleIndexUtil.class);

    public static Set<Index> urls = new HashSet<Index>();

    @Test
    public void test() {

        Set<String> urls_ = new HashSet<String>();
        urls_.add("http://www.hit180.com/11405.html#respond");
        urls_.add("http://www.hit180.com/11405.html");
        urls_.add("http://www.hit180.com/11405.html#1");
        urls_.add("http://www.hit180.com/11405.html?method=test#2");
        urls_.add("http://www.hit180.com/11405.html#3");
        urls_.add("http://www.hit180.com/11325.html#respond");
        urls_.add("http://www.hit180.com/11290.html#respond");
        urls_.add("http://www.hit180.com/10962.html?name=123");
        urls_.add("http://www.hit180.com/10962.html");
        addUrlOfHtml(null, urls_, "/data/article/hit180/");
        logger.trace(Application.gson.toJson(urls));
    }

    /**
     * 
     * 添加无参url进入队列.
     * 
     * @return void
     * @throws
     * @author 成天华
     * @date 2014-10-9 上午10:08:35
     */
    public synchronized static void addUrlOfHtml(Page page, Collection<String> urls_, String webSitePath) {

        List<String> urls1 = new ArrayList<String>();
        String path = "";
        boolean status = true;
        for (String string : urls_) {

            int ind = string.indexOf('#');
            path = ind < 0 ? string : string.substring(0, ind);

            Index index = new Index();
            index.setUrl(path);
            status = urls.add(index);
            logger.trace("{} >>>>>>>> {}", path, status ? "不存在，加入下载队列" : "已存在，不处理");
            if (status) {
                urls1.add(path);
            }
        }

        addUrl(page, urls1, webSitePath);
    }

    /**
     * 
     * 添加可变参数的url进入队列. <br>
     * 
     * @return void
     * @throws
     * @author 成天华
     * @date 2014-10-9 上午10:08:09
     */
    public synchronized static void addUrlOfajax(Page page, List<String> urls, String webSitePath) {

        logger.trace("");
        logger.debug("");
        addUrl(page, urls, webSitePath);
    }

    private synchronized static void addUrl(Page page, List<String> urls_, String webSitePath) {

        try {
            FileUtils.write(new File(webSitePath + "index.json"), Application.gson.toJson(urls), "utf-8", false);
        } catch (IOException e) {
            logger.error("索引文件写入失败:", e);
        }
        page.addTargetRequests(urls_);
    }

    /**
     * 
     * 网站爬虫初始化起始地址和地址池. <br>
     * 详细说明
     * 
     * @param startURL
     * @return
     * @return Map<String,Object>param:{startURL,requestsUrl}
     * @throws
     * @author 成天华
     * @date 2014-10-10 上午10:53:30
     */
    public synchronized static List<String> init(String startUrl, String webSitePath) {

        String json = null;
        List<String> requestsUrl = new ArrayList<String>();
        try {
            json = FileUtils.readFileToString(new File(webSitePath + "index.json"));
        } catch (IOException e) {
            logger.error("索引文件读取失败，可能不存在.", e);
        }

        if (json != null) {

            try {
                urls = Application.gson.fromJson(json, new TypeToken<Set<Index>>() {
                }.getType());
            } catch (Exception e) {
                logger.error("", e);
            }

            // 没有时间戳的URL默认为没有下载过的页面，需要重新下载
            // 后期如果需要进行持续更新在这里加规则
            List<Index> indexs = new ArrayList<Index>();
            indexs.addAll(urls);
            Index index = null;
            for (int i = 0; i < indexs.size(); i++) {
                index = indexs.get(i);
                if (index.getDate() == null) {
                    requestsUrl.add(index.getUrl());
                }
            }
        }

        if (requestsUrl.size() < 1) {
            requestsUrl.add(startUrl);
        }

        return requestsUrl;
    }
}
