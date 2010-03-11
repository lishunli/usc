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

		<title>My JSP 'DigitalInfo.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">

function shop(entityID,productTypeID) {
	window.self.location = "ShoppingcartInsertAction.action?entityID=" + entityID+ "&productTypeID=" + productTypeID;
}
function favorite(entityID,productTypeID) {
	window.self.location = "FavoriteInsertGoodAction.action?entityID=" + entityID+ "&productTypeID=" + productTypeID;
}
</script>
	</head>

	<body>
		<s:if test="#request.digitalCommonInit">
			<s:iterator value="#request.digitalCommonInit" id="digitalCommonInit">
				<table width="900" border="0" align="center">
					<tr>
						<td width="200" style="width: 210px; word-break: break-all"
							rowspan="7">
							<img
								src="<%=basePath
							+ "ShowImage.image?type=2&entityId="%><s:property value="#digitalCommonInit.digitalId"/>"
								width="200" height="200" alt="照片"
								title="<s:property value="#digitalCommonInit.digitalName" />"
								onerror="javascript:this.src='../images/custom/NoPhoto.jpg'" />

						</td>
					</tr>
					<tr>
						<td width="700">
							数码名称：
							<s:property value="#digitalCommonInit.digitalName" />
						</td>
					</tr>
					<tr>
						<td>
							条形码：
							<s:property value="#digitalCommonInit.barcode" />
						</td>
					</tr>
					<tr>
						<td>
							厂家：
							<s:property value="#digitalCommonInit.manufacturer" />
						</td>
					</tr>
					<tr>
						<td>
							品牌：
							<s:property value="#digitalCommonInit.brand" />
						</td>
					</tr>
					<tr>
						<td>
							型号：
							<s:property value="#digitalCommonInit.modelNumber" />
						</td>
					</tr>

					<tr>
						<td>
							会员价：￥
							<span style="color: red"><s:property
									value="#digitalCommonInit.privilegePrice" /> </span>&nbsp;&nbsp;
							市场价：￥
							<s:property value="#digitalCommonInit.publishedPrice" />
							&nbsp;&nbsp;
							<input type="submit" value="   购买   " onclick="shop(<s:property value="#digitalCommonInit.digitalId"/>,2)"/>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="submit" value="加入暂存架" onclick="favorite(<s:property value="#digitalCommonInit.digitalId"/>,2)"/>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							&nbsp;
						</td>
					</tr>
					<tr>
						<td colspan="2">
							参数：
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<s:property value="#digitalCommonInit.parameter" />
						</td>
					</tr>
					<tr>
						<td colspan="2">
							&nbsp;
						</td>
					</tr>
					<tr>
						<td colspan="2">
							说明：
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<s:property value="#digitalCommonInit.description" />
						</td>
					</tr>
					<tr>
						<td colspan="2">
							&nbsp;
						</td>
					</tr>
					<tr>
						<td colspan="2">
							特别说明：
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<s:property value="#digitalCommonInit.specialExplanation" />
						</td>
					</tr>
				</table>
				<p>
					&nbsp;
				</p>
			</s:iterator>
		</s:if>



		<s:if test="#request.digitalSaleInit">
			<s:iterator value="#request.digitalSaleInit" id="digitalSaleInit">
				<table width="900" border="0" align="center">
					<tr>
						<td width="200" style="width: 210px; word-break: break-all"
							rowspan="7">
							<img
								src="<%=basePath
							+ "ShowImage.image?type=2&entityId="%><s:property value="#digitalSaleInit.digitalId"/>"
								width="200" height="200" alt="照片"
								title="<s:property value="#digitalSaleInit.digitalName" />"
								onerror="javascript:this.src='../images/custom/NoPhoto.jpg'" />

						</td>
					</tr>
					<tr>
						<td width="700">
							数码名称：
							<s:property value="#digitalSaleInit.digitalName" />
						</td>
					</tr>
					<tr>
						<td>
							条形码：
							<s:property value="#digitalSaleInit.barcode" />
						</td>
					</tr>
					<tr>
						<td>
							厂家：
							<s:property value="#digitalSaleInit.manufacturer" />
						</td>
					</tr>
					<tr>
						<td>
							品牌：
							<s:property value="#digitalSaleInit.brand" />
						</td>
					</tr>
					<tr>
						<td>
							型号：
							<s:property value="#digitalSaleInit.modelNumber" />
						</td>
					</tr>

					<tr>
						<td>
							优惠价：￥
							<span style="color: red"><s:property
									value="#digitalSaleInit.privilegePrice" /> </span>&nbsp;&nbsp;
							<input type="submit" value="   购买   " onclick="shop(<s:property value="#digitalSaleInit.digitalId"/>,2)"/>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="submit" value="加入暂存架" onclick="favorite(<s:property value="#digitalSaleInit.digitalId"/>,2)"/>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							&nbsp;
						</td>
					</tr>
					<tr>
						<td colspan="2">
							参数：
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<s:property value="#digitalSaleInit.parameter" />
						</td>
					</tr>
					<tr>
						<td colspan="2">
							&nbsp;
						</td>
					</tr>
					<tr>
						<td colspan="2">
							说明：
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<s:property value="#digitalSaleInit.description" />
						</td>
					</tr>
					<tr>
						<td colspan="2">
							&nbsp;
						</td>
					</tr>
					<tr>
						<td colspan="2">
							特别说明：
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<s:property value="#digitalSaleInit.specialExplanation" />
						</td>
					</tr>
				</table>
				<p>
					&nbsp;
				</p>
			</s:iterator>
		</s:if>
	</body>
</html>
