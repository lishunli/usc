function showwin() {
//	alert("hello ��");
//	1.�ҵ����ڶ�Ӧ��div�ڵ�
	var windNode = $("#win");
//	2.��div��Ӧ�Ĵ�����ʾ����
//	����1.�޸Ľڵ��cssֵ���ô�����ʾ����
//	windNode.css("display","block");
	
//	����2.����JQuery��show����
//	windNode.show("slow");
//	or
//	windNode.show("2000");
	
//	����3.����JQuery��fadeIn�ķ���
	windNode.fadeIn("slow");
	
}
function hide() {
//	1.�ҵ��رմ��ڵĽڵ�
	var windNode = $("#win");
//	2.��������������
//	����1.�޸�css
//	windNode.css("display","none");
//	����2.����hide����
//	windNode.hide("slow");
//	����3.����fadeOut���е�������
	windNode.fadeOut("slow");
}