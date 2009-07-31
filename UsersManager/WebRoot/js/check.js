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
	send("register.do?name="+username); 
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

//function verify() {
//    // 0。使用dom的方式获取文本框中的值
//    // document.getElementById("userName")是dom中获取元素节点的一种方法，一个元素节点对应HTML页面中的一个标签，如果<input>
//    // 。value可以获取一个元素节点的value属性值
//    var userName = document.getElementById("username").value;
//
//    // 1.创建XMLHttpRequest对象
//    // 这是XMLHttpReuquest对象无部使用中最复杂的一步
//    // 需要针对IE和其他类型的浏览器建立这个对象的不同方式写不同的代码
//
//    if (window.XMLHttpRequest) {
//        // 针对FireFox，Mozillar，Opera，Safari，IE7，IE8
//        xmlhttp = new XMLHttpRequest();
//        // 针对某些特定版本的mozillar浏览器的BUG进行修正
//        if (xmlhttp.overrideMimeType) {
//            xmlhttp.overrideMimeType("text/xml");
//        }
//    } else if (window.ActiveXObject) {
//         // 针对IE6，IE5.5，IE5
//        // 两个可以用于创建XMLHTTPRequest对象的控件名称，保存在一个js的数组中
//        // 排在前面的版本较新
//        var activexName = ["MSXML2.XMLHTTP","Microsoft.XMLHTTP"];
//        for (var i = 0; i < activexName.length; i++) {
//            try{
//                // 取出一个控件名进行创建，如果创建成功就终止循环
//                // 如果创建失败，回抛出异常，然后可以继续循环，继续尝试创建
//                xmlhttp = new ActiveXObject(activexName[i]);
//                break;
//            } catch(e){
//            }
//        }
//    }
//    // 确认XMLHTtpRequest对象创建成功
//    if (!xmlhttp) {
//        alert("XMLHttpRequest对象创建失败!!");
//        return;
//    }
//// else {
//// alert("hello");
//// alert(xmlhttp.readyState);
//// }
//
//    // 2.注册回调函数
//    // 注册回调函数时，之需要函数名，不要加括号
//    // 我们需要将函数名注册，如果加上括号，就会把函数的返回值注册上，这是错误的
//    xmlhttp.onreadystatechange = callback;
//
//    // 3。设置连接信息
//    // 第一个参数表示http的请求方式，支持所有http的请求方式，主要使用get和post
//    // 第二个参数表示请求的url地址，get方式请求的参数也在url中
//    // 第三个参数表示采用异步还是同步方式交互，true表示异步
//    xmlhttp.open("GET","register.do?username="+ userName,true);
//
//// //POST方式请求的代码
//// xmlhttp.open("POST","register.do",true);
//// //POST方式需要自己设置http的请求头
//// xmlhttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
//// //POST方式发送数据
//// xmlhttp.send("username=" + userName);
////
//// //4.发送数据，开始和服务器端进行交互
//// //同步方式下，send这句话会在服务器段数据回来后才执行完
//// //异步方式下，send这句话会立即完成执行
//    xmlhttp.send(null);
//}
//
//// 回调函数
//function callback() {
//    // alert(xmlhttp.readyState);
//    // 5。接收响应数据
//    // 判断对象的状态是交互完成
//    if (xmlhttp.readyState == 4) {
//        // 判断http的交互是否成功
//        if (xmlhttp.status == 200) {
//// alert("rigth");
//            // 获取服务漆器端返回的数据
//            // 获取服务器段输出的纯文本数据
//            var responseText = xmlhttp.responseText;
//// alert(responseText);
//            // 将数据显示在页面上
//            // 通过dom的方式找到div标签所对应的元素节点
//            var divNode = document.getElementById("checkusernameinfo");
//            // 设置元素节点中的html内容
//// divNode.innerHTML = responseText;
//        } 
//        else {
//            alert("HELLO ,ERROR");
//        }
//    }
//}




// 创建一个XMLHttpRequest对象
function createXMLHttpRequest(){ 
  if(window.XMLHttpRequest){ // Mozilla
   XMLHttpReq=new XMLHttpRequest(); 
   } 
   else if(window.ActiveXObject){ 
    try{ 
     XMLHttpReq=new ActiveXObject("MSXML2.XMLHTTP"); 
     }catch(e){ 
      try{ 
       XMLHttpReq=new ActiveXObject("Microsoft.XMLHTTP"); 
       }catch(e){} 
       } 
      } 
     } 
// 发送请求函数
function send(url){ 
 createXMLHttpRequest(); 
 XMLHttpReq.open("get",url,true); 
 XMLHttpReq.onreadystatechange=proce;   // 指定响应的函数
 XMLHttpReq.send(null);  // 发送请求
 } 
function proce(){ 

if(XMLHttpReq.readyState==4){ // 对象状态
  if(XMLHttpReq.status==200){// 信息已成功返回，开始处理信息
// <!--测试读取xml开始-->
//	  alert("sdaljfj");	
  var root=XMLHttpReq.responseXML; 
  var res=root.getElementsByTagName("content")[0].firstChild.data; 
  var test=root.getElementsByTagName("test")[0].firstChild.data; 
  window.alert(res); 
  window.alert("test："+test); 
   <!--测试读取xml结束-->   
  // var xmlReturn = XMLHttpReq.responseText;
  // window.alert(xmlReturn);
  }else{ 
   window.alert("error"); 
   } 
   } 
   } 
// 身份验证
// function check(){
// var name=document.getElementById("name").value;
//  
// if(name==""){
// alert("请输入姓名!");
// return false;
// }
// else{
// //send('login?name='+name);
// document.getElementById("load").style.display='';
// send('loginAction.do?name='+name);
// document.getElementById("load").style.display='none';
// }
// }

