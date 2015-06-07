package com.spider4j.spider.webspider.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.apache.http.HttpHost;

public class HttpProxy {

    private static final List<HttpHost> httpHosts = new ArrayList<HttpHost>();

    /** 获取新的http代理服务器 **/
    public void getNewHttpProxys() {

        String httpProxysUrl = "http://api.shikongjiyi.com/v1/proxy/getproxy.php?counts=200";
        HttpRequest request = HttpRequest.get(httpProxysUrl);
        String responseBody = request.body().trim();
        System.out.println(responseBody);
        httpHosts.clear();

    }

    public static void main(String[] args) {
        new HttpProxy().getNewHttpProxys();
    }

    /**
     * 
     * 获取一个代理服务器池中的随机的一个代理服务器. <br>
     * 
     * @author sky
     * @date 2015年6月7日 下午5:27:27
     */
    public static HttpHost getHttpHost() {

        if (httpHosts.size() > 0) {
            return httpHosts.get(new Random().nextInt(httpHosts.size()));
        } else {
            return null;
        }
    }

}
