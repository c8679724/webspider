package com.spider4j.spider.web.util;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 响应辅助类
 * 
 * @author 踏雪无痕
 * 
 */
public class ResponseUtil {

    // 记录日志
    private static Logger logger = LoggerFactory.getLogger(ResponseUtil.class);

    /**
     * 打印json到响应(如果不是json格式的数据一定不能用这个方法)
     * 
     * @param Json
     * @param response
     */
    public static void responseJson(String json) {

        try {
            HttpServletResponse response = Application.getResponse();
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.print(json);
            out.close();
        } catch (IOException ie) {
            logger.error("====异常:响应Json<ResponseUtil.responseJson(json,response)>====", ie);
        }
    }

    /**
     * 打印json到响应(如果不是json格式的数据一定不能用这个方法)
     * 
     * @param Json
     * @param response
     */
    public static void responseJson(Object jsonObject) {

        try {
            HttpServletResponse response = Application.getResponse();
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.print(Application.gson.toJson(jsonObject));
            out.close();
        } catch (IOException ie) {
            logger.error("====异常:响应Json<ResponseUtil.responseJson(json,response)>====", ie);
        }
    }

    /**
     * 打印json到响应(如果不是json格式的数据一定不能用这个方法)
     * 
     * @param Json
     * @param response
     */
    public static void responseJson(String json, HttpServletResponse response) {

        try {
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.print(json);
            out.close();
        } catch (IOException ie) {
            logger.error("====异常:响应Json<ResponseUtil.responseJson(json,response)>====", ie);
        }
    }

    /**
     * 打印字符串到响应
     * 
     * @param Json
     * @param response
     */
    public static void responseHtml(String json) {

        try {
            HttpServletResponse response = Application.getResponse();
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.print(json);
            out.close();
        } catch (IOException ie) {
            logger.error("====异常:响应ajaxHtml<ResponseUtil.responseHtml(html,response)>====", ie);
        }
    }

    /**
     * 打印字符串到响应
     * 
     * @param Json
     * @param response
     */
    public static void responseHtml(Object jsonObject) {

        try {
            HttpServletResponse response = Application.getResponse();
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.print(Application.gson.toJson(jsonObject));
            out.close();
        } catch (IOException ie) {
            logger.error("====异常:响应ajaxHtml<ResponseUtil.responseHtml(html,response)>====", ie);
        }
    }

    /**
     * 打印字符串到响应
     * 
     * @param Json
     * @param response
     */
    public static void responseHtml(String string, HttpServletResponse response) {
        try {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.print(string);
            out.close();
        } catch (IOException ie) {
            logger.error("====异常:响应ajaxHtml<ResponseUtil.responseHtml(html,response)>====", ie);
        }
    }

    /**
     * 打印字符串到响应
     * 
     * @param Json
     * @param response
     */
    public static void responseAppliction(String string, HttpServletResponse response) {
        try {
            response.setContentType("application/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.print(string);
            out.close();
        } catch (IOException ie) {
            logger.error("====异常:响应ajaxHtml<ResponseUtil.responseAppliction(html,response)>====", ie);
        }
    }

    public static String Redirect(String strMsg, int optype, String url) {

        HttpServletResponse response = Application.getResponse();

        try {
            response.setContentType("text/html; charset=UTF-8");
            // ServletOutputStream out = response.getOutputStream();
            PrintWriter out = response.getWriter();
            out.println("<script>");
            if (strMsg != null && strMsg.length() > 0) {
                out.println("window.alert(\"" + strMsg.replaceAll("\"", "\\\"").replaceAll("\n", "\\n") + "\");");
            }
            if ((optype & 8) == 8) {
                out.println("if(window.opener) { if(window.opener.document.forms.length>0) window.opener.document.forms[window.opener.document.forms.length-1].submit(); else window.opener.location.reload(); }");
            }
            // out.println("window.navigate('" + url + "');"); //firefox 不支持此跳转
            // 是1的时候父页面跳转本页面关闭，
            if (optype == 1) {
                out.println("window.opener.location.href = '" + url + "';");
                out.println("window.close();");
            } else {
                out.println("window.location.href = '" + url + "';");
            }

            out.println("</script>");
            out.close();
        } catch (IOException ex) {
            logger.error("重定向异常:", ex);
        }
        return null;
    }
}
