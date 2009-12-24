<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>软件开发设计案例分析实验</title>
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
		<center>
			<br>
			<br>
			<h1>
				软件开发设计案例分析实验——文件数据导入导出
			</h1>
			<br>
			<br>
			<br>
			<a href="upload.jsp">Excel或DBF文件导入MySql数据库</a>

			<br>
			<br>
			<br>
			<a href="<s:url action='exportXLS'></s:url>">从MySql数据库导出为Excel格式文件</a>

			<br>
			<br>
			<br>
			<a href="<s:url action='exportDBF'></s:url>">从MySql数据库导出为DBF格式文件</a>

			<br>
			<br>
			<br>
			<br>
			<br>
			Copyright @ 2009-2010 章爱国. All Rights Reserved
		</center>


	</body>
</html>
