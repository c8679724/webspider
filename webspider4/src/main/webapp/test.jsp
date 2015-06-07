<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<title>测试页面</title>
</head>
<%
    String ipp = request.getLocalAddr();
    String customerId = request.getRemoteAddr();
    String port = request.getLocalPort() + "";
    
%>
<body>
	<br />
	<br />
	<B>系统测试监控结果</B>
	<br> 服务器端IP地址:<%=ipp%>&nbsp;&nbsp;端口：<%=port%><br /> 客户端所在外网IP：<%=customerId%><br />
	<br />test session(testparam)---${sessionScope.testparam}<%=request.getSession().getId() %>>
</body>
</html>