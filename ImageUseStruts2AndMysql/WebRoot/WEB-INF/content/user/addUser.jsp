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

		<title>添加用户</title>
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
		<s:form action="add-user" method="post" theme="simple" enctype="multipart/form-data">
			UserName<s:textfield name="user.username"></s:textfield>
			<font color="red"> *<s:property value="fieldErrors['user.username'][0]" /> </font>
			<br>
			
			PassWord<s:password name="user.password"></s:password>
			<font color="red"> *<s:property value="fieldErrors['user.password'][0]" /> </font>
			<br>		
			
			Image<s:file name="image"></s:file>
			<br>
			<s:submit value="Submit" />
		</s:form>
	</body>
</html>
