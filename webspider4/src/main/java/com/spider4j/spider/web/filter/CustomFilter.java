package com.spider4j.spider.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.support.WebApplicationContextUtils;
import com.spider4j.spider.web.util.Application;

public class CustomFilter implements Filter {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {

        HttpServletRequest hreq = (HttpServletRequest) request;
        HttpServletResponse hres = (HttpServletResponse) response;
        Application.setRequest(hreq);
        Application.setResponse(hres);
        String ip = hreq.getHeader("MyClientIP") == null ? "127.0.0.1" : hreq.getHeader("MyClientIP");
        hreq.setAttribute("ip1", hreq.getLocalAddr() == null ? "" : hreq.getLocalAddr());
        hreq.setAttribute("ip2", ip);
        hreq.setAttribute("port", "" + hreq.getLocalPort());
        hreq.setAttribute("ip3", hreq.getRemoteAddr());
        Application.setIp(ip);

        String url = hreq.getRequestURI();

        logger.debug("当前用户ip:{}", hreq.getHeader("MyClientIP"));
        logger.debug("当前请求的url：{}", url);
        chain.doFilter(request, response);
    }

    public void init(FilterConfig filterConfig) throws ServletException {

        Application.applicationContext = WebApplicationContextUtils.getWebApplicationContext(filterConfig.getServletContext());
    }

    public void destroy() {

    }
}
