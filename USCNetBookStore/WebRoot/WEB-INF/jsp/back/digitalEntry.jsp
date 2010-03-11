<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>数码录入</title>
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/back.js"></script>
	</head>
	<body>
		<p align="right"><a href="indexBack.action">回到后台首页</a></p>

		<s:form action="digitalEntry" method="post" theme="simple"
			enctype="multipart/form-data">
			条形码:<s:textfield name="digital.barcode"></s:textfield>
			<font color="red">* <s:fielderror>
					<s:param>digital.barcode</s:param>
				</s:fielderror> </font>
			<br>
			数码名称：<s:textfield name="digital.digitalName"></s:textfield>
			<font color="red">* <s:fielderror>
					<s:param>digital.digitalName</s:param>
				</s:fielderror> </font>
			<br>
			定价：<s:textfield name="digital.publishedPrice"></s:textfield>
			<font color="red">* <s:fielderror>
					<s:param>digital.publishedPrice</s:param>
				</s:fielderror> </font>
			<br>
			厂家：<s:textfield name="digital.manufacturer"></s:textfield><br>
			品牌：<s:textfield name="digital.brand"></s:textfield>
			<font color="red">* <s:fielderror>
					<s:param>digital.brand</s:param>
				</s:fielderror> </font>
			<br>
			型号：<s:textfield name="digital.modelNumber"></s:textfield><br>
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
			参数：<s:textarea name="digital.parameter"></s:textarea><br>
			说明：<s:textarea name="digital.description"></s:textarea><br>
			特别说明：<s:textarea name="digital.specialExplanation"></s:textarea><br>
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