<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>login</title>
    
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
   <s:form action="login">
<!--ҳ��Ķ�̬���õ�����ʹ��ͨ���s:form action="logLogin"���ڶ��֣�ҳ�� s:form action="login!log.action -->
   <!--ҳ��Ķ�̬���ã������struts.xml��ʹ��methods(ԭ)-->
	<s:textfield name="username" label="�û���"></s:textfield>
	<s:password name ="password" label="����"></s:password>
	<s:submit name="submit" label="�ύ"></s:submit>
	</s:form>
  </body>
</html>
