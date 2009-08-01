//用户名检测，不能为空，长度在6到12之间
var submitflag1 = 1;
var submitflag2 = 1;
var submitflag3 = 1;
var into = 0;
var XMLHttpReq=false; 
function checkusername() {
	
	var username = document.getElementById("username").value;// dom获得username
	var checkusernameinfo = $("#checkusernameinfo");// jquery获得checkusernameinfo节点
	checkusernameinfo.html("");// 初始化span
	if ("" == trim(username)) // 为空
	{
// alert("username is required");
		checkusernameinfo.html("username is required");// span填充提示信息
		submitflag1 =0;
// document.getElementById("submit").disabled = true;//设置提交按钮不可用
	}
	else if(trim(username).length > 12  || trim(username).length < 5)// 长度 5-
																		// 12
	{
// alert("username length must between 6 in 12");
		checkusernameinfo.html("username length must between 5  in 12");// span填充提示信息
// document.getElementById("submit").disabled = true;//设置提交按钮不可用
		submitflag1 =0;
	}
	else 
		submitflag1 =1;
// verify();
//	alert(username);
//	send("register.do?name="+username); ]
	verify();
	initsubmit();
	
}

// 密码检测，不能为空
function checkpassword() {
	var password = document.getElementById("password").value;// dom获得password
	var checkpasswordinfo = $("#checkpasswordinfo");// jquery获得checkpasswordinfo节点
	checkpasswordinfo.html("");// 初始化span
	if ("" == trim(password)) // 为空
	{
// alert("username is required");
		checkpasswordinfo.html("password is required");// span填充提示信息
		submitflag2 =0;
// document.getElementById("submit").disabled = true;//设置提交按钮不可用
	}
	else 
		submitflag2 =1;
	if(into)
		checkrepassword();
	initsubmit();
}

// 重复密码检测，不能为空，也密码相同
function checkrepassword() {
	var repassword = document.getElementById("repassword").value;// dom获得repassword
	var checkrepasswordinfo = $("#checkrepasswordinfo");// jquery获得checkrepasswordinfo节点
	checkrepasswordinfo.html("");// 初始化span
	if ("" == repassword) // 为空
	{
// alert("username is required");
		checkrepasswordinfo.html("repassword is required");// span填充提示信息
// document.getElementById("submit").disabled = true;//设置提交按钮不可用
		submitflag3 =0;
	}
	else if(repassword != trim(document.getElementById("password").value))// 密码和重复密码不相同
	{
// alert("username length must between 6 in 12");
		checkrepasswordinfo.html("password not equal repassword");// span填充提示信息
// document.getElementById("submit").disabled = true;//设置提交按钮不可用
		submitflag3 =0;
	}
	else
		submitflag3 =1;
	into = 1;
	initsubmit();
}

// 提交之前的检查，也就是包含上面的所有的检查
function check() {
	checkusername();
	checkpassword();
	checkrepassword();
}

// 删除左右两端的空格
function trim(str) {
	return str.replace(/(^\s*)|(\s*$)/g, "");
}
// 设置提交按钮的可用性
function initsubmit() {
	if(submitflag1 == 0 || submitflag2 == 0 || submitflag3 == 0)
		document.getElementById("submit").disabled = true;// 设置提交按钮不可用
	else
		document.getElementById("submit").disabled = false;// 设置提交按钮可用
}

function cleanusernameerror() {
// var checkusernameinfo = $("#checkusernameinfo");//jquery获得checkusernameinfo节点
	$("#checkusernameinfo").html("");// 初始化span
	$("#username").select();
}

function cleanpassworderror(){
// alert("clean");
// var checkpasswordinfo = $("#checkpasswordinfo");//jquery获得checkusernameinfo节点
	$("#checkpasswordinfo").html("");// 初始化span
	$("#password").select();
}

function cleanrepassworderror() {
// var checkrepasswordinfo =
// $("#checkrepasswordinfo");//jquery获得checkusernameinfo节点
	$("#checkrepasswordinfo").html("");// 初始化span
	$("#repassword").select();
}

//定义用户名校验的方法
function verify(){
    //首先测试一下页面的按钮按下，可以调用这个方法
    //使用javascript的alert方法，显示一个探出提示框
    //alert("按钮被点击了！！！");

    //1.获取文本框中的内容
    //document.getElementById("userName");  dom的方式
    //Jquery的查找节点的方式，参数中#加上id属性值可以找到一个节点。
    //jquery的方法返回的都是jquery的对象，可以继续在上面执行其他的jquery方法
    var jqueryObj = $("#username");
    //获取节点的值
    var userName = jqueryObj.val();
    //alert(userName);

    //2.将文本框中的数据发送给服务器段的servelt
    //使用jquery的XMLHTTPrequest对象get请求的封装
    $.get("CheckUser?name=" + userName,null,callback);
//    $.get("register.do?name=" + userName,null,callback);


}

//回调函数
function callback(data) {
//    alert("服务器段的数据回来了！！");
    //3.接收服务器端返回的数据
//    alert(data);
    //4.将服务器段返回的数据动态的显示在页面上
    //找到保存结果信息的节点
    var resultObj = $("#checkusernameinfo");
    //动态的改变页面中div节点中的内容
//    if(data == "username exist,please change username\r\n")
    	resultObj.html(data);
}
