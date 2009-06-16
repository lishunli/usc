<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>用户登录</title>
</head>
<body>
	<h1>用户登录(采用struts标签)</h1>
	<hr>
	<html:form action="login2.do" method="post">
		用户：<html:text property="username"/><br>
		密码：<html:password property="password"/><br>
		<html:submit value="登录"/>
	</html:form>
</body>
</html>