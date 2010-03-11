<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>My JSP 'suggestion.jsp' starting page</title>
  </head>
  
  <body bgcolor="#EEEEEE">
     <table cellspacing=1 cellpadding=4 border="3" width="600" align=center class=tableBorder2 height="110" >
         <tr><td valign=middle  align=center height=25 background="WebRoot/images/bg2.gif" ><font color="blue"><b>建 议</b></font></td>
         </tr>
         <tr>
         <td name="mark" type="text" value=" ">尊敬的客户：您好！
            为了您更好地购物，如果您对我们公司有什么建议或意见，请您在下面填写您的建议或意见的内容并提交，我们会及时妥善处理。
            如果您的建议或意见被采纳，我们会衷心地感谢您提的建议或意见并赠送相应的积分。非常谢谢您的参与！
            </td> </tr>
     </table>
     <form action="PersonManagerSuggestionAction.action" method="post">
     <table cellspacing=1 cellpadding=4 border="3" width="600" align=center class=tableBorder2 height="210" >
        <tr><td valign=left align=center><textarea cols="70" rows="10" name="suggestionContents"></textarea>&nbsp;</td> </tr>
        <tr>
			<td class=tablebody2 valign=middle  align=right>
			<input type="submit" value="提 交" /><input type="submit" value="重 置" /></td>
		</tr>
     </table>
   
     
     </form>
   
  </body>
</html>
