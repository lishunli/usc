<%@ page language="java" contentType="text/html; charset=GB2312"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>�ϴ��ɹ�</title>
		<link href="<s:url value="/css/main.css"/>" rel="stylesheet"
			type="text/css" />
	</head>

	<body>
		<table class="wwFormTable">
			<tr>

				<td colspan="2">
					<h1>
						�ϴ��ɹ�
					</h1>
				</td>
			</tr>

			<tr>
				<td class="tdLabel">
					<label for="doUpload_upload" class="label">
						��������:
					</label>
				</td>
				<td>
					<s:property value="uploadContentType" />
				</td>
			</tr>

			<tr>
				<td class="tdLabel">
					<label for="doUpload_upload" class="label">
						�ļ�·��:
					</label>
				</td>
				<td>
					<s:property value="uploadFileName" />
				</td>
			</tr>


			<tr>
				<td class="tdLabel">
					<label for="doUpload_upload" class="label">
						��ʱ�ļ�:
					</label>
				</td>
				<td>
					<s:property value="upload" />
				</td>
			</tr>

			<tr>
				<td class="tdLabel">
					<label for="doUpload_upload" class="label">
						��ע:
					</label>
				</td>
				<td>
					<s:property value="fileCaption" />
				</td>
			</tr>


		</table>

	</body>
</html>
