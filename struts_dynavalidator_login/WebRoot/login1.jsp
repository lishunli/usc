<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>登录(validator框架服务器端验证)</title>
</head>
<body>
<h1>登录(validator框架服务器端验证)</h1>
<hr>
 <html:form action="login1.do">
   username : <html:text property="username"/><html:errors property="username"/><br/>
   password : <html:password property="password"/><html:errors property="password"/><br/>
   <html:submit/>
  </html:form>
</body>
</html>