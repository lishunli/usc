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

		<title>My JSP 'BookInfo.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
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
		<s:if test="#request.bookCommonInit">
			<s:iterator value="#request.bookCommonInit" id="bookCommonInit">
				<table width="900" border="0" align="center">
					<tr>

						<td width="200" style="width: 210px; word-break: break-all"
							rowspan="8">
							<img
								src="<%=basePath
							+ "ShowImage.image?type=1&entityId="%><s:property value="#bookCommonInit.bookId"/>"
								width="200" height="200" alt="照片"
								title="<s:property value="#bookCommonInit.bookName" />"
								onerror="javascript:this.src='../images/custom/NoPhoto.jpg'" />
						</td>
					</tr>
					<tr>
						<td width="700">
							图书名称：
							<s:property value="#bookCommonInit.bookName" />
						</td>
					</tr>
					<tr>
						<td>
							ISBN：
							<s:property value="#bookCommonInit.isbn" />
						</td>
					</tr>
					<tr>
						<td>
							作者：
							<s:property value="#bookCommonInit.author" />
						</td>
					</tr>
					<tr>
						<td>
							出版社：
							<s:property value="#bookCommonInit.publisher" />
						</td>
					</tr>
					<tr>
						<td>
							出版时间：
							<s:property value="#bookCommonInit.publishingTime" />
						</td>
					</tr>
					<tr>
						<td>
							版次：
							<s:property value="#bookCommonInit.version" />
						</td>
					</tr>
					<tr>
						<td>
							会员价：￥
							<span style="color: red"><s:property
									value="#bookCommonInit.privilegePrice" /> </span>&nbsp;&nbsp; 市场价：￥
							<s:property value="#bookCommonInit.publishedPrice" />
							&nbsp;&nbsp;
							<input type="submit" value="   购买   " onclick="shop(<s:property value="#bookCommonInit.bookId"/>,1)"/>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="submit" value="加入暂存架" onclick="favorite(<s:property value="#bookCommonInit.bookId"/>,1)"/>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							&nbsp;
						</td>
					</tr>
					<tr>
						<td colspan="2">
							目录信息：
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<s:property value="#bookCommonInit.catalog" />
						</td>
					</tr>
					<tr>
						<td colspan="2">
							&nbsp;
						</td>
					</tr>
					<tr>
						<td colspan="2">
							内容简介：
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<s:property value="#bookCommonInit.briefIntroduction" />
						</td>
					</tr>
				</table>
				<p>
					&nbsp;
				</p>
			</s:iterator>
		</s:if>

		<s:if test="#request.bookSaleInit">
			<s:iterator value="#request.bookSaleInit" id="bookSaleInit">
				<table width="900" border="0" align="center">
					<tr>
						<td width="200" style="width: 210px; word-break: break-all"
							rowspan="8">
							<img
								src="<%=basePath
							+ "ShowImage.image?type=1&entityId="%><s:property value="#bookSaleInit.bookId"/>"
								width="200" height="200" alt="照片"
								title="<s:property value="#bookSaleInit.bookName" />"
								onerror="javascript:this.src='../images/custom/NoPhoto.jpg'" />
						</td>
					</tr>
					<tr>
						<td width="700">
							图书名称：
							<s:property value="#bookSaleInit.bookName" />
						</td>
					</tr>
					<tr>
						<td>
							ISBN：
							<s:property value="#bookSaleInit.isbn" />
						</td>
					</tr>
					<tr>
						<td>
							作者：
							<s:property value="#bookSaleInit.author" />
						</td>
					</tr>
					<tr>
						<td>
							出版社：
							<s:property value="#bookSaleInit.publisher" />
						</td>
					</tr>
					<tr>
						<td>
							出版时间：
							<s:property value="#bookSaleInit.publishingTime" />
						</td>
					</tr>
					<tr>
						<td>
							版次：
							<s:property value="#bookSaleInit.version" />
						</td>
					</tr>
					<tr>
						<td>
							优惠价：￥
							<span style="color: red"><s:property
									value="#bookSaleInit.privilegePrice" /> </span>&nbsp;&nbsp;
							<input type="submit" value="   购买   " onclick="shop(<s:property value="#bookSaleInit.bookId"/>,1)"/>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="submit" value="加入暂存架"  onclick="favorite(<s:property value="#bookCommonInit.bookId"/>,1)"/>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							&nbsp;
						</td>
					</tr>
					<tr>
						<td colspan="2">
							目录信息：
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<s:property value="#bookSaleInit.catalog" />
						</td>
					</tr>
					<tr>
						<td colspan="2">
							&nbsp;
						</td>
					</tr>
					<tr>
						<td colspan="2">
							内容简介：
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<s:property value="#bookSaleInit.briefIntroduction" />
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
