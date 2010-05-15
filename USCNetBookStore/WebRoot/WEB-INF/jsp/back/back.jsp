<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>电子图书后台管理系统</title>
		<script type="text/javascript">
function BackExit()
{

	if(confirm("你真的想退出吗？"))
	{
		return true;
	}
	else 
	{
		return false;
	}
}

function CTime(bgclock){
	var now=new Date();
	var year=now.getFullYear();
	var month=now.getMonth();
	var date=now.getDate();
	var day=now.getDay();
	var hour=now.getHours();
	var minu=now.getMinutes();
	var sec=now.getSeconds();
	var week;
	month=month+1;
	if(month<10) month="0"+month;
	if(date<10) date="0"+date;
	if(hour<10) hour="0"+hour;
	if(minu<10) minu="0"+minu;
	if(sec<10) sec="0"+sec;
	var time="";
	time="当前时间："+year+"年"+month+"月"+date+"日 "+hour+":"+minu+":"+sec;
	//if(document.all){
		bgclock.innerHTML='<b><font color="green">'+time+'</font></b>'
//}
	var timer=setTimeout("CTime(bgclock)",200);
} 


function AdvancedSearch() {
	var type = document.getElementById("type").value;//类型 
	if(1 ==  type)
	{
		window.self.location = "AdvancedSearchBook.jsp";
	}
	else if(2 ==  type)
	{
		window.self.location = "AdvancedSearchDigital.jsp";
	}
}

</script>


	</head>
	<body onload="CTime(bgclock)">

		<h1 align="center" style="color: blue">
			<img alt="usc" src="images/custom/Log.jpg" width="995" height="131" align="top">
			<br>
			电子图书后台管理系统之信息发布系统
		</h1>

		<table align="center" width="995">
			<tr>
				<td>
					欢迎您：
					<font color="red"> <s:property value="#session.manger.operatorName" /> </font> &nbsp;&nbsp;
					<s:if test="#session.manger.operatorType == '系统管理员'">
						<a href="addManger.action">【添加新管理员】</a>&nbsp;&nbsp;
					</s:if>
					<a href="updatePass.action">【修改密码】</a>&nbsp;&nbsp;
					<a href="backExit.action" onclick="return BackExit()">【退出】</a>&nbsp;&nbsp;
					<span id="bgclock"></span>
					<br>
					<br>
					<br>
					<br>
				</td>
			</tr>
			<tr>
				<td>
					<a href="bookEntry.action">图书录入</a>
					<br>
					<br>
				</td>
			</tr>
			<tr>
				<td>
					<a href="backSerach.action">图书发布</a>
					<br>
					<br>
				</td>
			</tr>
			<tr>
				<td>
					<a href="backCommonSerach.action">普通图书操作</a>
					<br>
					<br>
				</td>
			</tr>
			<tr>
				<td>
					<a href="backSaleSerach.action">促销图书操作</a>
					<br>
					<br>
				</td>
		</table>
	</body>

	<div
		style="background: #ededed; height: 31px; width: 100%; position: fixed; left: auto; right: auto; bottom: 0; _position: absolute; _top: e xpression(document.documentElement.clientHeight +           document.documentElement.scrollTop -           this.offsetHeight); text-align: center;">
		Powered by: 南华大学计算机科学与技术学院 指导老师：谢卫星 Copyright ©2010
		<a href="http://www.blogjava.net/lishunli/" target="_blank">李顺利</a>
	</div>
</html>