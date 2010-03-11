<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>My Favorite</title>
  </head>
  
  <body bgcolor="#EEEEEE">
  <table width="650" border="1" height="57">
<tbody><tr>
<td align=center>我的暂存架</td>
</tr>
<tr>
<td colspan=5 align=left>排序方式：<select name="combobox1">
<option value="1">价格从高到低</option>
<option value="2">价格从低到高</option>
<option value="3">按时间先后</option>
</select>
</td>
</tr>
</tbody></table><br>
  
<table width="655" border="1" height="205">
<tbody>

<tr>
<td>商 品</td>
<td>放入时间</td>
<td>定 价</td>
<td>会员价</td>
<td>操 作</td></tr>

<tr>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td align=center><h:commandButton action="insertShoppingCart.action" rendered="true" value="购买"></h:commandButton>
    <h:commandButton action="insertShoppingCart.action" rendered="true" value="取消"></h:commandButton></td></tr>
<tr>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td align=center><h:commandButton action="insertShoppingCart.action" rendered="true" value="购买"></h:commandButton>
    <h:commandButton action="insertShoppingCart.action" rendered="true" value="取消"></h:commandButton></td></tr>
<tr>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td align=center><h:commandButton action="insertShoppingCart.action" rendered="true" value="购买"></h:commandButton>
    <h:commandButton action="insertShoppingCart.action" rendered="true" value="取消"></h:commandButton></td></tr>
</tbody></table><br>
<table width="140" border="1" height="29" align=center>
<tbody><tr>
<td><input type="button" value="首页" name="button4"></td>
<td><input type="button" value="下一页" name="button2"></td>
<td><input type="button" value="上一页" name="button3"></td>
<td><input type="button" value="尾页" name="button4"></td></tr>
</tbody></table>
  </body>
</html>
