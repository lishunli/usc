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

		<title>促销图书操作</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<script type="text/javascript" src="js/saleProductOperate.js"></script>
	</head>

	<body>
		<h1 align="center" style="color: blue">
			<img alt="usc" src="images/custom/Log.jpg" width="995" height="131" align="top">
			<br>
			电子图书后台管理系统之信息发布系统——促销图书操作
		</h1>
		<p align="right">
			<a href="indexBack.action">回到后台首页</a>
		</p>

		<s:form name="backSaleSerach" method="post" theme="simple">
			<table align="center">
				<tr>
					<td>
						图书名称
					</td>
					<td>
						<s:textfield name="productsName"></s:textfield>
					</td>
					<td>
						<s:submit value="搜搜" cssStyle="color:red"></s:submit>
					</td>
				</tr>
			</table>
		</s:form>

		<s:if test="#request.bookSale.size">
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
						促销价
					</td>
					<td>
						优先级
					</td>
					<td>
						操作
					</td>
				</tr>
				<s:iterator value="#request.bookSale" id="bookSale">
					<tr>
						<td>
							<s:property value="#bookSale.bookName" />
						</td>
						<td>
							<s:property value="#bookSale.isbn" />
						</td>
						<td>
							<s:property value="#bookSale.author" />
						</td>
						<td>
							<s:property value="#bookSale.publisher" />
						</td>
						<td>
							<s:property value="#bookSale.publishedPrice" />
						</td>
						<td>
							<s:property value="#bookSale.salePrice" />
						</td>
						<td>
							<s:property value="#bookSale.priority" />
						</td>
						<td>
							<input type="button"
								onclick="mergeSale(<s:property value="#bookSale.bookId"/>,1,<s:property value="#bookSale.salePrice" />,<s:property value="#bookSale.priority" />)"
								value="修改促销价或优先级">
							<input type="button" onclick="unSale(<s:property value="#bookSale.bookId" />,1)" value="设为普通商品">
						</td>

					</tr>
				</s:iterator>

			</table>
		</s:if>

	</body>
</html>
