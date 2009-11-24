<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>download</title>
	</head>
	<body>
		<%--	<s:iterator value="uploadFileName" id="downloadFileName">--%>
		<%--				<a href="download.action?name=<s:property value='%{#downloadFileName}'/>"><s:property value="%{#%{#downloadFileName}}" /> </a>--%>
		<%--				<br>--%>
		<%--	</s:iterator>--%>
		<c:forEach var="uploadFiles" items="${uploadFiles}">
			<a href="download.action?name=${uploadFiles.uploadRealName }&realname=${uploadFiles.uploadFileName }">${uploadFiles.uploadFileName }</a>
			<br>
		</c:forEach>
	</body>
</html>