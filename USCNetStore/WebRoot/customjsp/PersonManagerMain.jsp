<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.usc.daos.Custom" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ include file="PersonManagerTop.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>无标题文档</title>
<style type="text/css">
<!--
.STYLE8 {font-size: 18px}
.STYLE9 {
	font-size: 24px;
	font-weight: bold;
}
.STYLE10 {font-size: 24px}
.STYLE12 {font-size: 14px}
-->
</style>
</head>

<body>

<table width="75%" height="422" border="1" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <th width="157" height="10" bgcolor="#EEEEEE" scope="row"><div align="left">
        用户名:
        <% Custom custom1 = (Custom)session.getAttribute("Custom");
    out.print(custom1.getCustomName());%>

        </div>      <div align="left" class="STYLE12">
        <div align="left">          身 份：
        <%
        if(custom1.getVipFlag()==0)
        out.print("普通注册用户");
        else out.print("VIP用户");
         %>
        </div>
      </div>    <div align="left" class="STYLE12">
      <div align="left">        积分数：
      <%
        out.print(custom1.getBenefits());
         %>
      </div>
    </div>      
    <div align="left">U币余额：
      <%
        out.print(custom1.getUcurrency());
         %>
    </div></th>
    <td rowspan="8">
  
 <%
    String value = (String)request.getParameter("action");
    if("order".equals(value)){%>
    <%@ include file="PersonManagerOrder.jsp"%>
 <%} 
  else if("changeuser".equals(value)){%>
 <%@ include file="PersonManagerCUserInfor.jsp"%><%}
 else if("changepassword".equals(value)){%>
 <%@ include file="PersonManagerCPassword.jsp"%><%}
  else if("changeemail".equals(value)){%>
 <%@ include file="PersonManagerCEmail.jsp"%><%}
  else if("lookaddrss".equals(value)){%>
 <%@ include file="PersonManagerAddress.jsp"%><%}
  else if("uhistory".equals(value)){%>
 <%@ include file="PersonManagerUHistory.jsp"%><%}
  else if("swapu".equals(value)){%>
 <%@ include file="PersonManagerUTransfor.jsp"%><%}
  else if("bhistory".equals(value)){%>
 <%@ include file="PersonManagerBHistory.jsp"%><%}
  else if("bswapu".equals(value)){%>
 <%@ include file="PersonManagerBSwapU.jsp"%><%}
  else if("favorite".equals(value)){%>
 <%@ include file="PersonManagerFavorite.jsp"%><%}
  else if("remark".equals(value)){%>
 <%@ include file="PersonManagerRemark.jsp"%><%}
   else if("suggestion".equals(value)){%>
 <%@ include file="PersonManagerSuggestion.jsp"%>
 <%}%>
   </td>
  
    
    
    
    

  <tr bgcolor="#EEEEEE">
    <th height="28" bgcolor="#8AD286" scope="row"><div align="left">
      <p class="STYLE10"><a href="<%=path%>/customjsp/PersonManagerMain.jsp?action=order">我的订单历史</a>&nbsp;
        </p>
    <p>
      </div></th>
  </tr>
  <tr bgcolor="#EEEEEE">
    <th height="71" bgcolor="#8AD286" scope="row"><p align="left"><span class="STYLE10"><strong>修改个人信息</strong></span><hr color="#AACCFF"/>
      <div align="left"><br />
      <strong><a href="<%=path%>/customjsp/PersonManagerMain.jsp?action=changeuser">修改基本信息</a></strong> <br />
        <span class="STYLE8"><strong><a href="<%=path%>/customjsp/PersonManagerMain.jsp?action=changepassword">修改密码</a></strong> <br />
        <strong><a href="<%=path%>/customjsp/PersonManagerMain.jsp?action=changeemail">修改Email地址</a></strong> <br />
        <strong><a href="<%=path%>/customjsp/PersonManagerMain.jsp?action=lookaddrss">查看收货地址薄</a></strong></span>
        <p>    
      </div></th>
  </tr>  <tr bgcolor="#EEEEEE">
    <th height="64" bgcolor="#8AD286" scope="row"><p align="left"><span class="STYLE10"><strong>U</strong><strong>币管理</strong></span><hr color="#AACCFF"/>
      <div align="left"><br />
        <span class="STYLE8"><strong><a href="<%=path%>/customjsp/PersonManagerMain.jsp?action=uhistory">U币历史</a></strong> <br />
        <strong><a href="<%=path%>/customjsp/PersonManagerMain.jsp?action=swapu">转让U币</a></strong><strong> </strong></span>
        <p>    
      </div></th>
  </tr>
  <tr bgcolor="#EEEEEE">
    <th height="43" bgcolor="#8AD286" scope="row"><p align="left">
      <div align="left"><span class="STYLE9">积分管理 </span></div>
      <span class="STYLE9"><hr color="#AACCFF"/></span>
      <div align="left"><br />
        <span class="STYLE8"><strong><a href="<%=path%>/customjsp/PersonManagerMain.jsp?action=bhistory">积分历史</a></strong> <br />
              <strong><a href="<%=path%>/customjsp//PersonManagerMain.jsp?action=bswapu">积分换U币</a></strong> </span></div>
    <p></th>
  </tr>
  <tr bgcolor="#EEEEEE">
    <th height="24" bgcolor="#8AD286" scope="row"><p align="left" class="STYLE10"><strong><a href="<%=path%>/customjsp/PersonManagerMain.jsp?action=favorite">暂存架</a> </strong></p></th>
  </tr>
  <tr bgcolor="#EEEEEE">
    <th height="24" bgcolor="#8AD286" scope="row"><p align="left" class="STYLE10"><strong><a href="<%=path%>/customjsp/PersonManagerMain.jsp?action=remark">评论</a> </strong></p></th>
    </tr>
  
  <tr bgcolor="#EEEEEE">
    <th height="28" bgcolor="#8AD286" scope="row"><div align="left"><span class="STYLE10"><strong><a href="<%=path%>/customjsp//PersonManagerMain.jsp?action=suggestion">建议</a> </strong></span></div></th>
  </tr>
</table>
</body>
</html>
