//��Ҫ������˵��İ�ťʱ����Ӧ���Ӳ˵�������ʾ���ٴε���Ӳ˵�������

//��Ҫ��д���룬��ҳ��װ�ص�ʱ�򣬾͸����е����˵����onclickʱ�䣬
//��֤���˵����ʱ������ʾ���������Ӳ˵�

//ע��ҳ��װ��ʱִ�еķ���
$(document).ready(function () {
//	������Ҫ�����ҵ����е����˵�
//	Ȼ������е����˵�ע�����¼�
//	�ҵ�ul�е�a�ڵ㣬����һ
//	var as = $("ul").children("a");
//	������
	var as = $("ul > a");
	as.click(function () {
//		������Ҫ�ҵ���ǰul�е�li��Ȼ����ʾ����
//		��ȡ��ǰ�������ul�ڵ�
		var aNode = $(this);
//		�ҵ���ǰul�ڵ������li�ӽڵ㣬��Ӧ����һ
//		var lis = ulNode.children("li");
//		�ҵ���ǰul�ڵ������li�ӽڵ㣬��Ӧ������
		var lis = aNode.nextAll("li");
//		���Ӳ˵���ʾ������
//		lis.toggle("slow");
		lis.toggle();
		$("li > a").click(function () {
			$("#content").load($(this).attr("id"));
		});
	});
});
