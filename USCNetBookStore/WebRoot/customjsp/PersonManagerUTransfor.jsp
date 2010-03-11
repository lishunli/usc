<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<% Custom custom4 = (Custom)session.getAttribute("Custom");%>
<%@ page import="com.usc.daos.Custom" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>   
    <title>U币转换</title>
  </head> 
  <body bgcolor="#EEEEEE"><br><br><br>
    <form action="UTransforAction.action" method="post">
    
    <table width="700" cellspacing="1" cellpadding="3" border="1" align="center" class="tableborder2" height="250"> 
    <tr> 
       <td valign="middle" height="25" align="center" colspan="3"><font color="blue"><b>U币转换</b></font><br></td> 
    </tr> 
    <tr>
        <td valign="middle"  align="center" width="25%">您当前的U币总额:</td>
        <td valign=middle class=tablebody1 width="70%"><%out.print(custom4.getUcurrency()); %> &nbsp;</td>
        <td></td>
    </tr>         
    <tr> 
       <td valign="middle"  align="center" >转入的帐户（用户名）：</td>
        <td valign=middle class=tablebody1><input name="Customname" type="text"/> &nbsp;</td>
        <td></td>
    </tr>   <tr> 
       <td valign="middle"  align="center" >转入的金额数:</td>
        <td valign=middle class=tablebody1><input name="Unumber" type="text"/> &nbsp;</td>
        <td></td>
    </tr>
    <tr>
       <td class=tablebody2 valign=middle  align=right colspan="1">
		<input type="submit" value="转 入" />&nbsp;&nbsp;&nbsp;<input type="reset" value="重 置" /></td>
    </tr> 
    </table>
    </form>
  </body>
</html>