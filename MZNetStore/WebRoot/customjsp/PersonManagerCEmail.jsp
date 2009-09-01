<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.usc.daos.Custom" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>   
    <title>修改邮编</title>
  </head> 
  <body bgcolor="#EEEEEE"><br><br><br>
   <% Custom custom2 = (Custom)session.getAttribute("Custom");%>
    <form action="PersonManagerCEmailAction.action" method="post">
    
    <table width="700" cellspacing="1" cellpadding="3" border="1" align="center" class="tableborder2" height="200"> 
    <tr> 
       <td valign="middle" height="25" align="center" colspan="3"><font color="blue"><b>修改Email</b></font><br></td> 
    </tr> 
    <tr>
        <td valign="middle"  align="center" width="25%">原来Email:</td>
        <td valign=middle class=tablebody1 width="70%"> <%out.print(custom2.getEmail());%> &nbsp;</td>
        <td></td>
    </tr>         
    <tr> 
       <td valign="middle"  align="center" >新Email:</td>
        <td valign=middle class=tablebody1><input name="newEmail" type="text"/> &nbsp;</td>
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