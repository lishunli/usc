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

		<title>促销商品操作</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<script type="text/javascript" src="js/saleProductOperate.js"></script>
	</head>

	<body>
		<p align="right"><a href="indexBack.action">回到后台首页</a></p>

		<s:form name="backSaleSerach" method="post" theme="simple">
		产品分类
		<s:select list="{'图书','数码'}" id="type" name="type" value="type"></s:select>
		产品名称
		<s:textfield name="productsName"></s:textfield>
			<s:submit value="搜搜"></s:submit>
			<s:if test="#request.bookSale">
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
								<input type="button"
									onclick="unSale(<s:property value="#bookSale.bookId" />,1)"
									value="设为普通商品">
							</td>

						</tr>
					</s:iterator>

				</table>
			</s:if>

			<s:if test="#request.digitalSale">
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
							促销价
						</td>
						<td>
							优先级
						</td>
						<td>
							操作
						</td>
					</tr>
					<s:iterator value="#request.digitalSale" id="digitalSale">
						<tr>
							<td>
								<s:property value="#digitalSale.digitalName" />
							</td>
							<td>
								<s:property value="#digitalSale.barcode" />
							</td>
							<td>
								<s:property value="#digitalSale.manufacturer" />
							</td>
							<td>
								<s:property value="#digitalSale.brand" />
							</td>
							<td>
								<s:property value="#digitalSale.modelNumber" />
							</td>
							<td>
								<s:property value="#digitalSale.publishedPrice" />
							</td>
							<td>
								<s:property value="#digitalSale.salePrice" />
							</td>
							<td>
								<s:property value="#digitalSale.priority" />
							</td>
							<td>
								<input type="button"
									onclick="mergeSale(<s:property value="#digitalSale.digitalId" />,2,<s:property value="#digitalSale.salePrice" />,<s:property value="#digitalSale.priority" />)"
									value="修改促销价或优先级">
								<input type="button"
									onclick="unSale(<s:property value="#digitalSale.digitalId" />,2)"
									value="设为普通商品">
							</td>

						</tr>
					</s:iterator>
				</table>
			</s:if>
		</s:form>
	</body>
</html>
