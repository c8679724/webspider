package com.spider4j.spider.webspider.spider;

public class Site {

    /**
     * 
     * 添加用户.
     * 
     * @param username
     * @param password
     * @return void
     * @author 成天华
     * @date 2014年12月20日 下午9:09:22
     */
    public void addUsers(String username, String password) {

    }

    /**
     * 
     * 添加登录脚本.
     * 
     * @param script 脚本名称
     * @return void
     * @author 成天华
     * @date 2014年12月20日 下午9:09:04
     */
    public void addLoginScript(String script) {

    }

    /**
     * 
     * 添加动态登录脚本.<br>
     * 通过动态加载类的技术动态加载登录脚本.免除修改登录脚本的部署步骤.
     * 
     * @param script 脚本名称
     * @param javaClassCode Class 代码
     * @return void
     * @author 成天华
     * @date 2014年12月20日 下午9:09:04
     */
    public void addLoginScript(String script, String className, String javaClassCode) {

    }

    /**
     * 
     * 添加下载任务.
     * 
     * @return void
     * @author 成天华
     * @date 2014年12月20日 下午9:09:51
     */
    public void addUrls(String... urls) {

    }

    /**
     * 
     * 一个用户可以同时走多少线程.
     * 
     * @param threadNumber
     * @return void
     * @author 成天华
     * @date 2014年12月20日 下午9:13:57
     */
    public void setUserThreadNumber(int threadNumber) {

    }

    /**
     * 
     * 一个代理可以同时走多少线程.
     * 
     * @param threadNumber
     * @return void
     * @author 成天华
     * @date 2014年12月20日 下午9:14:39
     */
    public void setProxyThreadNumber(int threadNumber) {

    }
}
