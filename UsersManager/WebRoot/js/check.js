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
//	send("register.do?name="+username); ]
	verify();
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
    //alert(userName);

    //2.���ı����е����ݷ��͸��������ε�servelt
    //ʹ��jquery��XMLHTTPrequest����get����ķ�װ
    $.get("CheckUser?name=" + userName,null,callback);
//    $.get("register.do?name=" + userName,null,callback);


}

//�ص�����
function callback(data) {
//    alert("�������ε����ݻ����ˣ���");
    //3.���շ������˷��ص�����
//    alert(data);
    //4.���������η��ص����ݶ�̬����ʾ��ҳ����
    //�ҵ���������Ϣ�Ľڵ�
    var resultObj = $("#checkusernameinfo");
    //��̬�ĸı�ҳ����div�ڵ��е�����
//    if(data == "username exist,please change username\r\n")
    	resultObj.html(data);
}
