<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
 
<html> 
	<head>
		<title>JSP for AddForm form</title>
	</head>
	<body>
		<html:form action="/add" method="post"> 
			uid : <html:text property="uid"/><html:errors property="uid"/><br/>
			uname : <html:text property="uname"/><html:errors property="uname"/><br/>
			upass : <html:password property="upass"/><html:errors property="upass"/><br/>
			
			<html:submit/><html:reset/>
		</html:form>
	</body>
</html>

