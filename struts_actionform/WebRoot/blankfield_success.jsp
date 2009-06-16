<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ page import="com.bjsxt.struts.*" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
	<%
		BlankFieldActionForm form = (BlankFieldActionForm)request.getAttribute("blankFieldForm");
	 %>
	<li>jsp脚本</li><br>
	姓名：<%=form.getUsername() %><br>
	密码:<%=form.getPassword() %><br>
	<p>
	<li>el表达式</li><br>
	姓名：${blankFieldForm.username }<br>
	密码:${blankFieldForm.password }<br>
</body>
</html>