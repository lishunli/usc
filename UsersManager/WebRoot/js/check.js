//�û�����⣬����Ϊ�գ�������6��12֮��
var submitflag1 = 1;
var submitflag2 = 1;
var submitflag3 = 1;
var into = 0;
var XMLHttpReq=false; 
function checkusername() {
	
	var username = document.getElementById("username").value;// dom���username
	var checkusernameinfo = $("#checkusernameinfo");// jquery���checkusernameinfo�ڵ�
	checkusernameinfo.html("");// ��ʼ��span
	if ("" == trim(username)) // Ϊ��
	{
// alert("username is required");
		checkusernameinfo.html("username is required");// span�����ʾ��Ϣ
		submitflag1 =0;
// document.getElementById("submit").disabled = true;//�����ύ��ť������
	}
	else if(trim(username).length > 12  || trim(username).length < 5)// ���� 5-
																		// 12
	{
// alert("username length must between 6 in 12");
		checkusernameinfo.html("username length must between 5  in 12");// span�����ʾ��Ϣ
// document.getElementById("submit").disabled = true;//�����ύ��ť������
		submitflag1 =0;
	}
	else 
		submitflag1 =1;
// verify();
//	alert(username);
	send("register.do?name="+username); 
	initsubmit();
	
}

// �����⣬����Ϊ��
function checkpassword() {
	var password = document.getElementById("password").value;// dom���password
	var checkpasswordinfo = $("#checkpasswordinfo");// jquery���checkpasswordinfo�ڵ�
	checkpasswordinfo.html("");// ��ʼ��span
	if ("" == trim(password)) // Ϊ��
	{
// alert("username is required");
		checkpasswordinfo.html("password is required");// span�����ʾ��Ϣ
		submitflag2 =0;
// document.getElementById("submit").disabled = true;//�����ύ��ť������
	}
	else 
		submitflag2 =1;
	if(into)
		checkrepassword();
	initsubmit();
}

// �ظ������⣬����Ϊ�գ�Ҳ������ͬ
function checkrepassword() {
	var repassword = document.getElementById("repassword").value;// dom���repassword
	var checkrepasswordinfo = $("#checkrepasswordinfo");// jquery���checkrepasswordinfo�ڵ�
	checkrepasswordinfo.html("");// ��ʼ��span
	if ("" == repassword) // Ϊ��
	{
// alert("username is required");
		checkrepasswordinfo.html("repassword is required");// span�����ʾ��Ϣ
// document.getElementById("submit").disabled = true;//�����ύ��ť������
		submitflag3 =0;
	}
	else if(repassword != trim(document.getElementById("password").value))// ������ظ����벻��ͬ
	{
// alert("username length must between 6 in 12");
		checkrepasswordinfo.html("password not equal repassword");// span�����ʾ��Ϣ
// document.getElementById("submit").disabled = true;//�����ύ��ť������
		submitflag3 =0;
	}
	else
		submitflag3 =1;
	into = 1;
	initsubmit();
}

// �ύ֮ǰ�ļ�飬Ҳ���ǰ�����������еļ��
function check() {
	checkusername();
	checkpassword();
	checkrepassword();
}

// ɾ���������˵Ŀո�
function trim(str) {
	return str.replace(/(^\s*)|(\s*$)/g, "");
}
// �����ύ��ť�Ŀ�����
function initsubmit() {
	if(submitflag1 == 0 || submitflag2 == 0 || submitflag3 == 0)
		document.getElementById("submit").disabled = true;// �����ύ��ť������
	else
		document.getElementById("submit").disabled = false;// �����ύ��ť����
}

function cleanusernameerror() {
// var checkusernameinfo = $("#checkusernameinfo");//jquery���checkusernameinfo�ڵ�
	$("#checkusernameinfo").html("");// ��ʼ��span
	$("#username").select();
}

function cleanpassworderror(){
// alert("clean");
// var checkpasswordinfo = $("#checkpasswordinfo");//jquery���checkusernameinfo�ڵ�
	$("#checkpasswordinfo").html("");// ��ʼ��span
	$("#password").select();
}

function cleanrepassworderror() {
// var checkrepasswordinfo =
// $("#checkrepasswordinfo");//jquery���checkusernameinfo�ڵ�
	$("#checkrepasswordinfo").html("");// ��ʼ��span
	$("#repassword").select();
}

