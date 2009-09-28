<%@ page language="java" pageEncoding="GB18030"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
 
<html> 
	<head>
		<title>JSP for RegForm form</title>
	</head>
	<body>
		<html:form action="/reg">
			password : <html:password property="password"/><html:errors property="password"/><br/>
			username : <html:text property="username"/><html:errors property="username"/><br/>
			<html:submit/><html:cancel/>
		</html:form>
	</body>
</html>

