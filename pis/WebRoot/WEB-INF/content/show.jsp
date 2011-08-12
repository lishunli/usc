<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>产品信息</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	  <script type="text/javascript" src="js/jquery.js"></script>

<script type="text/javascript">
	$().ready(function()
	{

		$("input[type=text]").blur(function()
		{
			if (isNaN($(this).val()))
			{
				alert("实际测量值必须为数字");
			}
			else
			{
				if ($(this).val() != "")
				{
					if (check($(this).val()))
					{
						$(this).parent().next("td").html("合格");


						if(lastCheck($(this))){
							$(this).parent().parent().parent().parent().prev("span").html("<font color='green'>合格</font>");
						}

					}
					else
					{
						$(this).parent().next("td").html("<font color='red'>不合格</font>");
						$(this).parent().parent().parent().parent().prev("span").html("<font color='red'>不合格</font>");
					}
				} else {
					$(this).parent().next("td").html("");
					if(!checkHaveError($(this))){
						$(this).parent().parent().parent().parent().prev("span").html("");
					}
				}

			}

			function check(size)
			{
				var test = parseFloat(size);
				var standardLength = parseFloat($("#standardLength").html());
				var errorRange = parseFloat($("#errorRange").html());
				if (test >= standardLength - errorRange && test <= standardLength + errorRange)
				{
					return true;
				}
				else
				{
					return false;
				}
			}

			function lastCheck(obj)
			{
				var i =0;
				obj.parent().parent().parent().parent().find("tr").each(function(){
					var child = $(this).children("td").eq(2).children("input");

					if(child.val() != null && child.val() != "" && child.parent().next("td").html() == "合格"){
						i++;
					}
				});

				if(i == 3){
					return true;
				} else {
					return false;
				}
			}

			function checkHaveError(obj)
			{
				var i = 0;
				obj.parent().parent().parent().parent().find("tr").each(function(){
					var child = $(this).children("td").eq(2).children("input");

					if(child.val() != null && child.val() != "" && child.parent().next("td").html() != "合格"){
						i++;
					}
				} );

				if(i > 0){
					return true;
				} else {
					return false;
				}
			}

		});
	});
</script>


	</head>

	<body>
<h2>产品信息</h2>
<table border="1"  >
	<tbody>
		<tr>
			<td>产品型号</td>
			<td width="100"><s:property value="dto.model" /></td>
			<td>产品名称</td>
			<td width="200"><s:property value="dto.name" /> (<a href='<s:property value="dto.draw" />' target="_blank" >图纸</a>)</td>
		</tr>
		<tr>
			<td>抽样比率</td>
			<td><s:property value="dto.samplingRatio" /> </td>
			<td>抽样数量 </td>
			<td><s:property value="dto.injectionAmt" /></td>
		</tr>
		<tr>
			<td>标准长度</td>
			<td id="standardLength"><s:property value="dto.standardLength" /> </td>
			<td>误差</td>
			<td id="errorRange"><s:property value="dto.errorRange" /> </td>
		</tr>
	</tbody>
</table>

<h3>请输入检验的尺寸</h3>

<s:bean name="org.apache.struts2.util.Counter" id="counter">
   <s:param name="first" value="0" />
   <s:param name="last" value="dto.injectionAmt-1" />
   <s:iterator>
  		检验 <s:property value="current" /> <span></span>
		<table border="1"  >
			<tr>
				<td>测量对象</td>
				<td>图纸尺寸值</td>
				<td>实际测量值</td>
				<td>是否合格</td>
			</tr>
			<tr>
				<td>长</td>
				<td><s:property value="dto.standardLength" />±<s:property value="dto.errorRange" /> </td>
				<td><s:textfield name="long" theme="simple"/> </td>
				<td></td>
			</tr>
			<tr>
				<td>宽</td>
				<td><s:property value="dto.standardLength" />±<s:property value="dto.errorRange" /> </td>
				<td><s:textfield name="wide" theme="simple"/> </td>
				<td></td>
			</tr>
			<tr>
				<td>高</td>
				<td><s:property value="dto.standardLength" />±<s:property value="dto.errorRange" /> </td>
				<td><s:textfield name="high" theme="simple"/> </td>
				<td></td>
			</tr>
		</table>
		<br>
   </s:iterator>
</s:bean>

<a href="#" >导出检验结果</a>
	</body>
</html>
