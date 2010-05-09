<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>后台</title>
		<script type="text/javascript">
function BackExit()
{

	if(confirm("你真的想退出吗？"))
	{
		return true;
	}
	else 
	{
		return false;
	}
}

</script>
	</head>
	<body>
		<h1 align="center"  style="color:blue">电子图书后台管理系统之信息发布系统</h1>
		欢迎您：<%=session.getAttribute("manger")%>&nbsp;&nbsp;
		<s:if test="%{#session.manger == 'admin'}"> 
			<a href="addManger.action">【添加新管理员】</a>&nbsp;&nbsp;
		</s:if>
		<a href="updatePass.action">【修改密码】</a>&nbsp;&nbsp;<a href="backExit.action" onclick="return BackExit()">【退出】</a>&nbsp;&nbsp;
		
		<br>
		<br>
		<a href="bookEntry.action">图书录入</a>
		<br>
		<br>
		<a href="backSerach.action">图书发布</a>
		<br>
		<br>
		<a href="backCommonSerach.action">普通图书操作</a>
		<br>
		<br>
		<a href="backSaleSerach.action">促销图书操作</a>
		<br>
		<br>
	</body>
</html>