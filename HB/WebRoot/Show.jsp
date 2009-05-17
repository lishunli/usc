<%@ page language="java" pageEncoding="gbk"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
<head>
	<html:base />

	<title>show.jsp</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<center>
		<table border="1">
			<tr>
				<td>
					ID
				</td>
				<td>
					ÓÃ»§Ãû
				</td>
				<td>
					ÃÜÂë
				</td>
			</tr>
			<logic:iterate id="user" name="rs" scope="session">
				<tr>
					<td>
						${user.uid }
					</td>
					<td>
						${user.uname }
					</td>
					<td>
						${user.upass }
					</td>
				</tr>
			</logic:iterate>
		</table>
	</center>
</body>
</html:html>
