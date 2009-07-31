<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

		<title>My JSP 'index.jsp' starting page</title>
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
			<font size="20" color="red"> <a href="windows.html">浮动窗口</a> <br>
				<br> <a href="menu.html">可收缩展开的级联菜单</a> <br> <br> <a
				href="editTable.html">可编辑的表格</a> <br> <br> <a
				href="stock.html">动态股票信息</a> <br> <br> <a
				href="autocomplete.html">自动补全</a> <br> <br>
			</font>

		</center>
	</body>
</html>
