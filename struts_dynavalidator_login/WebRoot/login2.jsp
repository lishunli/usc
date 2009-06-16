<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>登录(validator框架客户端验证)</title>
</head>
<body>
<h1>登录(validator框架客户端验证(javascript))</h1>
<hr>
<html:javascript formName="loginForm"/>
 <html:form action="login2.do" onsubmit="return validateLoginForm(this)">
  	  username : <html:text property="username"/><br/>
 	  password : <html:password property="password"/><br>
   <html:submit/>
  </html:form>
</body>
</html>