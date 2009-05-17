<%@ page language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
 <%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic"%>
<html> 
	<head>
		<title>JSP for LoginForm form</title>
	</head>
	<body>
		<html:form action="/login">
			NAME:<html:text property="map(name)"></html:text>
			AGE:<html:text property="map(age)"></html:text>
			sex:<html:text property="map(sex)"></html:text>
			<html:submit/><html:cancel/>
		</html:form>
		</body>
</html>

