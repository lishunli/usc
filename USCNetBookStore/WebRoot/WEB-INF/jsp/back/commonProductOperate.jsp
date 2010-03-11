<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>普通商品操作</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<script type="text/javascript" src="js/commonProductOperate.js"></script>
	</head>

	<body>
		<p align="right"><a href="indexBack.action">回到后台首页</a></p>

		<s:form name="backCommonSerach" method="post" theme="simple">
		产品分类
		<s:select list="{'图书','数码'}" id="type" name="type" value="type"></s:select>
		产品名称
		<s:textfield name="productsName"></s:textfield>
			<s:submit value="搜搜"></s:submit>
			<s:if test="#request.bookCommon">
				<table border="1" width="80%" align="center">
					<tr>
						<td>
							图书名称
						</td>
						<td>
							ISBN
						</td>
						<td>
							作者
						</td>
						<td>
							出版社
						</td>
						<td>
							定价
						</td>
						<td>
							折扣
						</td>
						<td>
							操作
						</td>
					</tr>
					<s:iterator value="#request.bookCommon" id="bookCommon">
						<tr>
							<td>
								<s:property value="#bookCommon.bookName" />
							</td>
							<td>
								<s:property value="#bookCommon.isbn" />
							</td>
							<td>
								<s:property value="#bookCommon.author" />
							</td>
							<td>
								<s:property value="#bookCommon.publisher" />
							</td>
							<td>
								<s:property value="#bookCommon.publishedPrice" />
							</td>
							<td>
								<s:property value="#bookCommon.discount" />
							</td>
							<td>
								<input type="button" onclick="mergeDiscount(<s:property value="#bookCommon.bookId" />,1)" value="修改折扣">
								<input type="button" onclick="unPublishe(<s:property value="#bookCommon.bookId" />,1)" value="撤销发布">
								<input type="button" onclick="saleSet(<s:property value="#bookCommon.bookId" />,1)" value="设为促销">
							</td>

						</tr>
					</s:iterator>

				</table>
			</s:if>

			<s:if test="#request.digitalCommon">
				<table border="1" width="80%" align="center">
					<tr>
						<td>
							数码名称
						</td>
						<td>
							条形码
						</td>
						<td>
							厂家
						</td>
						<td>
							品牌
						</td>
						<td>
							型号
						</td>
						<td>
							定价
						</td>
						<td>
							折扣
						</td>
						<td>
							操作
						</td>
					</tr>
					<s:iterator value="#request.digitalCommon" id="digitalCommon">
						<tr>
							<td>
								<s:property value="#digitalCommon.digitalName" />
							</td>
							<td>
								<s:property value="#digitalCommon.barcode" />
							</td>
							<td>
								<s:property value="#digitalCommon.manufacturer" />
							</td>
							<td>
								<s:property value="#digitalCommon.brand" />
							</td>
							<td>
								<s:property value="#digitalCommon.modelNumber" />
							</td>
							<td>
								<s:property value="#digitalCommon.publishedPrice" />
							</td>
							<td>
								<s:property value="#digitalCommon.discount" />
							</td>
							<td>
								<input type="button" onclick="mergeDiscount(<s:property value="#digitalCommon.digitalId" />,2)" value="修改折扣">
								<input type="button" onclick="unPublishe(<s:property value="#digitalCommon.digitalId" />,2)" value="撤销发布">
								<input type="button" onclick="saleSet(<s:property value="#digitalCommon.digitalId" />,2)" value="设为促销">
							</td>

						</tr>
					</s:iterator>
				</table>
			</s:if>
		</s:form>
	</body>
</html>
