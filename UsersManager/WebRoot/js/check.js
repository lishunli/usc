//�û�����⣬����Ϊ�գ�������6��12֮��
var submitflag1 = 1;
var submitflag2 = 1;
var submitflag3 = 1;
var submitflag4 = 1;
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
	else if(submitflag1 == 1)
	{
		verify();
	}
	else
		submitflag1 = 1;

//		submitflag1 =1;
// verify();
//	alert(username);
//	send("register.do?name="+username); ]
	
//	alert(submitflag1);
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
function checkverifycode() {
	var verifycode = document.getElementById("verifycode").value;// dom���repassword
	var checkverifycodeinfo = $("#checkverifycodeinfo");// jquery���checkverifycodeinfo�ڵ�
	if("" == verifycode)
		checkverifycodeinfo.html("verifycode is required");
	else
		verify2();
	initsubmit();
}

// �ύ֮ǰ�ļ�飬Ҳ���ǰ�����������еļ��
function check() {
	checkusername();
	checkpassword();
	checkrepassword();
	checkverifycode();
}

// ɾ���������˵Ŀո�
function trim(str) {
	return str.replace(/(^\s*)|(\s*$)/g, "");
}
// �����ύ��ť�Ŀ�����
function initsubmit() {
	if(submitflag1 == 0 || submitflag2 == 0 || submitflag3 == 0 || submitflag3 == 0 || submitflag4 == 0 )
		document.getElementById("submit").disabled = true;// �����ύ��ť������
	else
		document.getElementById("submit").disabled = false;// �����ύ��ť����
}

function cleanusernameerror() {
// var checkusernameinfo = $("#checkusernameinfo");//jquery���checkusernameinfo�ڵ�
	$("#checkusernameinfo").html("");// ��ʼ��span
	$("#username").select();
	submitflag1 = 1;
//	alert(submitflag1);
	
}

function cleanpassworderror(){
// alert("clean");
// var checkpasswordinfo = $("#checkpasswordinfo");//jquery���checkusernameinfo�ڵ�
	$("#checkpasswordinfo").html("");// ��ʼ��span
	$("#password").select();
	submitflag2 = 1;
	
}

function cleanrepassworderror() {
// var checkrepasswordinfo =
// $("#checkrepasswordinfo");//jquery���checkusernameinfo�ڵ�
	$("#checkrepasswordinfo").html("");// ��ʼ��span
	$("#repassword").select();
	submitflag3 = 1;
	
}

function cleanverifyerror() {
		$("#checkverifycodeinfo").html("");// ��ʼ��span
		$("#verifycode").select();
		submitflag4 = 1;
	}

//�����û���У��ķ���
function verify(){
    //���Ȳ���һ��ҳ��İ�ť���£����Ե����������
    //ʹ��javascript��alert��������ʾһ��̽����ʾ��
    //alert("��ť������ˣ�����");

    //1.��ȡ�ı����е�����
    //document.getElementById("userName");  dom�ķ�ʽ
    //Jquery�Ĳ��ҽڵ�ķ�ʽ��������#����id����ֵ�����ҵ�һ���ڵ㡣
    //jquery�ķ������صĶ���jquery�Ķ��󣬿��Լ���������ִ��������jquery����
    var jqueryObj = $("#username");
    //��ȡ�ڵ��ֵ
    var userName = jqueryObj.val();
//    alert(userName);

    //2.���ı����е����ݷ��͸��������ε�servelt
    //ʹ��jquery��XMLHTTPrequest����get����ķ�װ
//    $.get("CheckUser?name=" + userName,null,callback);
//    $.get("register.do?name=" + userName,null,callback);
    
    $.ajax({
        type: "POST",            //http����ʽ
        url: "CheckUser",    //��������url��ַ
        data: "name=" + userName,           //���͸��������ε�����
        dataType: "xml",  //����JQuery���ص����ݸ�ʽ
        success: callback  //���彻����ɣ����ҷ�������ȷ��������ʱ���õĻص�����
    });


}

