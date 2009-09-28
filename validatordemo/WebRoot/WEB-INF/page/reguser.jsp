<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
 
<html> 
	<head>
		<title>JSP for UserForm form</title>
		<%-- 
		<html:javascript formName="/RegUser" />
		--%>
	</head>
	<body>
		<%-- 
		<html:form action="/RegUser" onsubmit="return validateUserForm(this)">
		--%>
		<html:form action="/RegUser">	
			
			name : <html:text property="name"/><html:errors property="name"  header="" footer="" prefix="" suffix=""/><br/>
			password : <html:password property="password"/><html:errors property="password"  header="" footer="" prefix="" suffix=""/><br/>
			password2 : <html:password property="password2"/><html:errors property="password2"  header="" footer="" prefix="" suffix=""/><br/>
			email : <html:text property="email"/><html:errors property="email"  header="" footer="" prefix="" suffix=""/><br/>
		birthday : <html:text property="birthday"/><html:errors property="birthday"  header="" footer="" prefix="" suffix=""/><br/>
		idcard : <html:text property="idcard"/><html:errors property="idcard"  header="" footer="" prefix="" suffix=""/><br/>

			<html:submit/><html:cancel/>
		</html:form>
	</body>
</html>

