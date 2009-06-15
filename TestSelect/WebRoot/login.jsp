<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
 
<html> 
	<head>
		<title>JSP for LoginForm form</title>
	</head>
	<body>
		<html:form action="/login">			
			username : <html:text property="username"/><font color="#FF0000"><html:errors property="username"/><br/></font>

			password : <html:password property="password"/><font color="#FF0000"><html:errors property="username"/><br/></font><br/>
			<html:submit/><html:reset/>
		</html:form>
	</body>
</html>

