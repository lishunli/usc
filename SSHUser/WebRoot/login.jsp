<%@ page language="java" pageEncoding="GB18030"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
 
<html> 
	<head>
		<title>JSP for LoginForm form</title>
	</head>
	<body>
		<html:form action="/login">
			
			username : <html:text property="username"/><html:errors property="username"/><br/>
			password : <html:password property="password"/><html:errors property="password"/><br/>
			<html:submit/><html:reset/>
		</html:form>
	</body>
</html>

