<%@ page language="java" pageEncoding="GB18030"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
 
<html> 
	<head>
		<title>JSP for RegForm form</title>
	</head>
	<body>
		<html:form action="/reg">
			
			username : <html:text property="username"/><html:errors property="username"/><br/>
			password : <html:password property="password"/><html:errors property="password"/><br/>
			repassword : <html:password property="repassword"/><html:errors property="repassword"/><br/>
			<html:submit/><html:reset/>
		</html:form>
	</body>
</html>

