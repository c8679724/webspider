<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<title>爬虫任务</title>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">
	var getTaskUrl = "spider.jspl?method=getTask";
	var deliveryTaskUrl = "spider.jspl?method=deliveryTask";

	var urlTask_url = "";
	var urlTask_id = "";
	var urlTask_param = null;

	$.post(getTaskUrl, {}, function(data) {
		urlTask_url = data.url;
		$("#log").html($("#log").html() + "<br/>" + urlTask_url);
		$("#html").load(urlTask_url);
	});
</script>
</head>

<body>
	This is my JSP page.
	<br>
	<div id="log"></div>
	<div id="html"></div>
</body>
</html>
