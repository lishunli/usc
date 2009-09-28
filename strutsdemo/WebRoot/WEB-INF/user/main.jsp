<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title><bean:message key="info.title" bundle="xxx"/></title>
    
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
    ${userForm.user.username }:${userForm.autoLogon }:${userForm.user.gender.title}
 <hr>
    ${userForm.user.resume }
 <hr>
    <c:forEach items="${userForm.user.specialities}" var="speciality">
    	${speciality}:
    </c:forEach>
    
    <hr>
    <c:forEach items="${applicationScope}" var="oneAttr">
    	${oneAttr.key }----->${oneAttr.value  }<br>
    </c:forEach>
  </body>
</html>
