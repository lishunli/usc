//�û�����⣬����Ϊ�գ�������6��12֮��
var submitflag1 = 1;
var submitflag2 = 1;
var submitflag3 = 1;
var into = 0;

function checkusername() {
	
}

//�����⣬����Ϊ��
function checkpassword() {
//	var checkusernameinfo = $("#checkusernameinfo");//jquery���checkusernameinfo�ڵ�
//	checkusernameinfo.html("");//��ʼ��span
//	alert("init");
}

//�ظ������⣬����Ϊ�գ�Ҳ������ͬ
function checkrepassword() {
}

//�ύ֮ǰ�ļ�飬Ҳ���ǰ�����������еļ��
function check() {
	checkusername();
	checkpassword();
	checkrepassword();
}

//ɾ���������˵Ŀո�
function trim(str) {
	return str.replace(/(^\s*)|(\s*$)/g, "");
}
//�����ύ��ť�Ŀ�����
function initsubmit() {
	if(submitflag1 == 0 || submitflag2 == 0 || submitflag3 == 0)
		document.getElementById("submit").disabled = true;//�����ύ��ť������
	else
		document.getElementById("submit").disabled = false;//�����ύ��ť����
}
function cleanusernameerror() {
	var checkusernameinfo = $("#checkusernameinfo");//jquery���checkusernameinfo�ڵ�
	checkusernameinfo.html("");//��ʼ��span
}
