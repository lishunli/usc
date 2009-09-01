<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<h1>欢迎您：<%=session.getAttribute("manger") %></h1><br><br><br>
<a href="backExit.action" onclick ="return BackExit()">退出</a><br><br>
<a href="updatePass.action">修改密码</a><br><br>
<a href="bookEntry.action">图书录入</a><br><br>
<a href="digitalEntry.action">数码录入</a><br><br>
<a href="backSerach.action">产品发布</a><br><br>
<a href="backCommonSerach.action">普通商品操作</a><br><br>
<a href="backSaleSerach.action">促销商品操作</a><br><br>
</body>
</html>