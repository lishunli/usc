<%@ page language="java" contentType="text/html; charset=GB2312"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>文件上传示例</title>
		<link href="<s:url value="/css/main.css"/>" rel="stylesheet"
			type="text/css" />

	</head>

	<body>

		<s:actionerror />
		<s:fielderror />
		<s:form action="doUpload.action" method="POST" enctype="multipart/form-data">
			<tr>
				<td colspan="2">
					<h1>
						文件上传示例
					</h1>
				</td>
			</tr>

			<s:file name="upload" label="上传的文件" />
			<s:textfield name="fileCaption" label="备注" />
			<s:submit value="上   传" />
		</s:form>
	</body>
</html>
