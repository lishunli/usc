<%@ page language="java" pageEncoding="GB18030"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
 
<html> 
	<head>
		<title>JSP for LoginForm form</title>
	</head>
	<body>
		<html:form action="/login">
			
			uname : <html:text property="uname"/><html:errors property="uname"/><br/>
			upass : <html:password property="upass"/><html:errors property="upass"/><br/>
			<html:submit/><html:cancel/>
		</html:form>
	</body>
</html>

