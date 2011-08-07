<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>All Users</title>
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
		<s:form action="get-all-user" method="post" theme="simple">
			<s:if test="userList.size">
				<table width="75%" align="center">
					<s:iterator value="userList" id="user" status="count">
						<s:if test="#count.index % 6 == 0">
							<tr>
						</s:if>

						<td width="800" height="120" style="width: 200px; word-break: break-all" align="center">
							<a href="http://www.blogjava.net/lishunli/" target="_blank">
								<img src="<%=basePath + "get-image-by-id.action?id="%><s:property value="#user.id"/>" width="100" height="100" alt="照片"
									title="<s:property value="#user.username" />" onerror="javascript:this.src='images/default.png'" /> 
							</a>
							<div STYLE="width: 200x; height: 20px; border: 1px; overflow: hidden; text-overflow: ellipsis">
								<s:property value="#user.username" />
							</div>
						</td>

						<s:if test="(#count.index + 1) % 6 == 0">
							</tr>
						</s:if>
					</s:iterator>
				</table>
			</s:if>




		</s:form>

	</body>
</html>
