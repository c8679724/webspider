package com.spider4j.spider.webspider.task;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.spider4j.spider.webspider.webspiderService.IWebSpider;
import com.spider4j.spider.webspider.webspiderService.WebSpiderFactory;
import com.spider4j.spider.webspider.webspiderService.WebSpiderFactory.WebSpiderType;

@Component
public class SpiderTask {

    private Logger logger = LoggerFactory.getLogger(getClass());

    public static final List<IWebSpider> iWebSpiders = new ArrayList<IWebSpider>();

    public static boolean created = true;

    public void create() {
        // 新浪财经
       //iWebSpiders.add(WebSpiderFactory.createWebSpider(WebSpiderType.finance_sina_com));

        // 雪球网
        iWebSpiders.add(WebSpiderFactory.createWebSpider(WebSpiderType.xueqiu_com));

        for (int i = 0; i < iWebSpiders.size(); i++) {
            iWebSpiders.get(i).init();
        }
    }

    public void work() {

        if (created) {
            create();
            created = false;
        }

        logger.info("定时启动爬虫任务start.");
        for (int i = 0; i < iWebSpiders.size(); i++) {
            try {
                boolean a = false;
                try {
                    if (iWebSpiders.get(i).getStatus() == "Running") {
                        a = true;
                    }
                } catch (Exception e) {

                }
                if (!a) {

                    iWebSpiders.get(i).init();
                    iWebSpiders.get(i).start();
                }
            } catch (Exception e) {
                logger.error("定时启动爬虫时发生异常:", e);
            }
        }
        logger.info("定时启动爬虫任务end.");
    }
}
