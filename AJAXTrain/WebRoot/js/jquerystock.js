//��������ҳ���Ϳ��Կ�ʼ�ӷ������˻�ȡ���ݣ�Ȼ����ʾ��Ʊ�۸�
//�������˴��ص�����
var obj;
var sid;
$(document).ready( function() {
	// ҳ������ʱ���ص�����
		var stockNode = $("#stock").css("border", "1.5px solid black").css(
				"width", "150px").css("position", "absolute").css("z-index",
				"99");
		$("#stock").hide();
		var as = $("a");
		// �������Ʊ�����ӵ�ʱ��
		as.mouseover( function(event) {
			var aNode = $(this);// ��ȡ��ǰ�ڵ�
				var divNode = aNode.parent();
				sid = divNode.attr("id");
				updatediv();
				// // ��Ҫ���Ƶ������λ��
				// // 1.��Ҫ�ҵ���ǰ���ӵ�λ��
				// var offset = aNode.offset();
				// // 2.���õ������λ��
				// stockNode.css("left", offset.left + 150 + "px").css("top",
				// offset.top + aNode.height() + "px");
				// �����������λ��Ϊ�������·�
				var myEvent = event || window.event;
				stockNode.css("left", myEvent.clientX + 5 + "px").css("top",
						myEvent.clientY + 5 + "px");
				// ��������ʾ
				stockNode.show();
			});
		// ����뿪��Ʊ�����ӵ�ʱ��
		as.mouseout( function() {
			stockNode.hide();
		});

		getInfo();
		// 3.ÿ��һ���Ӻͷ���������һ�Σ��û�����ˢ��ҳ��Ϳ��Բ��ϵؿ������¹�Ʊ��Ϣ
		setInterval(getInfo, 1000);
	});
// �ӷ���ǰ�˻�ȡ��ǰ��Ʊ��Ϣ
function getInfo() {
	// 1.��������������󣬻�ȡ���ݿ�
	$.get("GetStockInfo", null, function(data) {
		// 2.���ܲ���������
			// obj = eval(data);
			obj = eval(data);// ֱ�ӽ���Ϊ������Ҫ�������"json"����
			// 2.1��ȡ��ֻ��Ʊ�ĵ�ǰָ����Ϣ
			var szzs = obj["300001"];
			var pfyh = obj["000001"];
			// // ����һ��Javascript����
			// for(var stockid in obj)
			// {
			// var stock = obj[stockid];
			// }
			// 2.2�ҵ�ҳ���еĶ�Ӧ�Ľڵ㣬Ȼ��������µĹ�Ʊ�۸�
			var span1 = $("#300001").children("span").html(szzs.now);
			if (szzs.now > szzs.yes) {
				// ��ǰ�۸������������̣�����ʾ��ɫ
				span1.css("color", "red");
			} else {
				span1.css("color", "green");
			}

			var span2 = $("#000001").children("span").html(pfyh.now);
			if (pfyh.now > pfyh.yes) {
				// ��ǰ�۸������������̣�����ʾ��ɫ
				span2.css("color", "red");
			} else {
				span2.css("color", "green");
			}
			updatediv();

		}, "json");
}
// ���µ������е�����
function updatediv() {
	// �ҵ���Ӧ�Ĺ�Ʊ����
	var stockobj = obj[sid];
	for ( var proname in stockobj) {
		if (proname != "name") {
			// �ҵ���Ӧ��div�ڵ㲢�ҵ�span�ӽڵ㲢�������
			if (proname != "now") {
				$("#" + proname).children("span").html(stockobj[proname]);
			} else if (stockobj[proname] > stockobj.yes)
				$("#" + proname).children("span").html(stockobj[proname]).css(
						"color", "red");
			else
				$("#" + proname).children("span").html(stockobj[proname]).css(
						"color", "green");
		}

	}
}
// alert(stockobj[yes]);
// $("#yes").children("span").html(stockobj[yes]);
// $("#tod").children("span").html(stockobj[tod]);
// $("#now").children("span").html(stockobj[now]);
