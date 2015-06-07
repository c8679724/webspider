package com.spider4j.spider.web.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HtmlUtil {

    public static void main(String[] args) {
        // String rex =
        // "http://www\\.hit180\\.com/.+.html.*|[^http://www\\.hit180\\.com/.+[^.html].*]";
        String rex = "http://www\\.hit180\\.com/.+(\\.html).*";
        Set<String> urls = new HashSet<String>();
        urls.add("http://www.hit180.com/1231.html");
        urls.add("http://www.hit180.com/1231.pdf");
        urls.add("http://www.hit180.com/sadfa/1232.html");
        urls.add("http://www.hit180.com/dd/1231.pdf");
        urls.add("http://www.hit180.com/dd/1231.doc");
        urls.add("http://www.hit180.com/1231.html#dd");
        urls.add("http://www.hit180.com/1231/ds/ddsa/dd.doc");
        List<String> urls_ = new ArrayList<String>();
        urls_.addAll(urls);
        urls_ = regex(urls_, rex);
        System.out.println(">>>" + Application.gson.toJson(urls_));
    }

    public static List<String> links(Document html) {

        Elements elements = html.select("a[href]");
        String link;
        List<String> links = new ArrayList<String>();
        Set<String> links_ = new HashSet<String>();
        for (Element element2 : elements) {
            link = element2.attr("abs:href");
            links_.add(link);
        }
        links.addAll(links_);
        return links;
    }

    public static List<String> regex(List<String> urls_, String pattern) {

        List<String> urls = new ArrayList<String>();

        Pattern pat = Pattern.compile(pattern);
        Matcher mat = null;
        for (String url : urls_) {
            mat = pat.matcher(url);
            if (mat.matches()) {
                urls.add(url);
            }
        }
        return urls;
    }

    public static boolean regex(String url, String pattern) {

        boolean s = false;

        Pattern pat = Pattern.compile(pattern);
        Matcher mat = null;
        mat = pat.matcher(url);
        if (mat.matches()) {
            s = true;
        }
        return s;
    }

    public static boolean regex(String url, String[] patterns) {

        boolean s = false;
        for (int i = 0; i < patterns.length; i++) {
            Pattern pat = Pattern.compile(patterns[i]);
            Matcher mat = null;
            mat = pat.matcher(url);
            if (mat.matches()) {
                return true;
            }
        }
        return s;
    }
}
