<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
  <head>
    <html:base />
    
    <title>dispatchInput.jsp</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <html:link action="ChangeLocale.htm?language=en&country=US&page=/DispatchInput.htm">english</html:link>
 <html:link action="ChangeLocale.htm?language=zh&country=CN&page=/DispatchInput.htm">chinese</html:link>
 
    <html:errors/>
    
    <html:form action="/UserManager" method="get">
    <html:hidden property="xxx" value="addUser"/>
    <html:submit property="submit" ><bean:message key="button.submit" /></html:submit>
   
    <input type="submit" name="submit" value="<bean:message key="button.submit" />" />
    </html:form>
  </body>
</html:html>
