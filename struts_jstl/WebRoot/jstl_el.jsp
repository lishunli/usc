<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>����EL���ʽ</title>
</head>
<body>
	<h1>����EL���ʽ</h1><br>
	<hr>
	<li>��ͨ�ַ���</li><br>
	hello(jsp�ű�):<%=request.getAttribute("hello") %><br>
	hello(el���ʽ,el���ʽ��ʹ�÷���$��{}):${hello }<br>
	hello(el���ʽ,el����������pageScope,requestScope,sessionScope,applicationScope,<br> ���δָ��scope,��������˳��ΪpageScope~applicationScope):${requestScope.hello }<br>
	hello(el���ʽ,scope=session):${sessionScope.hello }<br>
	<p>
	<li>�ṹ,����.���е�����Ҳ�ƴ�ȡ��</li><br>
	������${user.username }<br>
	���䣺${user.age }<br>
	�����飺${user.group.name }<br>
	<p>
	<li>���map,����.���е�����Ҳ�ƴ�ȡ��</li><br>
	mapvalue.key1:${mapvalue.key1 }<br>
	mapvalue.key2:${mapvalue.key2 }<br>
	<p>
	<li>�������,����[]���±�</li><br>
	strarray[2]:${strarray[1] }<br>
	<p>
	<li>�����������,����[]���±�</li><br>
	userarray[3].username:${users[2].username }<br>
	<p>
	<li>���list,����[]���±�</li><br>
	userlist[5].username:${userlist[4].username }<br>
	<p>
	<li>el���ʽ���������֧��</li><br>
	1+2=${1+2 }<br>
	10/5=${10/5 }<br>
	10 div 5=${10 div 5 }<br>
	10%3=${10 % 3 }<br>
	10 mod 3=${10 mod 3 }<br>
	<!--
		 ==/eq
		 !=/ne 
		 </lt
		 >/gt
		 <=/le
		 >=/ge
		 &&/and
		 ||/or
		 !/not
		 //div
		 %/mod
	 -->  
	 <li>����empty</li><br>
	 value1:${empty value1 }<br>
	 value2:${empty value2 }<br>
	 value3:${empty value3 }<br>
	 value4:${empty value4 }<br>
	 value4:${!empty value4 }<br>
</body>
</html>