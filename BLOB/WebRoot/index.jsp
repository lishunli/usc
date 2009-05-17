<%@ page language="java" pageEncoding="gbk" contentType="text/html; charset=gbk"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
 
<html> 
	<head>
		<title>JSP for IndexForm form</title>
	</head>
	<body>
		<html:form action="/index" enctype="multipart/form-data">
			panme : <html:text property="panme"/><html:errors property="panme"/><br/>
			photo : <html:file property="photo"/><html:errors property="photo"/><br/>
			<html:submit/><html:cancel/>
		</html:form>
	</body>
</html>

