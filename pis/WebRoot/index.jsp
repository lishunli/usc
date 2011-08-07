<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>http://www.blogjava.net/lishunli/</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	</head>

	<body>
		使用Struts2上传图片存取到Mysql中并读取出来显示在页面上
		<br>
		<a href="http://www.blogjava.net/lishunli/" target="_blank">欢迎光临我的博客，谢谢</a>
		<br>
		<br>
		1.上传图片
		<br>
		2.存取到Mysql中
		<br>
		3.从Mysql读取图片显示在页面
		<br><br>
		<a href="add-user.action">添加用户(使用Struts2上传图片存取到Mysql中)</a>
		&nbsp;&nbsp;
		<a href="get-all-user.action">所有用户(使用Struts2从Mysql中读取图片并显示在页面上)</a>

	</body>
</html>
