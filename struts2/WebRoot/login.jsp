<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
<form action="login.action" method="post" name="form1">
  用户名：
  <label>
  <input type="text" name="username" id="username">
  </label>
  <p>密&nbsp; 码： 
    <label>
    <input type="password" name="password" id="password">
    </label>
  </p>
  <p>
    <label></label>
    <label></label> 
                
           
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;  
 <label>
 <input type="submit" name="button" id="button" value="提交">
&nbsp;&nbsp;&nbsp;&nbsp; </label>
 <label>
 <input type="reset" name="button2" id="button2" value="重置">
 </label>
  </p>
</form>
    

  </body>
</html>
