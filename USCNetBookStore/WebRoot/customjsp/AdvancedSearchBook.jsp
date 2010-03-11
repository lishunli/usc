<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ include file="../Top.jsp"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <title>图书</title>
  </head>  
  <body>
   
    <s:form method="post" action="advancedBookSearch.action" theme="simple">
    <center><h2>图书高级搜索</h2></center>
   <table align="center">
   <tr >
     <td align="center"><s:label >书名：</s:label></td>
   <td align="left"><s:textfield name="bookName" /></td>
   <td align="right"><s:label ></s:label></td>
   </tr>
   <tr>
    <td align="center"><s:label >作者：</s:label></td>
   <td align="left"><s:textfield name="author" /></td>
   <td align="right"><s:label ></s:label></td>
   </tr>
   <tr>
   <td align="center"><s:label >ISBN</s:label></td>
   <td><s:password name="isbn"/></td> 
   <td align="right"><s:label ></s:label></td>
   </tr>
   <tr>
   <td align="center"><s:label >出版社：</s:label></td>
   <td><s:password name="publisher"/></td>
   <td align="right"><s:label ></s:label></td>
   </tr>
   <tr>
   <td><s:submit value=" 查询"></s:submit></td>
   <td><s:submit value="重置"></s:submit></td>
   </tr>
    
    </s:form>
  </body>
</html>
