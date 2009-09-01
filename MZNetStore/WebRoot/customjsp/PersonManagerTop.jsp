<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.usc.daos.Custom" %>
<%String path=request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" " http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns=" http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text ml; charset=gb2312" />
<title>无标题文档</title>
<style type="text/css">
<!--
.STYLE3 {font-size: large}
.STYLE4 {font-size: x-large}
body {
	margin-top: 5mm;
	margin-bottom: 5mm;
}
.STYLE6 {font-size: 24px}
-->
</style>
</head>

<body>
<table width="75%" height="19%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <th colspan="2" bgcolor="#B9C8EC" scope="col" >
    <marquee direction=left>
      我的信息库
    </marquee></th>
     <td width="1" rowspan="2"></td>
  </tr>
  <tr>
    <th height="13" bgcolor="#B9C8EC" scope="col" ><div align="left">
     <% Custom custom = (Custom)session.getAttribute("Custom");
  out.print("欢迎您！"+custom.getCustomName());%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </div></th>
    <th bgcolor="#B9C8EC" scope="col" ><div align="left"></div></th>
  </tr>
  <tr>
    <td height="20" colspan="2"><div align="center">
      <h6><span class="STYLE6"> 我的信息库</span></h6>
    </div></td>
  </tr>
  <tr>
    <td width="542" height="13" bgcolor="#76946D">&nbsp;</td>
    <td bgcolor="#76946D">&nbsp;</td>
  </tr>
  <tr>
    <td width="542" bgcolor="#E7E7E7"><span class="STYLE4"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><a href="<%=path%>/customjsp/Main.jsp">首页</a>|<a href="<%=path%>/customjsp/BooksMain.jsp">图书</a>|<a href="<%=path%>/customjsp/DigitalsMain.jsp">数码</a></strong></span></td>
    <td width="445" bgcolor="#E7E7E7"><span class="STYLE3"><a href="ShoppingCartAction.action"> 购物车</a>&nbsp;<a href="<%=path%>/customjsp/NewPeoples.jsp">新手上路</a> &nbsp;<a href="<%=path%>/customjsp/Help.jsp">帮助中心</a></span></td>
  </tr>
</table>
<hr color="#0000FF" width="80%"/>
</body>
</html>
