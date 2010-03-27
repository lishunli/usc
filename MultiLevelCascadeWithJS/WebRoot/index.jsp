<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<title>PCAS (Province City Area Selector 省、市、地区联动选择JS封装类) Ver 2.01 数据压缩完整版 程序制作/版权所有:崔永祥(333)</title> 
<style> 
a,body,select{font-size:12px;text-decoration:none;}
a,pre{color:#808080;}
body{background:#efefef;}
</style> 
<pre> 
/* PCAS (Province City Area Selector 省、市、地区联动选择JS封装类) Ver 2.01 数据压缩完整版 *\
 
　制作时间:2005-12-30
　更新时间:2006-01-24
　数据修正:2006-08-17
　文档大小:18KB
　演示地址:<a href="http://www.popub.net/script/PCAS.html">http://www.popub.net/script/PCAS.html</a> 
　下载地址:<a href="http://www.popub.net/script/PCASClass.js"><font color="red">http://www.popub.net/script/PCASClass.js</font></a> 
　应用说明:页面包含&lt;script type="text/javascript" src="PCASClass.js">&lt;/script>
	省市联动
		new PCAS("Province","City")
		new PCAS("Province","City","吉林省")
		new PCAS("Province","City","吉林省","吉林市")
	省市地区联动
		new PCAS("Province","City","Area")
		new PCAS("Province","City","Area","吉林省")
		new PCAS("Province","City","Area","吉林省","松原市")
		new PCAS("Province","City","Area","吉林省","松原市","宁江区")
	省、市、地区对象取得的值均为实际值。
	注：省、市、地区提示信息选项的值为""(空字符串)
 
　感谢
　　　网友418528#gmail.com对数据进行的核实工作 2006-08-07
 
\*** 程序制作/版权所有:崔永祥(333) E-Mail:zhadan007@21cn.com 网址:http://www.popub.net ***/
</pre> 
<script language="javascript" src="JS/pcasunzip.js"></script> 
 
 
<fieldset style="padding:5px;"> 
<legend>省市联动</legend> 
出生地：<select name="P1"></select><select name="C1"></select><br> 
所在地：<select name="P2"></select><select name="C2"></select><br> 
工作地：<select name="P3"></select><select name="C3"></select><br> 
</fieldset> 
 
<br><br> 
 
<fieldset style="padding:5px;"> 
<legend>省市地区联动</legend> 
出　　 生 　地：<select name="province"></select><select name="city"></select><select name="area"></select><br> 
户 口 所 在 地：<select name="province1"></select><select name="city1"></select><select name="area1"></select><br> 
工 作 所 在 地：<select name="province2"></select><select name="city2"></select><select name="area2"></select><br> 
<br> 
无　　默　　认：<select name="province3"></select><select name="city3"></select><select name="area3"></select><br> 
默　　认　　省：<select name="province4"></select><select name="city4"></select><select name="area4"></select><br> 
默　认　省　市：<select name="province5"></select><select name="city5"></select><select name="area5"></select><br> 
默 认 省 市 区：<select name="province6"></select><select name="city6"></select><select name="area6"></select><br> 
</fieldset> 
<script language="javascript" defer> 
new PCAS("P1","C1");
new PCAS("P2","C2","吉林省");
new PCAS("P3","C3","江苏省","苏州市");
 
new PCAS("province","city","area","吉林省","白城市","大安市");
new PCAS("province1","city1","area1","吉林省","吉林市","龙潭区");
new PCAS("province2","city2","area2","江苏省","苏州市","沧浪区");
 
new PCAS("province3","city3","area3");
new PCAS("province4","city4","area4","江苏省");
new PCAS("province5","city5","area5","江苏省","苏州市");
new PCAS("province6","city6","area6","江苏省","苏州市","沧浪区");
</script> 
<br> 

</body>