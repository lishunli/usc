<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register2.jsp' starting page</title>
    
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
<!--ʹ�ñ�ǩs-->
   <s:actionerror cssStyle="color:red"/>
	<s:form action="register">
	<s:textfield name="username" label="�û���"></s:textfield>
	<s:password name="password" label="����" > </s:password>
	<s:password name="repassword" label="ȷ������" ></s:password>
	<s:textfield name="age" label="����"></s:textfield>
	<s:textfield name="birthday" label="��������"></s:textfield>
	<s:textfield name="graduation" label="��ҵ����"></s:textfield>
	<s:submit value=" ȷ�� "></s:submit>
<!--	<s:reset value=" ���� " ></s:reset>-->
	

	</s:form>

  </body>
</html>
