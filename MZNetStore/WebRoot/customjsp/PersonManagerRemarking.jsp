<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>我要评论</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body bgcolor="#EEEEEE"> 
   <table width="533" border="1" height="51">
<tbody><tr>
<td width="6%" class="tablebody1">评论:${user.uCurrency}</td></tr>
</tbody></table><br> 
<br>&nbsp;<textarea cols="60" rows="10" name="textarea3"></textarea><br>&nbsp;
输入验证码：<input type="text" name="text3"><img border="0" src="../images/custom/.jpg">&nbsp;
              <a href="Remarking.action">看不清，换一张</a>
              <input type="button" value="发表评论" name="button8">&nbsp;
              <input type="button" value="取消" name="button8">&nbsp;
</body>
</html>
