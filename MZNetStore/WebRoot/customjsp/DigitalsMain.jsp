<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<s:include value="/Top.jsp"></s:include>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/" + "customjsp" + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>数码信息</title>

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
		<s:action name="init"></s:action>
		<s:if test="#request.digitalCommonInit">
			<table width="800" align="center">
				<tr>
					数码
				</tr>
				<tr>
					<s:iterator value="#request.digitalCommonInit"
						id="digitalCommonInit" status="count">
						<td width="800" height="120"
							style="width: 200px; word-break: break-all" align="center">
							<a
								href="info.action?type=2&entityID=<s:property value='#digitalCommonInit.digitalId'/>">
								<img
									src="<%=basePath
							+ "ShowImage.image?type=2&entityId="%><s:property value="#digitalCommonInit.digitalId"/>"
									width="100" height="100" alt="照片"
									title="<s:property value="#digitalCommonInit.digitalName" />"
									onerror="javascript:this.src='../images/custom/NoPhoto.jpg'" />
							</a>
							<DIV
								STYLE="width: 200x; height: 20px; border: 1px; overflow: hidden; text-overflow: ellipsis">
								<s:property value="#digitalCommonInit.digitalName" />
							</DIV>
							<p style="color: red">
								￥
								<s:property value="#digitalCommonInit.publishedPrice" />
							</p>
							<p>
								(市场价￥
								<s:property value="#digitalCommonInit.privilegePrice" />
								)
							</p>
						</td>
						<s:if test="#count.modulus(6)==0">
							<s:if test="#count.last">
				</tr>
				</s:if>
				<s:else>
					<tr>
				</s:else>
				</s:if>
				</s:iterator>

			</table>
		</s:if>
		<br>
		<br>

		<s:if test="#request.digitalSaleInit">
			<table width="800" align="center">
				<tr>
					数码促销
				</tr>
				<tr>
					<s:iterator value="#request.digitalSaleInit" id="digitalSaleInit"
						status="count">
						<td width="800" height="120"
							style="width: 200px; word-break: break-all" align="center">
							<a
								href="info.action?type=2&entityID=<s:property value='#digitalSaleInit.digitalId'/>">
								<img
									src="<%=basePath
							+ "ShowImage.image?type=2&entityId="%><s:property value="#digitalSaleInit.digitalId"/>"
									width="100" height="100" alt="照片"
									title="<s:property value="#digitalSaleInit.digitalName" />"
									onerror="javascript:this.src='../images/custom/NoPhoto.jpg'" />
							</a>
							<DIV
								STYLE="width: 200x; height: 20px; border: 1px; overflow: hidden; text-overflow: ellipsis">
								<s:property value="#digitalSaleInit.digitalName" />
							</DIV>
							<p style="color: red">
								促销价￥
								<s:property value="#digitalSaleInit.privilegePrice" />
							</p>
						</td>
						<s:if test="#count.modulus(6)==0">
							<s:if test="#count.last">
				</tr>
				</s:if>
				<s:else>
					<tr>
				</s:else>
				</s:if>
				</s:iterator>
			</table>
		</s:if>
	</body>
</html>
