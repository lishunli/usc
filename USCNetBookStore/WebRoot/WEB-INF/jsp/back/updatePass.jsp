<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>修改密码</title>
	</head>
	<body>
		<h1 align="center" style="color: blue">
			<img alt="usc" src="images/custom/Log.jpg" width="995" height="131" align="top">
			<br>
			电子图书后台管理系统之信息发布系统——修改密码
		</h1>
		<p align="right">
			<a href="indexBack.action">回到后台首页</a>
		</p>

		<s:form action="updatePass" method="post" theme="simple">
姓名：<s:property value="#session.manger.operatorName" />
			<br>
原密码： <s:password name="operator.operatorPass"></s:password>

			<font color="red">* <span id="operatorPassError"></span> <s:fielderror>
					<s:param>operator.operatorPass</s:param>
				</s:fielderror> </font>
			<br>
新密码：<s:password name="newPass"></s:password>

			<font color="red">* <span id="newPassError"></span> <s:fielderror>
					<s:param>newPass</s:param>
				</s:fielderror> </font>
			<br>
重复新密码：<s:password name="reNewPass"></s:password>

			<font color="red">* <span id="reNewPassError"></span> <s:fielderror>
					<s:param>reNewPass</s:param>
				</s:fielderror> </font>
			<br>
			<s:submit value="修改"></s:submit>
			<s:reset value="重置"></s:reset>
			<br>
		</s:form>
	</body>
	
	
	<div
		style="background: #ededed; height: 31px; width: 100%; position: fixed; left: auto; right: auto; bottom: 0; _position: absolute; _top: e xpression(document.documentElement.clientHeight +     document.documentElement.scrollTop -     this.offsetHeight); text-align: center;">
		Powered by: 南华大学计算机科学与技术学院 指导老师：谢卫星 Copyright ©2010
		<a href="http://www.blogjava.net/lishunli/" target="_blank">李顺利</a>
	</div>
</html>