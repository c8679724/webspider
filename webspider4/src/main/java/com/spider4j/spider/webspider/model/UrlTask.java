package com.spider4j.spider.webspider.model;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.codec.digest.DigestUtils;

public class UrlTask {

    public static Map<String, UrlTask> urlTasks = new HashMap<String, UrlTask>();

    static {
        
        String[] strings = new String[] { "http://weibo.com/alibuybuy", "http://weibo.com/tmtpost", " http://weibo.com/600121819" };
        UrlTask urlTask = null;
        for (int i = 0; i < strings.length; i++) {
            urlTask = new UrlTask();
            urlTask.setUrl(strings[i]);
            urlTask.setId(DigestUtils.md5Hex(strings[i]));
            urlTasks.put(urlTask.getId(), urlTask);
        }
    }

    private String id;
    private String url;
    private Map<String, String> param;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, String> getParam() {
        return param;
    }

    public void setParam(Map<String, String> param) {
        this.param = param;
    }

}
