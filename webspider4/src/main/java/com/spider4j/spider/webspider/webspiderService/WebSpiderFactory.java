package com.spider4j.spider.webspider.webspiderService;

import com.spider4j.spider.web.util.Application;
import com.spider4j.spider.webspider.webspiderService.webSpider.PageProcessorService_finance_sina_com;
import com.spider4j.spider.webspider.webspiderService.webSpider.PageProcessorService_xueqiu_com;

public class WebSpiderFactory {

    public enum WebSpiderType {

        finance_sina_com, xueqiu_com
    }

    public static IWebSpider createWebSpider(WebSpiderType webSpiderType) {

        IWebSpider iWebSpider = null;

        switch (webSpiderType) {
        case finance_sina_com:
            iWebSpider = Application.applicationContext.getBean(PageProcessorService_finance_sina_com.class);
            break;
        case xueqiu_com:
            iWebSpider = Application.applicationContext.getBean(PageProcessorService_xueqiu_com.class);
            break;
        default:
            break;
        }

        return iWebSpider;
    }
}
