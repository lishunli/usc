<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>login</title>
    
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
   <s:form action="login">
<!--页面的动态调用第三种使用通配符s:form action="logLogin"，第二种，页面 s:form action="login!log.action -->
   <!--页面的动态调用，如果在struts.xml里使用methods(原)-->
	<s:textfield name="username" label="用户名"></s:textfield>
	<s:password name ="password" label="密码"></s:password>
	<s:submit name="submit" label="提交"></s:submit>
	</s:form>
  </body>
</html>
