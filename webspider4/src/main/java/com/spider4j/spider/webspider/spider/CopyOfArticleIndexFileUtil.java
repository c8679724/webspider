package com.spider4j.spider.webspider.spider;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.Page;
import com.google.gson.reflect.TypeToken;
import com.spider4j.spider.web.util.Application;

/**
 * 
 * 文章索引数据操作
 * 
 * @author 成天华
 * @date 2014-10-8 下午5:22:26
 */
public class CopyOfArticleIndexFileUtil {

    private static Logger logger = LoggerFactory.getLogger(CopyOfArticleIndexFileUtil.class);

    public static Map<String, Date> urlsMap = new HashMap<String, Date>();

    @Test
    public void test() {

        Set<String> urls_ = new HashSet<String>();
        urls_.add("http://www.hit180.com/11405.html#respond");
        urls_.add("http://www.hit180.com/11405.html");
        urls_.add("http://www.hit180.com/11325.html#respond");
        urls_.add("http://www.hit180.com/11290.html#respond");
        urls_.add("http://www.hit180.com/10962.html?name=123");
        addUrlOfHtml(null, urls_, "/date/article/hit180/");
        System.out.println(Application.gson.toJson(CopyOfArticleIndexFileUtil.urlsMap.values()));
        logger.trace(Application.gson.toJson(urlsMap));
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
    public static void addUrlOfHtml(Page page, Collection<String> urls_, String webSitePath) {

        List<String> urls1 = new ArrayList<String>();
        String path = "";
        boolean status = true;
        for (String string : urls_) {

            int ind = string.indexOf('#');
            path = ind < 0 ? string : string.substring(0, ind);
            int q = path.lastIndexOf('?');
            if (q != -1) {
                path = path.substring(0, q);
            }

            status = urlsMap.containsKey(path);
            logger.trace("{} >>>>>>>> {}", path, !status);
            if (!status) {
                urls1.add(path);
                urlsMap.put(path, null);
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
    public static void addUrlOfajax(Page page, List<String> urls, String webSitePath) {

        logger.trace("");
        logger.debug("");
        addUrl(page, urls, webSitePath);
    }

    private static void addUrl(Page page, List<String> urls_, String webSitePath) {

        try {
            FileUtils.write(new File(webSitePath + "index.json"), Application.gson.toJson(urlsMap), "utf-8", false);
        } catch (IOException e) {
            logger.error("索引文件写入失败:", e);
        }
        // page.addTargetRequests(urls_);
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
    public static List<String> init(String startUrl, String webSitePath) {

        String json = null;
        List<String> requestsUrl = new ArrayList<String>();
        try {
            json = FileUtils.readFileToString(new File(webSitePath + "index.json"));
        } catch (IOException e) {
            logger.error("索引文件读取失败，可能不存在.", e);
        }

        if (json != null) {

            urlsMap = Application.gson.fromJson(json, new TypeToken<Map<String, Date>>() {
            }.getType());
            // 没有时间戳的URL默认为没有下载过的页面，需要重新下载
            // 后期如果需要进行持续更新在这里加规则
            for (String string : urlsMap.keySet()) {
                if (urlsMap.get(string) == null) {
                    requestsUrl.add(string);
                }
            }
        }

        if (requestsUrl.size() < 1) {
            requestsUrl.add(startUrl);
        }

        return requestsUrl;
    }
}
