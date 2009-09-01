var XMLHttpReq, no; // 创建XMLHttpRequest对象，no为级别
onload = setUp; // 加载运行
function createXMLHttpRequest()// 创建XMLHttpRequest对象
{
	if (window.XMLHttpRequest) {
		// Mozilla浏览器
		XMLHttpReq = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		// IE浏览器
		try {
			XMLHttpReq = new ActiveXObject("Msxm12.XMLHTTP");
		} catch (e) {
			try {
				XMLHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {
			}
		}
	}
}
// 发送Ajax请求
function sendAjaxRequest(url) {
	createXMLHttpRequest(); // 创建XMLHttpRequest对象
	XMLHttpReq.open("post", url, false);
	XMLHttpReq.onreadystatechange = processResponse;// 指定响应函数
	XMLHttpReq.send(null);
}
// 回调函数processResponse
function processResponse() {
	if (XMLHttpReq.readyState == 4) {
		if (XMLHttpReq.status == 200) {
			var types = XMLHttpReq.responseXML.getElementsByTagName("Type");// Servlet返回的数据
			var fType = document.getElementById("fType");// 第一级对象
			var sType = document.getElementById("sType");// 第二级对象
			var tType = document.getElementById("tType");// 第三级对象
			var frType = document.getElementById("frType");// 第四级对象
			if (fType.value == "") {// 第一级下拉框为空
				sType.options.length = 0;
				tType.options.length = 0;
				frType.options.length = 0;
				addOption(fType, types);
			} else if (no == 1 && fType.value == 0) {// 第一级下拉框选择0项（也即请选择选项）时，后面下拉框全部清空
				sType.options.length = 0;
				tType.options.length = 0;
				frType.options.length = 0;
			} else if (no == 1 && fType.value != 0)  {// 第一级下拉框选择不为0项（也即选择请选择的其他选项）时，后面下拉框全部清空后再更新数据
				sType.options.length = 0;
				tType.options.length = 0;
				frType.options.length = 0;
				addOption(sType, types);
			} else if (no == 2 && sType.value == 0) {// 第二级下拉框选择0项（也即请选择选项）时，后面下拉框全部清空
				tType.options.length = 0;
				frType.options.length = 0;
			} else if (no == 2 && sType.value != 0)  {// 第二级下拉框选择不为0项（也即选择请选择的其他选项）时，后面下拉框全部清空后再更新数据
				tType.options.length = 0;
				frType.options.length = 0;
				addOption(tType, types);
			} else if (no == 3 && tType.value == 0) {// 第三级下拉框选择0项（也即请选择选项）时，后面下拉框全部清空
				frType.options.length = 0;
			} else if (no == 3 && tType.value != 0)  {// 第三级下拉框选择不为0项（也即选择请选择的其他选项）时，后面下拉框全部清空后再更新数据
				frType.options.length = 0;
				addOption(frType, types);
			}
		} else {
			// 响应未交互成功时，页面中的代码
			// "正在加载数据......"
		}
	} else {
		// 响应未加载成功时，页面中的代码
		// "正在验证用户名......"
	}
}
// 先下拉框添加数据，传下拉框的对象和下拉框待添加的数据
function addOption(selectObject, types) {
	for ( var i = 0; i < types.length; i = i + 1) {
		var typeI = types[i];
		var typeID = typeI.getElementsByTagName("TypeID").item(0).firstChild.nodeValue;
		var typeName = typeI.getElementsByTagName("TypeName").item(0).firstChild.nodeValue;
		if (i == 0) {
			selectObject.add(new Option("请选择", 0));// 0的时候在上面多添加一个请选择选项
			selectObject.add(new Option(typeName, typeID));
		} else {
			selectObject.add(new Option(typeName, typeID));// 添加数据，key
			// value分别为传过来的ID和名字
		}
	}
}
// 第一级
function getFType(num) {
	no = num;// 级别，通过请求发送过来
	var fType = document.getElementById("fType").value;// 获取值
	var url = "getAllType?FTypeID=" + fType;// AJAX发送到Servlet，传回值到回调函数
	sendAjaxRequest(url);
}
// 第二级
function getSType(num) {
	no = num;// 级别，通过请求发送过来
	var sType = document.getElementById("sType").value;// 获取值
	var url = "getAllType?FTypeID=" + sType;// AJAX发送到Servlet，传回值到回调函数
	sendAjaxRequest(url);
}
// 第三级
function gettType(num) {
	no = num;// 级别，通过请求发送过来
	var tType = document.getElementById("tType").value;// 获取值
	var url = "getAllType?FTypeID=" + tType;// AJAX发送到Servlet，传回值到回调函数
	sendAjaxRequest(url);
}
// ...
function setUp() {
	getFType(1);// 第一级
}



//上面的代码都可以用来作为几级管理来实现，数据库表的格式是ID，Name，父类ID，传父类ID查询，根的父类ID为0
//能够处理的级数是不限的，可以直接再添加几个下拉框
//只是添加一个方法并在一段判断
/*
 else if (no == 1 && fType.value == 0) {// 第一级下拉框选择0项（也即请选择选项）时，后面下拉框全部清空
	sType.options.length = 0;
	tType.options.length = 0;
	frType.options.length = 0;
} else if ((no == 1 && fType.value != 0) || sType.value == "") {// 第一级下拉框选择不为0项（也即选择请选择的其他选项）时，后面下拉框全部清空后再更新数据
	sType.options.length = 0;
	tType.options.length = 0;
	frType.options.length = 0;
	addOption(sType, types);
}
 * */
//修改上面的no和fType.value为相应的下拉框的值即可
//下面的都是该下拉框后面的下拉框，有多少添加多少