//�ص�����
function callback(data) {
//    alert("�������ε����ݻ����ˣ���");
    //3.���շ������˷��ص�����
//    alert(data);
    //4.���������η��ص����ݶ�̬����ʾ��ҳ����
    //�ҵ���������Ϣ�Ľڵ�
	var jqueryObj = $(data);
    var checkusernameinfo = $("#checkusernameinfo");
//    var checkverifycodeinfo = $("#checkverifycodeinfo");
    //��̬�ĸı�ҳ����div�ڵ��е�����
    if(jqueryObj.children("message").children("usernamemes").text() == "username exist,please change username")
    {
//    	resultObj.html(jqueryObj.children().children("verifycodemes"));
//    checkverifycodeinfo.html(jqueryObj.children("message").children("verifycodemes").text());
    	
    	submitflag1 =0;
//    	alert(submitflag1);
//    	checkusernameinfo.html(jqueryObj.children("message").children("usernamemes").text());
    	
    }
    else 
    {
    	submitflag1 = 1;
//    	alert(submitflag1);
    }
    initsubmit();
//    alert(jqueryObj.children("message").children("usernamemes").text());
    checkusernameinfo.html(jqueryObj.children("message").children("usernamemes").text());
//    submitflag1 =1;
//    alert(submitflag1);
    	
}


function verify2(){
//	alert("dd");
    //���Ȳ���һ��ҳ��İ�ť���£����Ե����������
    //ʹ��javascript��alert��������ʾһ��̽����ʾ��
    //alert("��ť������ˣ�����");

    //1.��ȡ�ı����е�����
    //document.getElementById("userName");  dom�ķ�ʽ
    //Jquery�Ĳ��ҽڵ�ķ�ʽ��������#����id����ֵ�����ҵ�һ���ڵ㡣
    //jquery�ķ������صĶ���jquery�Ķ��󣬿��Լ���������ִ��������jquery����
    //��ȡ�ڵ��ֵ
	var jqueryObj = $("#username");
    //��ȡ�ڵ��ֵ
    var userName = jqueryObj.val();
    var verifyCode =$("#verifycode").val();
//    alert(verifyCode);

    //2.���ı����е����ݷ��͸��������ε�servelt
    //ʹ��jquery��XMLHTTPrequest����get����ķ�װ
//    $.get("CheckUser?name=" + userName,null,callback);
//    $.get("register.do?name=" + userName,null,callback);
    
    $.ajax({
        type: "POST",            //http����ʽ
        url: "CheckUser",    //��������url��ַ
//        data: "name=" + userName&"verify=" +verifyCode,           //���͸��������ε�����
//        data: {"name" : userName , "verify" : verifyCode},           //���͸��������ε�����
        data: {"verify" : verifyCode},           //���͸��������ε�����
        dataType: "xml",  //����JQuery���ص����ݸ�ʽ
        success: callback2  //���彻����ɣ����ҷ�������ȷ��������ʱ���õĻص�����
    });


}

//�ص�����
function callback2(data) {
//    alert("�������ε����ݻ����ˣ���");
    //3.���շ������˷��ص�����
//    alert(data);
    //4.���������η��ص����ݶ�̬����ʾ��ҳ����
    //�ҵ���������Ϣ�Ľڵ�
	var jqueryObj = $(data);
//    var checkusernameinfo = $("#checkusernameinfo");
    var checkverifycodeinfo = $("#checkverifycodeinfo");
    var verifycodemes = jqueryObj.children("message").children("verifycodemes").text();
    //��̬�ĸı�ҳ����div�ڵ��е�����
    if(verifycodemes == "verifycode is error")
    	submitflag4 = 0;
    else
    	submitflag4 =1;
//    	resultObj.html(jqueryObj.children().children("verifycodemes"));
    checkverifycodeinfo.html(verifycodemes);
//    checkverifycodeinfo.html(data);
//    checkusernameinfo.html(jqueryObj.children("message").children("usernamemes").text());
    initsubmit();
}

