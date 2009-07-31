//期望进入页面后就可以开始从服务器端获取数据，然后显示股票价格
//保存服务端传回的数据
var obj;
var sid;
$(document).ready( function() {
	// 页面载入时隐藏弹出框
		var stockNode = $("#stock").css("border", "1.5px solid black").css(
				"width", "150px").css("position", "absolute").css("z-index",
				"99");
		$("#stock").hide();
		var as = $("a");
		// 鼠标进入股票超链接的时候
		as.mouseover( function(event) {
			var aNode = $(this);// 获取当前节点
				var divNode = aNode.parent();
				sid = divNode.attr("id");
				updatediv();
				// // 需要控制弹出框的位置
				// // 1.需要找到当前连接的位置
				// var offset = aNode.offset();
				// // 2.设置弹出框的位置
				// stockNode.css("left", offset.left + 150 + "px").css("top",
				// offset.top + aNode.height() + "px");
				// 期望弹出框的位置为鼠标的右下方
				var myEvent = event || window.event;
				stockNode.css("left", myEvent.clientX + 5 + "px").css("top",
						myEvent.clientY + 5 + "px");
				// 弹出框显示
				stockNode.show();
			});
		// 鼠标离开股票超链接的时候
		as.mouseout( function() {
			stockNode.hide();
		});

		getInfo();
		// 3.每隔一秒钟和服务器交互一次，用户不用刷新页面就可以不断地看到最新股票信息
		setInterval(getInfo, 1000);
	});
// 从服务前端获取当前股票信息
function getInfo() {
	// 1.向服务器发起请求，获取数据库
	$.get("GetStockInfo", null, function(data) {
		// 2.接受并解析数据
			// obj = eval(data);
			obj = eval(data);// 直接解析为对象，需要后面加上"json"参数
			// 2.1获取两只股票的当前指数信息
			var szzs = obj["300001"];
			var pfyh = obj["000001"];
			// // 遍历一个Javascript对象
			// for(var stockid in obj)
			// {
			// var stock = obj[stockid];
			// }
			// 2.2找到页面中的对应的节点，然后填充最新的股票价格
			var span1 = $("#300001").children("span").html(szzs.now);
			if (szzs.now > szzs.yes) {
				// 当前价格大于昨天的收盘，则显示红色
				span1.css("color", "red");
			} else {
				span1.css("color", "green");
			}

			var span2 = $("#000001").children("span").html(pfyh.now);
			if (pfyh.now > pfyh.yes) {
				// 当前价格大于昨天的收盘，则显示红色
				span2.css("color", "red");
			} else {
				span2.css("color", "green");
			}
			updatediv();

		}, "json");
}
// 更新弹出框中的内容
function updatediv() {
	// 找到相应的股票对象
	var stockobj = obj[sid];
	for ( var proname in stockobj) {
		if (proname != "name") {
			// 找到相应的div节点并找到span子节点并填充数据
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
