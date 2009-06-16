<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>测试ActionForm</title>
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
  	<h1>测试ActionForm</h1>
  	<hr>
  	<li>测试动态ActionForm</li><br>
  	<form action="dyanactionform.do" method="post">
  		姓名：<input type="text" name="username"><br>
  	 	年龄：<input type="text" name="age"><br>
  	 	<input type="submit" value="提交">	
  	</form>  
  	<p>
  	<li>测试struts上传文件</li><br>
  	<form action="upload.do" method="post" enctype="multipart/form-data">
  		标题：<input type="text" name="title"><br>
  		文件：<input type="file" name="myfile"><br>
  		<input type="submit" value="提交">
  	</form>
  	<p>
  	<li>空字段测试</li><br>
  	<form action="blankfield.do" method="post">
  		姓名：<input type="text" name="username"><br>
  		<input type="submit" value="提交">
  	</form>
   	<p>
   	<li>测试ActionForm类型转换器</li><br>
   	<form action="typeconvert.do" method="post">
   		intValue:<input type="text" name="intValue"><br>
   		doubleValue:<input type="text" name="doubleValue"><br>
   		booleanValue:<input type="text" name="booleanValue"><br>
   		java.sql.Date:<input type="text" name="sqlDate"><br>
   		java.util.Date:<input type="text" name="utilDate"><br>
   		<input type="submit" value="提交">
   	</form>
  </body>
</html>
