<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register2.jsp' starting page</title>
    
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
<!--使用标签s-->
   <s:actionerror cssStyle="color:red"/>
	<s:form action="register">
	<s:textfield name="username" label="用户名"></s:textfield>
	<s:password name="password" label="密码" > </s:password>
	<s:password name="repassword" label="确认密码" ></s:password>
	<s:textfield name="age" label="年龄"></s:textfield>
	<s:textfield name="birthday" label="出生日期"></s:textfield>
	<s:textfield name="graduation" label="毕业日期"></s:textfield>
	<s:submit value=" 确认 "></s:submit>
<!--	<s:reset value=" 重置 " ></s:reset>-->
	

	</s:form>

  </body>
</html>
