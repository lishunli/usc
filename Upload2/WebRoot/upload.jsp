<%@ page language="java" contentType="text/html; charset=GB2312"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>�ļ��ϴ�ʾ��</title>
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
						�ļ��ϴ�ʾ��
					</h1>
				</td>
			</tr>

			<s:file name="upload" label="�ϴ����ļ�" />
			<s:textfield name="fileCaption" label="��ע" />
			<s:submit value="��   ��" />
		</s:form>
	</body>
</html>
