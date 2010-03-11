<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<s:include value="/Top.jsp"></s:include>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/" + "customjsp" + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title>无标题文档</title>
		<style type="text/css">
<!--
.STYLE1 {
	font-size: 16px;
	font-weight: bold;
}

.STYLE2 {
	font-size: 18px;
	font-weight: bold;
}

.STYLE3 {
	font-size: 18px
}

.STYLE5 {
	font-size: 12px
}
-->
</style>

		<script type="text/javascript">
	function Info(entityID, type) {
		window.self.location = "info.action?entityID=" + entityID + "&type="
				+ type;
	}
</script>

	</head>

	<body>

		<table width="80%" border="1" align="center" cellpadding="0"
			cellspacing="0" bordercolor="#DBDBDB">
			<tr>
				<th height="17" bgcolor="#88B95B" scope="col">
					<div align="left" class="STYLE3">
						您所搜的x共有x种
					</div>
				</th>
			</tr>
			<tr>
				<td width="42%" height="23" bgcolor="#C9C9C9">
					<div align="left" class="STYLE1">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;排序方式：
						<select name="select">
							<option value="0" selected="selected">
								按销量由多到少
							</option>
							<option value="1">
								按价格由高到低
							</option>
							<option value="2">
								按价格由低到高
							</option>
						</select>
						<span class="STYLE2">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;第一页 上一页 下一页 最后一页 <span class="STYLE5">第3/10页</span>
						</span>
					</div>
				</td>
			</tr>
			<tr>
				<td height="719" bgcolor="#F6F6F6">
					&nbsp;
					<s:if test="#request.bookCommonInit">
						<table width="800" align="center">
							<tr>
								图书
							</tr>
							<tr>
								<s:iterator value="#request.bookCommonInit" id="bookCommonInit"
									status="count">
									<td width="200" height="120"
										style="width: 200px; word-break: break-all" align="center">
										<a
											href="info.action?type=1&entityID=<s:property value='#bookCommonInit.bookId'/>">
											<img
												src="<%=basePath
							+ "ShowImage.image?type=1&entityId="%><s:property value="#bookCommonInit.bookId"/>"
												width="100" height="100" alt="照片"
												title="<s:property value="#bookCommonInit.bookName" />"
												onerror="javascript:this.src='../images/custom/NoPhoto.jpg'" />
										</a>
										<DIV
											STYLE="width: 200x; height: 20px; border: 1px; overflow: hidden; text-overflow: ellipsis">
											<s:property value="#bookCommonInit.bookName" />
										</DIV>
										<p style="color: red">
											￥
											<s:property value="#bookCommonInit.privilegePrice" />
										</p>
										<p>
											(市场价￥
											<s:property value="#bookCommonInit.publishedPrice" />
											)
										</p>
									</td>
									<s:if test="#count.modulus(6)==0">
										<s:if test="#count.last">
							</tr>
							</s:if>
							<s:else>
								<tr>
							</s:else>
							</s:if>
							</s:iterator>
						</table>
					</s:if>
					<br>
					<br>
					<s:if test="#request.bookSaleInit">
						<table width="800" align="center">
							<tr>
								图书促销
							</tr>
							<tr>
								<s:iterator value="#request.bookSaleInit" id="bookSaleInit"
									status="count">
									<td width="800" height="120"
										style="width: 200px; word-break: break-all" align="center">
										<a
											href="info.action?type=1&entityID=<s:property value='#bookSaleInit.bookId'/>"><img
												src="<%=basePath
							+ "ShowImage.image?type=1&entityId="%><s:property value="#bookSaleInit.bookId"/>"
												width="100" height="100" alt="照片"
												title="<s:property value="#bookSaleInit.bookName" />"
												onerror="javascript:this.src='../images/custom/NoPhoto.jpg'" />
										</a>
										<DIV
											STYLE="width: 200x; height: 20px; border: 1px; overflow: hidden; text-overflow: ellipsis">
											<s:property value="#bookSaleInit.bookName" />
										</DIV>
										<p style="color: red">
											促销价￥
											<s:property value="#bookSaleInit.privilegePrice" />
										</p>
									</td>
									<s:if test="#count.modulus(6)==0">
										<s:if test="#count.last">
							</tr>
							</s:if>
							<s:else>
								<tr>
							</s:else>
							</s:if>
							</s:iterator>
						</table>
					</s:if>

					<s:if test="#request.digitalCommonInit">
						<table width="800" align="center">
							<tr>
								数码
							</tr>
							<tr>
								<s:iterator value="#request.digitalCommonInit"
									id="digitalCommonInit" status="count">
									<td width="800" height="120"
										style="width: 200px; word-break: break-all" align="center">
										<a
											href="info.action?type=2&entityID=<s:property value='#digitalCommonInit.digitalId'/>">
											<img
												src="<%=basePath
							+ "ShowImage.image?type=2&entityId="%><s:property value="#digitalCommonInit.digitalId"/>"
												width="100" height="100" alt="照片"
												title="<s:property value="#digitalCommonInit.digitalName" />"
												onerror="javascript:this.src='../images/custom/NoPhoto.jpg'" />
										</a>
										<DIV
											STYLE="width: 200x; height: 20px; border: 1px; overflow: hidden; text-overflow: ellipsis">
											<s:property value="#digitalCommonInit.digitalName" />
										</DIV>
										<p style="color: red">
											￥
											<s:property value="#digitalCommonInit.publishedPrice" />
										</p>
										<p>
											(市场价￥
											<s:property value="#digitalCommonInit.privilegePrice" />
											)
										</p>
									</td>
									<s:if test="#count.modulus(6)==0">
										<s:if test="#count.last">
							</tr>
							</s:if>
							<s:else>
								<tr>
							</s:else>
							</s:if>
							</s:iterator>

						</table>
					</s:if>
					<br>
					<br>
					<s:if test="#request.digitalSaleInit">
						<table width="800" align="center">
							<tr>
								数码促销
							</tr>
							<tr>
								<s:iterator value="#request.digitalSaleInit"
									id="digitalSaleInit" status="count">
									<td width="800" height="120"
										style="width: 200px; word-break: break-all" align="center">
										<a
											href="info.action?type=2&entityID=<s:property value='#digitalSaleInit.digitalId'/>">
											<img
												src="<%=basePath
							+ "ShowImage.image?type=2&entityId="%><s:property value="#digitalSaleInit.digitalId"/>"
												width="100" height="100" alt="照片"
												title="<s:property value="#digitalSaleInit.digitalName" />"
												onerror="javascript:this.src='../images/custom/NoPhoto.jpg'" />
										</a>
										<DIV
											STYLE="width: 200x; height: 20px; border: 1px; overflow: hidden; text-overflow: ellipsis">
											<s:property value="#digitalSaleInit.digitalName" />
										</DIV>
										<p style="color: red">
											促销价￥
											<s:property value="#digitalSaleInit.privilegePrice" />
										</p>
									</td>
									<s:if test="#count.modulus(6)==0">
										<s:if test="#count.last">
							</tr>
							</s:if>
							<s:else>
								<tr>
							</s:else>
							</s:if>
							</s:iterator>
						</table>
					</s:if>



				</td>
			</tr>
		</table>
		<div align="center"></div>
	</body>
</html>
