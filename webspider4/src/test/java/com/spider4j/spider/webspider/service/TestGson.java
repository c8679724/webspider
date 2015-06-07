package com.spider4j.spider.webspider.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.junit.Test;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.spider4j.spider.web.util.HttpRequest;

public class TestGson {

    @Test
    public void test() {
        
        String js = "";
        int pageSize = 100;
        int pageNo = 1;
        double r = new Random().nextDouble();
        String getUrl = "http://roll.news.sina.com.cn/interface/rollnews_ch_out_interface.php?col=43&spec=&type=&ch=03&k=&offset_page=0&offset_num=0&num="
                + pageSize + "&asc=&page=" + pageNo + "&r=" + r;
        HttpRequest request = HttpRequest.get(getUrl);

        js = request.body();

        // System.out.println(js);
        JsonObject jo = (JsonObject) new JsonParser().parse(js.replace("var jsonData = ", "").replace(";", ""));
        JsonElement list_jo = jo.get("list");
        List<String> urls = new ArrayList<String>();
        if (list_jo.isJsonArray()) {
            JsonArray listArray = list_jo.getAsJsonArray();
            for (int i = 0; i < listArray.size(); i++) {

                urls.add(listArray.get(i).getAsJsonObject().get("url").getAsString());
            }
        }
        System.out.println(urls.size());
        for (int i = 0; i < urls.size(); i++) {
            System.out.println(urls.get(i));
        }
    }
}
