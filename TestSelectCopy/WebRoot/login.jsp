<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
 
<html> 
	<head>
		<title><bean:message key="login.jsp.title"/></title>
	<html:javascript formName="loginForm"/>
	</head>
	<body>
		<html:form action="/login" onsubmit="return validateLoginForm(this);">			
			<bean:message key="login.jsp.username"/>: <html:text property="username"/><font color="#FF0000"><html:errors property="username"/><br/></font>
			<bean:message key="login.jsp.password"/>&nbsp; : <html:password property="password"/><font color="#FF0000"><html:errors property="password"/><br/></font><br/> 
			<html:submit><bean:message key="login.jsp.submit"/></html:submit>
			<html:reset><bean:message key="login.jsp.reset"/></html:reset>
		</html:form>
	</body>
</html>

