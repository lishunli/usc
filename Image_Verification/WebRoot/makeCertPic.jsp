<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page contentType="image/jpeg" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
<jsp:useBean id="image" scope="page" class="com.usc.image.makeCertPic" />
　　<%
 	 String str=image.getCertPic(0,0,response.getOutputStream());
  // 将认证码存入SESSION
 	session.setAttribute("certCode", str); 
	%>
</body>
</html>

