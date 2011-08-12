<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>零件检测系统</title>
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
		<s:form action="init" method="post" theme="simple">

		产品型号：<s:textfield name="model"></s:textfield>
			<font color="red"> *<s:property value="fieldErrors['model'][0]" /> </font>
			<br>
		产品数量：<s:textfield name="amount"></s:textfield>
			<font color="red"> *<s:property value="fieldErrors['amount'][0]" /> </font>
			<br>

			<s:submit value="Submit" />
			<s:reset value="Reset"></s:reset>
		</s:form>
	</body>


	<a href="draws/%E5%9B%BE1.pdf" target="_blank" >图纸一</a>
</html>