//function verify() {
//    // 0��ʹ��dom�ķ�ʽ��ȡ�ı����е�ֵ
//    // document.getElementById("userName")��dom�л�ȡԪ�ؽڵ��һ�ַ�����һ��Ԫ�ؽڵ��ӦHTMLҳ���е�һ����ǩ�����<input>
//    // ��value���Ի�ȡһ��Ԫ�ؽڵ��value����ֵ
//    var userName = document.getElementById("username").value;
//
//    // 1.����XMLHttpRequest����
//    // ����XMLHttpReuquest�����޲�ʹ������ӵ�һ��
//    // ��Ҫ���IE���������͵�����������������Ĳ�ͬ��ʽд��ͬ�Ĵ���
//
//    if (window.XMLHttpRequest) {
//        // ���FireFox��Mozillar��Opera��Safari��IE7��IE8
//        xmlhttp = new XMLHttpRequest();
//        // ���ĳЩ�ض��汾��mozillar�������BUG��������
//        if (xmlhttp.overrideMimeType) {
//            xmlhttp.overrideMimeType("text/xml");
//        }
//    } else if (window.ActiveXObject) {
//         // ���IE6��IE5.5��IE5
//        // �����������ڴ���XMLHTTPRequest����Ŀؼ����ƣ�������һ��js��������
//        // ����ǰ��İ汾����
//        var activexName = ["MSXML2.XMLHTTP","Microsoft.XMLHTTP"];
//        for (var i = 0; i < activexName.length; i++) {
//            try{
//                // ȡ��һ���ؼ������д�������������ɹ�����ֹѭ��
//                // �������ʧ�ܣ����׳��쳣��Ȼ����Լ���ѭ�����������Դ���
//                xmlhttp = new ActiveXObject(activexName[i]);
//                break;
//            } catch(e){
//            }
//        }
//    }
//    // ȷ��XMLHTtpRequest���󴴽��ɹ�
//    if (!xmlhttp) {
//        alert("XMLHttpRequest���󴴽�ʧ��!!");
//        return;
//    }
//// else {
//// alert("hello");
//// alert(xmlhttp.readyState);
//// }
//
//    // 2.ע��ص�����
//    // ע��ص�����ʱ��֮��Ҫ����������Ҫ������
//    // ������Ҫ��������ע�ᣬ����������ţ��ͻ�Ѻ����ķ���ֵע���ϣ����Ǵ����
//    xmlhttp.onreadystatechange = callback;
//
//    // 3������������Ϣ
//    // ��һ��������ʾhttp������ʽ��֧������http������ʽ����Ҫʹ��get��post
//    // �ڶ���������ʾ�����url��ַ��get��ʽ����Ĳ���Ҳ��url��
//    // ������������ʾ�����첽����ͬ����ʽ������true��ʾ�첽
//    xmlhttp.open("GET","register.do?username="+ userName,true);
//
//// //POST��ʽ����Ĵ���
//// xmlhttp.open("POST","register.do",true);
//// //POST��ʽ��Ҫ�Լ�����http������ͷ
//// xmlhttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
//// //POST��ʽ��������
//// xmlhttp.send("username=" + userName);
////
//// //4.�������ݣ���ʼ�ͷ������˽��н���
//// //ͬ����ʽ�£�send��仰���ڷ����������ݻ������ִ����
//// //�첽��ʽ�£�send��仰���������ִ��
//    xmlhttp.send(null);
//}
//
//// �ص�����
//function callback() {
//    // alert(xmlhttp.readyState);
//    // 5��������Ӧ����
//    // �ж϶����״̬�ǽ������
//    if (xmlhttp.readyState == 4) {
//        // �ж�http�Ľ����Ƿ�ɹ�
//        if (xmlhttp.status == 200) {
//// alert("rigth");
//            // ��ȡ���������˷��ص�����
//            // ��ȡ������������Ĵ��ı�����
//            var responseText = xmlhttp.responseText;
//// alert(responseText);
//            // ��������ʾ��ҳ����
//            // ͨ��dom�ķ�ʽ�ҵ�div��ǩ����Ӧ��Ԫ�ؽڵ�
//            var divNode = document.getElementById("checkusernameinfo");
//            // ����Ԫ�ؽڵ��е�html����
//// divNode.innerHTML = responseText;
//        } 
//        else {
//            alert("HELLO ,ERROR");
//        }
//    }
//}




// ����һ��XMLHttpRequest����
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
// ����������
function send(url){ 
 createXMLHttpRequest(); 
 XMLHttpReq.open("get",url,true); 
 XMLHttpReq.onreadystatechange=proce;   // ָ����Ӧ�ĺ���
 XMLHttpReq.send(null);  // ��������
 } 
function proce(){ 

if(XMLHttpReq.readyState==4){ // ����״̬
  if(XMLHttpReq.status==200){// ��Ϣ�ѳɹ����أ���ʼ������Ϣ
// <!--���Զ�ȡxml��ʼ-->
//	  alert("sdaljfj");	
  var root=XMLHttpReq.responseXML; 
  var res=root.getElementsByTagName("content")[0].firstChild.data; 
  var test=root.getElementsByTagName("test")[0].firstChild.data; 
  window.alert(res); 
  window.alert("test��"+test); 
   <!--���Զ�ȡxml����-->   
  // var xmlReturn = XMLHttpReq.responseText;
  // window.alert(xmlReturn);
  }else{ 
   window.alert("error"); 
   } 
   } 
   } 
// �����֤
// function check(){
// var name=document.getElementById("name").value;
//  
// if(name==""){
// alert("����������!");
// return false;
// }
// else{
// //send('login?name='+name);
// document.getElementById("load").style.display='';
// send('loginAction.do?name='+name);
// document.getElementById("load").style.display='none';
// }
// }

