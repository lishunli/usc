//��ҳ��װ�ص�ʱ�������е�td��ӵ��һ������¼�
$(document).ready( function() {
	// �ҵ����е�td�ڵ�
		var tds = $("td");
		// �����е�td�ڵ����ӵ���¼�
		tds.click(tdclick);
	});

// td��������¼�
function tdclick() {
	// var clickfunction = this;
	// 0.���殔ǰ��td���c
	var td = $(this);
	// 1.ȡ����ǰtd�е��ı����ݱ������
	var text = td.text();
	// 2.���td�е�����
	td.html("");// Ҳ������td.empty();
	// 3.����һ���ı���Ҳ����input
	var input = $("<input>");
	// 4.�����ı����е�ֵΪ����td��ֵ
	input.attr("value", text);
	// 4.5���ı��������Ӧ���̰���Enter�¼�(���£�����)
	input.keyup( function(event) {
		// 4.5.0��ȡ��ǰ�û����µļ�ֵ
			// �����ͬ�������ȡʱ�����Ĳ���
			var myEvent = event || window.event;
			var kcode = myEvent.keyCode;
			// 4.5.1�ж��Ƿ��ǻس���
			if (kcode == 13) {
				var inputnode = $(this);
				// 4.5.2��ȡ��ǰ�ı��������
				var inputtext = inputnode.val();
				// 4.5.3���td���������
				var tdNode = inputnode.parent();
				tdNode.html(inputtext);

				// 4.5.4�����ı����������䵽td��
				// 4.5.5��td����ӵ�е���¼�
				tdNode.click(tdclick);
			}

		});
	// 5.���ı�����뵽td��
	td.append(input);// Ҳ����ʹ��input.appendTo(td);

	// 5.5���ı�����������ֱ�ѡ�к����
	// ��Ҫ��jquery�Ķ���ת����dom����
	var inputdom = input.get(0);
	inputdom.select();
	// 6.��Ҫ���td�ϵĵ���¼�
	td.unbind("click");
}
