<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>添加新管理员</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>

	<body>
		<p align="right"><a href="indexBack.action">回到后台首页</a></p>
		
		<h1 align="center" style="color: blue">
			电子图书后台管理系统之信息发布系统
		</h1>
		
		
		<br>
		<s:form action="addManger.action" method="post" theme="simple">

			<table width="500" border="1" align="center">
				<tr>
					<td colspan="2">
						<div align="center">
							<h2>
								添加新管理员
							</h2>
						</div>
					</td>
				</tr>
				<tr>
					<td width="12%">
						管理员姓名
					</td>
					<td width="88%">
						<s:textfield name="operator.operatorName" id="operatorName" value="%{operator.operatorName}"></s:textfield>
						<font color="red">* <span id="operatorNameError"></span> <s:fielderror>
								<s:param>operator.operatorName</s:param>
							</s:fielderror>
						</font>
					</td>
				</tr>
				<tr>
					<td>
						默认密码
					</td>
					<td>
					<s:textfield name="operator.operatorPass" id="operatorPass" value="uscnet" readonly="true" size="6"></s:textfield>
					<span style="color:green">管理员可以进入后台修改密码</span>
					</td>
				</tr>
				<tr>
					<td>
						管理员性别
					</td>
					<td>
						<s:select name="operator.operatorSex" list="{'男','女'}" value="%{operator.operatorSex}"></s:select>
					</td>
				</tr>
				<tr>
					<td>
						管理员类型
					</td>
					<td>
						<s:select label="管理员类型" name="operator.operatorType" list="{'后台管理员','仓库管理员','配货管理员','订单管理员','客服管理员','系统管理员'}" value="%{operator.operatorType}"/>
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<s:submit value="添加" />
						<s:reset value="重置" />
					</td>
				</tr>
			</table>
		</s:form>

	</body>
</html>
