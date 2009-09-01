<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.usc.daos.Custom" %>
 <% Custom custom4 = (Custom)session.getAttribute("Custom");%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>   
    <title>积分换U币</title>
  </head>
  
  <body bgcolor="#EEEEEE">
  <table cellspacing=1 cellpadding=3 align=center class=tableBorder2>
		<tr>
		<td height=25 valign=middle>
                  <a href=index.jsp>积分管理</a> → 积分换U币
                </td>
                </tr>
		</table>
              <br>
               <table cellspacing=1 cellpadding=3 align=center class=tableBorder2>
		<tr><td height=25 valign=middle>
              欢迎参与积分回馈活动：
                </td></tr>
        <tr>
		<td height=25 valign=middle>
              1. XXXXXXXXXXXXXXdggggsadgsasdggdsdgdsdgsdgdggd
                </td></tr>
        <tr>
        <td height=25 valign=middle>
              2. XXXXXXXXXXXXXXsdgghgdsgsdgsafsfsdf
                </td></tr>
        <tr>
        <td height=25 valign=middle>
             3. XXXXXXXXXXXXXXfffffffffffffffffffffff
                </td></tr> 
        <tr>
        <td height=25 valign=middle>
             4. XXXXXXXXXXXXXXdddddddddddddddddddddddddddd
                </td></tr> 
        <tr>
        <td height=25 valign=middle>
              5. 积分转换U币的比率为10%，即100积分可以换取U币10
                </td></tr>
		</table><br>
		
		
		
      		  <form action="PersonManagerBSwapUAction.action" method="post">
              <table cellpadding=3 cellspacing=1 align=center class=tableborder1 border="1">
		<tr>
			<td valign=middle colspan=2 align=center height=25 background="WebRoot/images/bg2.gif" ><font color="blue"><b>积分兑换</b></font></td>
		</tr>
		<tr>
		<td valign=middle class=tablebody1>您的当前积分：</td>
		<td>	<%out.print(custom4.getBenefits()); %></td>
		</tr>

		<tr>
			<td valign=middle class=tablebody1>请输入您要兑换的积分数：</td>
			<td valign=middle class=tablebody1>
			<input name="number" type="text" valve="20"/> &nbsp; </td>
		</tr>
		<tr>
			<td class=tablebody2 valign=middle colspan=2 align=center>
			<input type="submit" value="兑 换" /></td>

		</tr>
		</table>
      </form>
  </body>
</html>
