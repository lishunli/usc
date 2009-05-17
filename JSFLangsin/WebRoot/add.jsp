<%@ page language="java" pageEncoding="gbk"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<base href="<%=basePath%>">

	<title>My JSF 'add.jsp' starting page</title>
	
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
	<f:view>
	<h:form>
	<h:panelGrid columns="3">
	
	<h:outputLabel value="请输入第一个数字"/>
	
	<h:inputText id="firstNumber" value="#{mybean.firstNumber}"/>
	<h:message for="firstNumber"/>
		
	<h:outputLabel value="请输入第二个数字"/>
	
	<h:inputText id="secondNumber" value="#{mybean.secondNumber}"/>
	<h:message for="secondNumber"/>
	</h:panelGrid>
	<h:commandButton value="加" action="#{mybean.add}"/>
	</h:form>
	</f:view>
</body>
</html>