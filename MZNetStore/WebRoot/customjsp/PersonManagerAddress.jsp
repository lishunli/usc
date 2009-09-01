<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.usc.daos.Custom" %>
 <%Custom custom3 = (Custom)session.getAttribute("Custom");%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>   
    <title>地址薄</title>
  </head> 
  <body bgcolor="#EEEEEE"><br><br><br>
    <form action="PersonManagerAddress.action" method="post">
    
    <table width="700" cellspacing="1" cellpadding="3" border="1" align="center" class="tableborder2" height="250"> 
    <tr> 
       <td valign="middle" height="25" align="center" colspan="3"><font color="blue"><b>地址薄</b></font><br></td> 
    </tr> 
    <tr>
        <td valign="middle"  align="center" width="25%">收货人姓名:</td>
        <td valign=middle class=tablebody1 width="70%"><%out.print(custom3.getCustomName()); %>&nbsp;</td>
        <td></td>
    </tr>         
    <tr> 
       <td valign="middle"  align="center" >常用收货人地址:</td>
        <td valign=middle class=tablebody1><%out.print(custom3.getAddress()); %>&nbsp;</td>
        <td></td>
    </tr>   
    <tr> 
       <td valign="middle"  align="center" >付款方式:</td>
        <td valign=middle class=tablebody1>货到付款&nbsp;</td>
        <td></td>
    </tr>
      <tr> 
       <td valign="middle"  align="center" >手机号码:</td>
        <td valign=middle class=tablebody1><%out.print(custom3.getMobile()); %> &nbsp;</td>
        <td></td>
    </tr>
    
     <tr> 
       <td valign="middle"  align="center" >电话号码:</td>
        <td valign=middle class=tablebody1><%out.print(custom3.getPhone()); %> &nbsp;</td>
        <td></td>
    </tr>
    <tr>
       <td class=tablebody2 valign=middle  align=right colspan="1">
		<input type="submit" value="修 改" />&nbsp;&nbsp;&nbsp;<input type="reset" value="重 置" /></td>
    </tr> 
    </table>
    </form>
  </body>
</html>