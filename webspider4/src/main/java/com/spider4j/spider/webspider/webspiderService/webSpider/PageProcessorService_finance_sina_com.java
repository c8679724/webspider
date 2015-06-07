package com.spider4j.spider.webspider.webspiderService.webSpider;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.HttpHost;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.utils.UrlUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.spider4j.spider.web.util.HtmlUtil;
import com.spider4j.spider.web.util.HttpRequest;
import com.spider4j.spider.webspider.model.Stock_ind;
import com.spider4j.spider.webspider.service.Stock_indService;
import com.spider4j.spider.webspider.service.URLService;
import com.spider4j.spider.webspider.util.HttpProxy;
import com.spider4j.spider.webspider.webspiderService.IWebSpider;

@Component
public class PageProcessorService_finance_sina_com implements PageProcessor, IWebSpider {

    private static Logger logger = LoggerFactory.getLogger(PageProcessorService_finance_sina_com.class);

    @Autowired
    private URLService urlService;

    @Autowired
    private Stock_indService stock_indService;

    /**
     * 栏目地址列表
     */
    private static String[] categoryList = new String[] { "http://roll.finance.sina.com.cn/s/channel.php?ch=03#col=43&spec=&type=&ch=03&k=&offset_page=0&offset_num=0&num=60&asc=&page=1" };

    /**
     * 栏目地址正则表达式列表
     */
    private static String[] categoryRegexList = new String[] { "http://roll\\.finance\\.sina\\.com\\.cn/s/channel\\.php\\?ch=03#col=43&spec=&type=&ch=03&k=&offset_page=0&offset_num=0&num=60&asc=&page=\\d" };

    private Spider spider = null;

    /**
     * 网站字符编码集
     */
    private static String webSiteCharSet = "gb2312";

    /**
     * 站点域名
     */
    private static String host = "sina.com.cn";

    /**
     * 站点设置
     */
    private static Site site = Site.me().setCharset(webSiteCharSet).setTimeOut(10 * 1000).setRetryTimes(3)
            .setSleepTime(1000 * 20).setDomain(UrlUtils.getDomain(host));;

    public static Set<String> categoryList_ = new HashSet<String>();

    public void init() {

        String[] urls_ = get1000Article();
        for (String url : urls_) {
            if (urlService.isNewURLByURL(url)) {
                urlService.addUrls(host, url);
            }
        }

        if (spider == null) {

            spider = Spider.create(this)
            // 设置爬虫起点
                    .addUrl(urls_)
                    // 添加(处理抽取结果)类
                    // .addPipeline(articlePipeline)
                    // 开启多少个线程抓取
                    .thread(1);
        } else {
            spider.addUrl(urls_);
        }

        // 设置http代理
        HttpHost httpHost = HttpProxy.getHttpHost();
        if (httpHost != null) {
            site.setHttpProxy(httpHost);
        }
    }

    public String[] get1000Article() {

        String js = "";
        int pageSize = 100;
        int pageNo = 1;
        List<String> urls = new ArrayList<String>();
        double r = new Random().nextDouble();
        for (int j = 0; j < 10; j++) {
            pageNo = j;
            String getUrl = "http://roll.news.sina.com.cn/interface/rollnews_ch_out_interface.php?col=43&spec=&type=&ch=03&k=&offset_page=0&offset_num=0&num="
                    + pageSize + "&asc=&page=" + pageNo + "&r=" + r;
            HttpRequest request = HttpRequest.get(getUrl);
            js = request.body();
            JsonObject jo = (JsonObject) new JsonParser().parse(js.replace("var jsonData = ", "").replace(";", ""));
            JsonElement list_jo = jo.get("list");

            if (list_jo.isJsonArray()) {
                JsonArray listArray = list_jo.getAsJsonArray();
                for (int i = 0; i < listArray.size(); i++) {
                    urls.add(listArray.get(i).getAsJsonObject().get("url").getAsString());
                }
            }
        }
        String[] rs = new String[urls.size()];
        rs = urls.toArray(rs);
        return rs;
    }

    public void start() {
        spider.start();
    }

    @Override
    public void stop() {
        spider.stop();
    }

    public String getStatus() {

        return this.spider.getStatus().name();
    }

    private static String[] urlPatterns = new String[] { "http://.+\\.sina\\.com\\.cn/.+/\\d.shtml" };

    @Override
    public void process(Page page) {

        String page_url = page.getUrl().get();

        int urlType = 0;
        if (HtmlUtil.regex(page_url, categoryRegexList)) {
            urlType = 0;
        } else {
            urlType = 1;
        }

        if (urlType == 0) { // 如果当前页面是栏目页

            // 把网页源码转成Jsoup对象
            Document html = Jsoup.parse(page.getHtml().toString());
            logger.warn(page.getHtml().toString());

            // 从当前页面发现有用的链接
            List<String> allUrls = HtmlUtil.links(html);
            logger.trace("allUrls:{}", allUrls);

            // 发现文章页面
            Set<String> urls_ = new HashSet<String>();
            for (int i = 0; i < urlPatterns.length; i++) {
                urls_.addAll(HtmlUtil.regex(allUrls, urlPatterns[i]));
            }

            logger.trace("文章页面地址:{}", urls_);

            for (String url : urls_) {
                if (urlService.isNewURLByURL(url)) {
                    urlService.addUrls(host, url);
                    page.addTargetRequest(url);
                }
            }
        } else if (urlType == 1) { // 如果是文章页面

            String html = page.getHtml().get();
            Document document = Jsoup.parse(html);
            Stock_ind stock_ind = new Stock_ind();
            String title = document.select("h1#artibodyTitle").text();
            if (title.trim().length() > 1) {

                stock_ind.setTitle(title);
                stock_ind.setUrl(page_url);
                stock_ind.setMd5url(DigestUtils.md5Hex(page_url));
                stock_ind.setContent(html);
                stock_ind.setSrctype(Byte.parseByte("4"));
                stock_ind.setUpdateTime(new Date());
                stock_indService.addStock_ind(stock_ind);
            }
        } else {
            logger.warn("一个不是文章页也不是栏目页的地址;{}{}", page_url);
        }

        urlService.updateURLToNow(page_url);
    }

    @Override
    public Site getSite() {
        return site;
    }
}
