<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s" %>
当前页:第${pageView.currentPage}页 | 总记录数:${pageView.totalRecord}条 |
每页显示:${pageView.maxResult}条 | 总页数:${pageView.totalPage}页
<s:iterator begin="#request.pageView.pageIndex.startIndex"
	end="#request.pageView.pageIndex.endIndex" var="wp">
	<s:if test="#request.pageView.currentPage== #wp">
		<b>第${wp}页</b>
	</s:if>
	<s:if test="#request.pageView.currentPage!= #wp">
		<a href="javascript:topage('${wp}')">第${wp}页</a>
	</s:if>
</s:iterator>
