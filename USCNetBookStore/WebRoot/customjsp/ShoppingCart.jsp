<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ include file="PersonManagerTop.jsp"%>
<html>
  <head>   
    <title>购物车</title>
  </head>  
  <body>
    
    <table align="center" width="70%" border="1">
    您已经选择的商品：<br>
    <tr>
    <td>商品名</td>
   <td>市场价</td>
    <td>促销价/会员价</td>
    <td>数量</td>
    </tr>
    <s:iterator value="#request.Shoppingcart" id="cart">
    <tr>
   <td> <s:property value="#cart.commodityName"/></td>
    <td> <s:property value="#cart.publishedPrice"/></td>
     <td> <s:property value="#cart.shoppingPrice"/></td>
     <td> <s:property value="#cart.quantity"/> </td>
    </tr>
    </s:iterator>
           
    </table>
  </body>
</html>
