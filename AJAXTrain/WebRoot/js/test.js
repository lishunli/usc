//��ҳ��װ��ʱ�������е�td��ӵ��һ������¼�
$(document).ready( function() {
	//�ҵ����е�td�ڵ�
		var tds = $("td");
		//�����е�td�ڵ����ӵ���¼�
		tds.click(tdclick);
	});

//td��������¼�
function tdclick() {
	//0.���浱ǰ��td�ڵ�
	var td = $(this);
	//1.ȡ����ǰtd�е��ı����ݱ�������
	var text = td.text();
	//2.���td���������
	td.html(""); //Ҳ������td.empty();
	//3.����һ���ı���Ҳ����input��Ԫ�ؽڵ�
	var input = $("<input>");
	//4.�����ı����ֵ�Ǳ����������ı�����
	input.attr("value", text);
	//4.5���ı��������Ӧ���̰��²�������¼�����Ҫ���ڴ���س�ȷ��
	input.keyup( function(event) {
		//0.��ȡ��ǰ�û����µļ�ֵ
			//�����ͬ�������ȡ�¼�����Ĳ���
			var myEvent = event || window.event;
			var kcode = myEvent.keyCode;
			//1.�ж��Ƿ��ǻس�����
			if (kcode == 13) {
				var inputnode = $(this);
				//2.���浱ǰ�ı��������
				var intputext = inputnode.val();
				//3.���td���������
				var tdNode = inputnode.parent();
				//4����������ı����������䵽td��
				tdNode.html(intputext);
				//5.��td����ӵ�е���¼�
				tdNode.click(tdclick);
			}
		});
	//5.���ı�����뵽td��
	td.append(input); //Ҳ������input.appendTo(td)

	//5.5���ı�����������ֱ�����ѡ��
	//��Ҫ��jquery�Ķ���ת����dom����

	//6.��Ҫ���td�ϵĵ���¼�
	td.unbind("click");
}