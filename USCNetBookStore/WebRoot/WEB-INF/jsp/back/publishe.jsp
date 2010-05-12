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

		<title>发布商品</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<script type="text/javascript" src="js/publishe.js"></script>
	</head>

	<body>
		<h1 align="center" style="color: blue">
			<img alt="usc" src="images/custom/Log.jpg" width="995" height="131" align="top">
			<br>
			电子图书后台管理系统之信息发布系统——图书发布
		</h1>
		<p align="right">
			<a href="indexBack.action">回到后台首页</a>
		</p>

		<s:form name="backSerach" method="post" theme="simple">
		
		图书名称
		<s:textfield name="productsName"></s:textfield>
			<s:submit value="搜搜"></s:submit>
			<s:if test="#request.bookSerach.size">
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
							操作
						</td>
					</tr>
					<s:iterator value="#request.bookSerach" id="book">
						<tr>
							<td>
								<s:property value="#book.bookName" />
							</td>
							<td>
								<s:property value="#book.isbn" />
							</td>
							<td>
								<s:property value="#book.author" />
							</td>
							<td>
								<s:property value="#book.publisher" />
							</td>
							<td>
								<s:property value="#book.publishedPrice" />
							</td>
							<td>
								<input type="button" onclick="publishe(<s:property value='#book.bookId'/>,1)" value="发布" />
								<%--onclick="publishe('<s:property value="#book.bookName"/>')"上面是传一个Int值，这个传String字符串--%>
							</td>

						</tr>
					</s:iterator>
				</table>
			</s:if>

		</s:form>
	</body>
</html>
