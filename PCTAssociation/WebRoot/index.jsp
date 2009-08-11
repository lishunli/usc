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

		<title>省市县关联</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<!--		链接外部的js文件-->
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/country.js"></script>
	</head>

	<body>
		省市县关联 <br>
<table>
    <tr>
    <td>省/直辖市:<select id="province" onchange="getCountrys(1)">]
<%--	<option value="1">M</option>--%>
<%--	<option value="2">F</option>--%>
	</select></td>
    <td>直辖市/市:<select id="city" onchange="getCountrys(2)"></select></td>
	<td>区/县：<select id="town"></select></td>
    </tr>
    </table>

	

	</body>
</html>
