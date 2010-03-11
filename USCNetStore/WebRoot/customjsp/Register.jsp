<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
   <center>
   <h1>注册</h1>
   <hr color="#3254DD" width="80%">
   <s:form action="RegisterAction" method="post" theme="simple">
   <table>
   <tr >
     <td align="center"><s:label >用户名：</s:label></td>
   <td align="left"><s:textfield name="custom.customName" id="customName"/></td>
   <td align="right"><s:label >*</s:label></td>
   </tr>
   <tr>
    <td align="center"><s:label >真实姓名：</s:label></td>
   <td align="left"><s:textfield name="custom.realName" id="realName"/></td>
   <td align="right"><s:label >*</s:label></td>
   </tr>
   <tr>
   <td align="center"><s:label >密码：</s:label></td>
   <td><s:password name="custom.customPass"/></td> 
   <td align="right"><s:label >*</s:label></td>
   </tr>
   <tr>
   <td align="center"><s:label >重复密码：</s:label></td>
   <td><s:password name="recustomPass"/></td>
   <td align="right"><s:label >*</s:label></td>
   </tr>
   <tr>
   <td align="center"><s:label >Email：</s:label></td>
   <td><s:textfield name="custom.email" /></td>
    <td align="right"><s:label >*</s:label></td>
   </tr>
   <tr>  
     <td align="center"><s:label >性别：</s:label></td>   
  <td><s:radio name="custom.sex" list="#{'男':'男','女':'女'}" value="'男'"> </s:radio> </td>
 <td align="right"><s:label >*</s:label></td>
   </tr>
    
   <tr>
   <td align="center"><s:label >地址：</s:label></td>  
   <td><s:textfield  name="custom.address" /></td>
   <td align="right"><s:label >*</s:label></td>
   </tr>
     <tr>
     <td align="center"><s:label >邮编：</s:label></td>  
   <td><s:textfield name="custom.postCode" /></td>
   <td align="right"><s:label >*</s:label></td>
   </tr>
     <tr>
     <td align="center"><s:label >移动电话：</s:label></td> 
   <td><s:textfield name="custom.mobile" /></td>
     <td align="right"><s:label >*</s:label></td>
   </tr>
     <tr>
     <td align="center"><s:label >固定电话：</s:label></td>
   <td><s:textfield name="custom.phone" /></td>
   </tr>
   <tr>
 <br>
 
   <td align="center"><s:label >验证码：</s:label></td>
     <td><s:textfield ></s:textfield>
   </td>
   </tr>  
   <tr>
   <td><s:submit value="注册"/></td>
   <td><s:reset value="重置"/></td>  
   </tr>
   </table>
   </s:form>
   </center>
  </body>
</html>
