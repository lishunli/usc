<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改促销价或优先级</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
	function showMain()
	{
		document.getElementById("salePriceInfo").innerHTML='*';  
		document.getElementById("priorityInfo").innerHTML='*';   
		if (check_num(document.forms[0].salePrice.value))
		{
			var priority = document.forms[0].priority.value;
			if (priority < 1 || priority != parseInt(priority))
			{
				document.getElementById("priorityInfo").innerHTML='优先级输入错误，请输入正整数';  
		
			}
			else
			{
				window.close();
				//刷新父页面
				window.location.href =  "mergeSale.action?entityID=" + document.forms[0].entityID.value + "&type=1" + "&salePrice=" + document.forms[0].salePrice.value + "&priority=" +  document.forms[0].priority.value;
				window.dialogArguments.location.reload();  
			}
		}
		else
		{
			document.getElementById("salePriceInfo").innerHTML='促销价输入错误，请输入正确的促销价格';   
		}
	}

	// 判断是否为float型数据
	function check_num(val_num)
	{
		var checkOK = "0123456789.";
		var checkStr = val_num;
		var allValid = true;
		var decPoints = 0;
		var allNum = "";
		var n = 0;
		for (i = 0; i < checkStr.length; i++)
		{
			ch = checkStr.charAt(i);
			if (ch == checkOK.charAt(10))
			{
				n++;// 判断该字符串中有几个点
			}
			for (j = 0; j < checkOK.length; j++)
				if (ch == checkOK.charAt(j))
					break;

			if (j == checkOK.length)
			{
				allValid = false;
				break;
			}
			if (n > 1)// 如果字符串中点的个数>1的,错误
			{
				allValid = false;
				break;
			}
		}
		if (!allValid)
		{
			return (false);
		}
		return (true);
	}
</script>


  </head>
  
  <body>
  <s:form action="mergeSale" method="post" theme="simple">
			<table>

				<tr>
					<td>
					</td>
					<td>
						<s:hidden name="entityID" id="entityID" value="%{#parameters.entityID}"></s:hidden>
					</td>
				</tr>

				<tr>
					<td>
						图书名称
					</td>
					<td>
						<s:textfield name="bookName" value="%{#parameters.bookName}" readonly="true" ></s:textfield>
					</td>
				</tr>
				<tr>
					<td>
						定价
					</td>
					<td>
						<s:textfield name="publishedPrice" value="%{#parameters.publishedPrice}" readonly="true"></s:textfield>
					</td>
				</tr>
				<tr>
					<td>
						促销价
					</td>
					<td>
						<s:textfield name="salePrice" id="salePrice" value="%{#parameters.salePrice}"></s:textfield>
						<span id="salePriceInfo" style="color: red">*</span>
					</td>
				</tr>
				<tr>
					<td>
						优先级
					</td>
					<td>
						<s:textfield name="priority" id="priority" value="%{#parameters.priority}"></s:textfield>
						<span id="priorityInfo" style="color: red">*</span>
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<input type="button" onclick="showMain()" value="修改促销价或优先级">
						<%--						<s:submit value="设为促销"></s:submit>--%>
					</td>
				</tr>

			</table>

		</s:form>
  
  
  </body>
</html>
