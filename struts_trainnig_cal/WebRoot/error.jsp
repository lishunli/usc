<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ page import="com.bjsxt.struts.*" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>������Ϣ</title>
</head>
<body>
	<%
		CalActionForm caf = (CalActionForm)request.getAttribute("testForm");
	%>
	����ʧ�ܣ�<br>
	<%=caf.getValue1() %>
	<%=caf.getFlag() %>
	<%=caf.getValue2() %>
</body>
</html>