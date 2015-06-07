package com.spider4j.spider.web.util;

import java.net.InetAddress;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import com.google.gson.Gson;

/**
 * 单节点全局辅助对象(目前不能在集群中生效)
 * 
 * @author 踏雪无痕
 * 
 */
public class Application implements ApplicationContextAware {

	private static ThreadLocal<HttpServletRequest> requestLocal = new ThreadLocal<HttpServletRequest>();
	private static ThreadLocal<HttpServletResponse> responseLocal = new ThreadLocal<HttpServletResponse>();
	private static ThreadLocal<String> ip = new ThreadLocal<String>();
	//电信手机号码正则表达式
	public static final String  DIANXINPHONE="^1(3[3]|5[3]|8[09])\\d{8}";
	//手机号码正则表达式
	public static final String  PHONE="^[1][3-8]\\d{9}$";
	/**
	 * spring bean工厂(程序启动完成后自动设置，最好判断是否为空再使用，或者等待到bean工厂完成了再用)
	 */
	public static ApplicationContext applicationContext;

	/**
	 * 程序当前classes目录
	 */
	public static String classPath = ApplicationContextAware.class
			.getClassLoader().getResource(".").getPath();

	/**
	 * json 辅助对象
	 */
	public static Gson gson = new Gson();

	/**
	 * 当前服务器ip
	 */
	public static String server_ip;
	
	static {// 获取服务器ip
		try {
			InetAddress myIPaddress = InetAddress.getLocalHost();
			server_ip = myIPaddress.getHostAddress();

		} catch (Exception e) {
			e.printStackTrace();
			server_ip = "127.0.0.1";
		}
	}

	/**
	 * 获取当前线程用户的HttpServletRequest
	 * 
	 * @return
	 */
	public static HttpServletRequest getRequest() {
		return requestLocal.get();
	}

	/**
	 * 获取当前线程用户的HttpServletResponse对象(线程结束会清空数据)
	 * 
	 * @return
	 */
	public static HttpServletResponse getResponse() {
		return responseLocal.get();
	}

	/**
	 * 获取当前线程的用户的session(线程结束不会清空数据)
	 * 
	 * @return
	 */
	public static HttpSession getSession() {
		return (HttpSession) requestLocal.get()
				.getSession();
	}

	/**
	 * 获取当前线程的用户的ip
	 * 
	 * @return
	 */
	public static String getIp() {
		return ip.get();
	}

	public static void setIp(String ip_) {
		ip.set(ip_);
	}

	public static void setRequest(HttpServletRequest request) {
		requestLocal.set(request);
	}

	public static void setResponse(HttpServletResponse response) {
		responseLocal.set(response);
	}

	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		Application.applicationContext = applicationContext;
	}
	
	public static void main(String[] args) {
        //测试电信号码
	//    String check = "^([a-z0-9A-Z]+[-|.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?.)+[a-zA-Z]{2,}$";
	    String check = Application.PHONE;
        Pattern regex = Pattern.compile(check);
        Matcher matcher = regex.matcher("25500000000");
        if (matcher.matches()) {
            System.out.println("是");  
        }else{
            System.out.println("不是");  
        }
	    //测试手机号码
    }
}