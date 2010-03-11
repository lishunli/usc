<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ include file="../Top.jsp"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>数码</title>
	</head>
	<body>

		<s:form method="post" action="advancedDigitalSearch.action"
			theme="simple">
			<center><h2>数码高级搜索</h2></center>
			<table align="center">
				<tr>
					<td align="center">
						<s:label>数码名称：</s:label>
					</td>
					<td align="left">
						<s:textfield name="digitalName" />
					</td>
					<td align="right">
						<s:label></s:label>
					</td>
				</tr>
				<tr>
					<td align="center">
						<s:label>品牌：</s:label>
					</td>
					<td align="right">
						<s:textfield name="brand" />
					</td>
				</tr>
				<tr>
					<td>
						<s:submit value=" 查询"></s:submit>
					</td>
					<td>
						<s:submit value="重置"></s:submit>
					</td>
				</tr>

				</s:form>
	</body>
</html>
