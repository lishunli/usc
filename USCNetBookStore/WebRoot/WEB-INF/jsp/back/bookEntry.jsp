<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		<p align="right"><a href="indexBack.action">回到后台首页</a></p>
		
		<s:form action="bookEntry" method="post" theme="simple"
			enctype="multipart/form-data">
			ISBN:<s:textfield name="book.isbn"></s:textfield>
			<font color="red">* <s:fielderror>
					<s:param>book.isbn</s:param>
				</s:fielderror> </font>
			<br>
			图书名：<s:textfield name="book.bookName"></s:textfield>
			<font color="red">* <s:fielderror>
					<s:param>book.bookName</s:param>
				</s:fielderror> </font>
			<br>
			定价：<s:textfield name="book.publishedPrice"></s:textfield>
			<font color="red">* <s:fielderror>
					<s:param>book.publishedPrice</s:param>
				</s:fielderror> </font>
			<br>
			作者：<s:textfield name="book.author"></s:textfield>
			<br>
			出版社：<s:textfield name="book.publisher"></s:textfield>
			<font color="red">* <s:fielderror>
					<s:param>book.publisher</s:param>
				</s:fielderror> </font>
			<br>
			版次：<s:textfield name="book.version"></s:textfield>
			<br>
			分类：
			<s:select list="{}" id="fType" name="PTypeID" onchange="getFType(1)"></s:select>
			<s:select list="{}" id="sType" name="PTypeID" onchange="getSType(2)"></s:select>
			<s:select list="{}" id="tType" name="PTypeID" onchange="gettType(3)"></s:select>
			<s:select list="{}" id="frType" name="PTypeID"></s:select>
			<%--			<select id="fType" name="PTypeID" onchange="getFType(1)"></select>--%>
			<%--			<select  id="sType" name="PTypeID" onchange="getSType(2)"></select>--%>
			<%--			<select id="tType" name="PTypeID" onchange="gettType(3)"></select>--%>
			<%--			<select  id="frType"  name="PTypeID" ></select>--%>
			<font color="red">* <s:fielderror>
					<s:param>PTypeID</s:param>
				</s:fielderror> </font>
			<br>
			出版时间：<s:textfield name="book.publishingTime"></s:textfield>
			<font color="red"> <s:fielderror>
					<s:param>book.publishingTime</s:param>
				</s:fielderror> </font>
			<br>
			目录：<s:textarea name="book.catalog"></s:textarea>
			<br>
			内容简介：<s:textarea name="book.briefIntroduction"></s:textarea>
			<br>
			图片：<s:file name="upload"></s:file>
			<font color="red"> <s:fielderror>
					<s:param>upload</s:param>
				</s:fielderror> </font>
			<br>
			<s:submit value="录入"></s:submit>
			<s:reset value="重置"></s:reset>
		</s:form>

	</body>
</html>