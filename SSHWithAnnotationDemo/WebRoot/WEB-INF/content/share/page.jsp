<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s" %>
当前页:第${pageView.currentpage}页 | 总记录数:${pageView.totalrecord}条 |
每页显示:${pageView.maxresult}条 | 总页数:${pageView.totalpage}页
<s:iterator begin="#request.pageView.pageindex.startindex"
	end="#request.pageView.pageindex.endindex" var="wp">
	<s:if test="#request.pageView.currentpage== #wp">
		<b>第${wp}页</b>
	</s:if>
	<s:if test="#request.pageView.currentpage!= #wp">
		<a href="javascript:topage('${wp}')">第${wp}页</a>
	</s:if>
</s:iterator>
