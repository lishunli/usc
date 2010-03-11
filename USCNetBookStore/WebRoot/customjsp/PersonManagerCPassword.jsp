<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

  <head>
    <title>�޸�����</title>

  </head>
  
  <body bgcolor="#EEEEEE">

  <head>   
    <title>修改密码</title>
  </head> 
  <body bgcolor="#EEEEEE"><br><br><br>
    <form action="PersonManagerCPasswordAction.action" method="post">
    
    <table width="700" cellspacing="1" cellpadding="3" border="1" align="center" class="tableborder2" height="250"> 
    <tr> 
       <td valign="middle" height="25" align="center" colspan="3"><font color="blue"><b>修改密码</b></font><br></td> 
    </tr> 
    <tr>
        <td valign="middle"  align="center" width="25%">原来密码:</td>
        <td valign=middle class=tablebody1 width="70%"><input name="oldPassword" type="password"/> &nbsp;</td>
        <td></td>
    </tr>         
    <tr> 
       <td valign="middle"  align="center" >新密码:</td>
        <td valign=middle class=tablebody1><input name="newPassword" type="password"/> &nbsp;</td>
        <td></td>
    </tr>   <tr> 
       <td valign="middle"  align="center" >确认密码:</td>
        <td valign=middle class=tablebody1><input name="newPasswordOk" type="password"/> &nbsp;</td>
        <td></td>
    </tr>
    <tr>
       <td class=tablebody2 valign=middle  align=right colspan="1">
		<input type="submit" value="修 改" />&nbsp;&nbsp;&nbsp;<input type="reset" value="重 置" /></td>
    </tr> 
    </table>

  </body>
</html>