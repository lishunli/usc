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
	<li>jsp�ű�</li><br>
	������<%=form.getUsername() %><br>
	����:<%=form.getPassword() %><br>
	<p>
	<li>el���ʽ</li><br>
	������${blankFieldForm.username }<br>
	����:${blankFieldForm.password }<br>
</body>
</html>