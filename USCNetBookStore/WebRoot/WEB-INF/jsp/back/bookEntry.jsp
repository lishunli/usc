<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>图书录入</title>
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/back.js"></script>
	</head>
	<body>
		<h1 align="center" style="color: blue">
			<img alt="usc" src="images/custom/Log.jpg" width="995" height="131" align="top">
			<br>
			电子图书后台管理系统之信息发布系统
		</h1>
		<p align="right">
			<a href="indexBack.action">回到后台首页</a>
		</p>

		<s:form action="bookEntry" method="post" theme="simple" enctype="multipart/form-data">
			<table width="600" border="1" align="center">
				<tr>
					<td colspan="2">
						<div align="center">
							<h2>
								图书录入
							</h2>
						</div>
					</td>
				</tr>
				<tr>
					<td width="16%">
						ISBN
					</td>
					<td width="84%">
						<s:textfield name="book.isbn"></s:textfield>
						<font color="red">* <s:fielderror>
								<s:param>book.isbn</s:param>
							</s:fielderror> </font>
					</td>
				</tr>

				<tr>
					<td>
						图书名
					</td>
					<td>
						<s:textfield name="book.bookName"></s:textfield>
						<font color="red">* <s:fielderror>
								<s:param>book.bookName</s:param>
							</s:fielderror> </font>
					</td>
				</tr>

				<tr>
					<td>
						定价
					</td>
					<td>
						<s:textfield name="book.publishedPrice"></s:textfield>
						<font color="red">* <s:fielderror>
								<s:param>book.publishedPrice</s:param>
							</s:fielderror> </font>
					</td>
				</tr>

				<tr>
					<td>
						作者
					</td>
					<td>
						<s:textfield name="book.author"></s:textfield>
					</td>
				</tr>


				<tr>
					<td>
						出版社
					</td>
					<td>
						<s:textfield name="book.publisher"></s:textfield>
						<font color="red">* <s:fielderror>
								<s:param>book.publisher</s:param>
							</s:fielderror> </font>
					</td>
				</tr>


				<tr>
					<td>
						版次
					</td>
					<td>
						<s:textfield name="book.version"></s:textfield>
					</td>
				</tr>


				<tr>
					<td>
						分类
					</td>
					<td>
						<s:select list="{}" id="fType" name="PTypeID" onchange="getFType(1)"></s:select>
						<s:select list="{}" id="sType" name="PTypeID" onchange="getSType(2)"></s:select>
						<s:select list="{}" id="tType" name="PTypeID" onchange="gettType(3)"></s:select>
						<s:select list="{}" id="frType" name="PTypeID"></s:select>
						<font color="red">* <s:fielderror>
								<s:param>PTypeID</s:param>
							</s:fielderror> </font>
					</td>
				</tr>


				<tr>
					<td>
						出版时间
					</td>
					<td>
						<s:textfield name="book.publishingTime"></s:textfield>
						<font color="red"> <s:fielderror>
								<s:param>book.publishingTime</s:param>
							</s:fielderror> </font>
					</td>
				</tr>


				<tr>
					<td>
						内容简介
					</td>
					<td>
						<s:textarea name="book.briefIntroduction"></s:textarea>
					</td>
				</tr>


				<tr>
					<td>
						图片
					</td>
					<td>
						<s:file name="upload"></s:file>
						<font color="red"> <s:fielderror>
								<s:param>upload</s:param>
							</s:fielderror> </font>
					</td>
				</tr>

				<tr>
					<td>
					</td>
					<td>
						<s:submit value="录入"></s:submit>
						<s:reset value="重置"></s:reset>
					</td>
				</tr>
			</table>
		</s:form>

	</body>
</html>