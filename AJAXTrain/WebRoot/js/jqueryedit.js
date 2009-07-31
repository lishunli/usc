//在页面装载的时候让所有的td都拥有一个点击事件
$(document).ready( function() {
	// 找到所有的td节点
		var tds = $("td");
		// 给所有的td节点增加点击事件
		tds.click(tdclick);
	});

// td被点击的事件
function tdclick() {
	// var clickfunction = this;
	// 0.保存當前的td節點
	var td = $(this);
	// 1.取出当前td中的文本内容保存出来
	var text = td.text();
	// 2.清空td中的内容
	td.html("");// 也可以用td.empty();
	// 3.建立一个文本框，也就是input
	var input = $("<input>");
	// 4.设置文本框中的值为保存td的值
	input.attr("value", text);
	// 4.5让文本框可以响应键盘按下Enter事件(按下，弹出)
	input.keyup( function(event) {
		// 4.5.0获取当前用户按下的键值
			// 解决不同浏览器获取时间对象的差异
			var myEvent = event || window.event;
			var kcode = myEvent.keyCode;
			// 4.5.1判断是否是回车键
			if (kcode == 13) {
				var inputnode = $(this);
				// 4.5.2获取当前文本框的内容
				var inputtext = inputnode.val();
				// 4.5.3清空td里面的内容
				var tdNode = inputnode.parent();
				tdNode.html(inputtext);

				// 4.5.4保存文本框的内容填充到td中
				// 4.5.5让td重新拥有点击事件
				tdNode.click(tdclick);
			}

		});
	// 5.将文本框加入到td中
	td.append(input);// 也可以使用input.appendTo(td);

	// 5.5让文本框里面的文字被选中后高亮
	// 需要把jquery的对象转换成dom对象
	var inputdom = input.get(0);
	inputdom.select();
	// 6.需要清除td上的点击事件
	td.unbind("click");
}
