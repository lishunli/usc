
//����Ϊ���ü���ʱ���һЩ��־λ���������ô����ʱ��submit��ť��Ч
var usernameSubmitflag = 1;
var passwordSubmitflag = 1;
var repasswordSubmitflag = 1;
var verifycodeSubmitflag = 1;

var into = 0;//������ظ����������ʾȡ����־λ
//var XMLHttpReq=false; 

//�û�����⣬����Ϊ�գ�������6��12֮��
function checkusername() {
	
	var username = document.getElementById("username").value;// dom���username
	var checkusernameinfo = $("#checkusernameinfo");// jquery���checkusernameinfo�ڵ�
	checkusernameinfo.html("");// ��ʼ��span
	if ("" == trim(username)) // Ϊ��
	{
// alert("username is required");
		checkusernameinfo.html("username is required");// span�����ʾ��Ϣ
		usernameSubmitflag =0;
// document.getElementById("submit").disabled = true;//�����ύ��ť������
	}
	else if(trim(username).length > 12  || trim(username).length < 5)// ���� 5-
																		// 12
	{
// alert("username length must between 6 in 12");
		checkusernameinfo.html("username length must between 5  in 12");// span�����ʾ��Ϣ
// document.getElementById("submit").disabled = true;//�����ύ��ť������
		usernameSubmitflag =0;
	}
	else if(usernameSubmitflag == 1)
	{
		verifyusername();
	}
	else
		usernameSubmitflag = 1;

//		usernameSubmitflag =1;
// verify();
//	alert(username);
//	send("register.do?name="+username); ]
	
//	alert(usernameSubmitflag);
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
		passwordSubmitflag =0;
// document.getElementById("submit").disabled = true;//�����ύ��ť������
	}
	else 
		passwordSubmitflag =1;
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
		repasswordSubmitflag =0;
	}
	else if(repassword != trim(document.getElementById("password").value))// ������ظ����벻��ͬ
	{
// alert("username length must between 6 in 12");
		checkrepasswordinfo.html("password not equal repassword");// span�����ʾ��Ϣ
// document.getElementById("submit").disabled = true;//�����ύ��ť������
		repasswordSubmitflag =0;
	}
	else
		repasswordSubmitflag =1;
	into = 1;
	initsubmit();
}
//�����֤���Ƿ���ȷ
function checkverifycode() {
	var verifycode = document.getElementById("verifycode").value;// dom���verifycode
	var checkverifycodeinfo = $("#checkverifycodeinfo");// jquery���checkverifycodeinfo�ڵ�
	if("" == verifycode)
		checkverifycodeinfo.html("verifycode is required");//Ϊ��
	else
		codeverify();//��ȷ���ж�
	initsubmit();
}

// �ύ֮ǰ�ļ�飬Ҳ���ǰ�����������еļ��,��ֹ����û������ֱ���ύ�������
function check() {
	checkusername();
	checkpassword();
	checkrepassword();
	checkverifycode();
}


//����Ķ��ǽ���һЩ��ʼ��������մ��󣬸���ȫ���������ύ��־λ
function cleanusernameerror() {
// var checkusernameinfo = $("#checkusernameinfo");//jquery���checkusernameinfo�ڵ�
	$("#checkusernameinfo").html("");// ��ʼ��span
	$("#username").select();
	usernameSubmitflag = 1;
//	alert(usernameSubmitflag);
	
}

function cleanpassworderror(){
// alert("clean");
// var checkpasswordinfo = $("#checkpasswordinfo");//jquery���checkusernameinfo�ڵ�
	$("#checkpasswordinfo").html("");// ��ʼ��span
	$("#password").select();
	passwordSubmitflag = 1;
	
}

function cleanrepassworderror() {
// var checkrepasswordinfo =
// $("#checkrepasswordinfo");//jquery���checkusernameinfo�ڵ�
	$("#checkrepasswordinfo").html("");// ��ʼ��span
	$("#repassword").select();
	repasswordSubmitflag = 1;
	
}

function cleanverifyerror() {
		$("#checkverifycodeinfo").html("");// ��ʼ��span
		$("#verifycode").select();
		verifycodeSubmitflag = 1;
	}

//�����û���У��ķ���
function verifyusername(){

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
        success: usernamecallback  //���彻����ɣ����ҷ�������ȷ��������ʱ���õĻص�����
    });


}

//�ص�����
function usernamecallback(data) {
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
    	
    	usernameSubmitflag =0;
//    	alert(usernameSubmitflag);
//    	checkusernameinfo.html(jqueryObj.children("message").children("usernamemes").text());
    	
    }
    else 
    {
    	usernameSubmitflag = 1;
//    	alert(usernameSubmitflag);
    }
    initsubmit();
//    alert(jqueryObj.children("message").children("usernamemes").text());
    checkusernameinfo.html(jqueryObj.children("message").children("usernamemes").text());
//    usernameSubmitflag =1;
//    alert(usernameSubmitflag);
    	
}


function codeverify(){
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
//        data: {"name" : userName , "verify" : verifyCode},           //���͸��������ε����ݣ�key��value�ԣ��ǿ��Ե�
        data: {"verify" : verifyCode},           //���͸��������ε�����
        dataType: "xml",  //����JQuery���ص����ݸ�ʽ
        success: codecallback  //���彻����ɣ����ҷ�������ȷ��������ʱ���õĻص�����
    });


}

//�ص�����
function codecallback(data) {
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
    	verifycodeSubmitflag = 0;
    else
    	verifycodeSubmitflag =1;
//    	resultObj.html(jqueryObj.children().children("verifycodemes"));
    checkverifycodeinfo.html(verifycodemes);
//    checkverifycodeinfo.html(data);
//    checkusernameinfo.html(jqueryObj.children("message").children("usernamemes").text());
    initsubmit();
}



//ɾ���������˵Ŀո�
function trim(str) {
	return str.replace(/(^\s*)|(\s*$)/g, "");
}

// �����ύ��ť�Ŀ�����
function initsubmit() {
	if(usernameSubmitflag == 0 || passwordSubmitflag == 0 || repasswordSubmitflag == 0 || repasswordSubmitflag == 0 || verifycodeSubmitflag == 0 )
		document.getElementById("submit").disabled = true;// �����ύ��ť������
	else
		document.getElementById("submit").disabled = false;// �����ύ��ť����
}