<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
 
<html> 
	<head>
		<title>JSP for AddForm form</title>
	</head>
	<body>
		<html:form action="/add">
			uid : <html:text property="uid"/><html:errors property="uid"/><br/>
			upass : <html:text property="upass"/><html:errors property="upass"/><br/>
			uname : <html:text property="uname"/><html:errors property="uname"/><br/>
			<html:submit/><html:cancel/>
		</html:form>
	</body>
</html>

