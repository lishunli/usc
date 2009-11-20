<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

		<title>TestSyntaxHighlighter</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<link type="text/css" rel="stylesheet"
			href="SyntaxHighlighter/Styles/SyntaxHighlighter.css"></link>
		<script type="text/javascript" src="SyntaxHighlighter/Scripts/shCore.js"></script>
		<script type="text/javascript" src="SyntaxHighlighter/Scripts/shBrushCSharp.js"></script>
		<script type="text/javascript" src="SyntaxHighlighter/Scripts/shBrushPhp.js"></script>
		<script type="text/javascript" src="SyntaxHighlighter/Scripts/shBrushJScript.js"></script>
		<script type="text/javascript" src="SyntaxHighlighter/Scripts/shBrushJava.js"></script>
		<script type="text/javascript" src="SyntaxHighlighter/Scripts/shBrushVb.js"></script>
		<script type="text/javascript" src="SyntaxHighlighter/Scripts/shBrushSql.js"></script>
		<script type="text/javascript" src="SyntaxHighlighter/Scripts/shBrushXml.js"></script>
		<script type="text/javascript" src="SyntaxHighlighter/Scripts/shBrushDelphi.js"></script>
		<script type="text/javascript" src="SyntaxHighlighter/Scripts/shBrushPython.js"></script>
		<script type="text/javascript" src="SyntaxHighlighter/Scripts/shBrushRuby.js"></script>
		<script type="text/javascript" src="SyntaxHighlighter/Scripts/shBrushCss.js"></script>
		<script type="text/javascript" src="SyntaxHighlighter/Scripts/shBrushCpp.js"></script>

		<script language="javascript">
			window.onload = function() {
				dp.SyntaxHighlighter.ClipboardSwf = 'SyntaxHighlighter/Scripts/clipboard.swf';
				dp.SyntaxHighlighter.HighlightAll('code');
			}
		</script>

	</head>

	<body>
		<textarea name="code" class="java" cols="160" rows="100"> 
			package com.usc.actions.back;
			import com.opensymphony.xwork2.ActionContext;
			import com.opensymphony.xwork2.ActionSupport;
			
			/**
			 * 后台退出Action
			 * 
			 * @author MZ
			 *
			 * 2009-8-26下午16:27:02
			 */
			public class BackExitAction extends ActionSupport
			{
			
					@Override
					public String execute() throws Exception
					{
					ActionContext.getContext().getSession().remove("manger");//session移除
					return SUCCESS;
				}
				
			
			}
		</textarea>
		<br>
	</body>
</html>
