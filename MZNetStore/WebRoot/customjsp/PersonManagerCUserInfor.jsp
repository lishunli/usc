<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>   
    <title>修改个人信息</title>
  </head> 
  <body bgcolor="#EEEEEE"><br><br><br>
    <form action="UserInforChangeAction.action" method="post">
    
    <table width="700" cellspacing="1" cellpadding="3" border="1" align="center" class="tableborder2" height="350"> 
    <tr> 
       <td valign="middle" height="25" align="center" colspan="3"><font color="blue"><b>修改个人信息</b></font><br></td> 
    </tr> 
    <tr>
        <td valign="middle"  align="center" width="25%">真实姓名:</td>
        <td valign=middle class=tablebody1 width="70%"><input name="realName" type="text"/> &nbsp;</td>
        <td></td>
    </tr>   
    <tr> 
       <td valign="middle"  align="center" >性 别:</td>
       <td width="6%" class="tablebody1">
       <select name="sex" id="sex">
       <option value="男">男</option>
       <option value="女">女</option>
       </select>
       </td> 
       
    </tr> 
       <td valign="middle"  align="center" >地 址:</td>
     
  <td valign=middle class=tablebody1><input name="address" type="text"  size="40"/> &nbsp;</td>
        
    <tr> 
       <td valign="middle"  align="center" >邮 编:</td>
        <td valign=middle class=tablebody1><input name="postCode" type="text"/> &nbsp;</td>
        <td></td>
    </tr> 
     <tr> 
       <td valign="middle"  align="center" >移动电话:</td>
        <td valign=middle class=tablebody1><input name="mobile" type="text"/> &nbsp;</td>
        <td></td>
    </tr> 
     <tr> 
       <td valign="middle"  align="center" >固定电话:</td>
        <td valign=middle class=tablebody1><input name="phone" type="text"/> &nbsp;</td>
        <td></td>
    </tr> 
    <tr>
       <td class=tablebody2 valign=middle  align=right colspan="1">
		<input type="submit" value="确  定" />&nbsp;&nbsp;&nbsp;<input type="submit" value="重 置" /></td>
    </tr> 
    </table>
    </form>
  </body>
</html>
