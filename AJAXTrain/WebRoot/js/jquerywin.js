function showwin() {
//	alert("hello 中");
//	1.找到窗口对应的div节点
	var windNode = $("#win");
//	2.让div对应的窗口显示出来
//	方法1.修改节点的css值，让窗口显示出来
//	windNode.css("display","block");
	
//	方法2.利用JQuery的show方法
//	windNode.show("slow");
//	or
//	windNode.show("2000");
	
//	方法3.利用JQuery的fadeIn的方法
	windNode.fadeIn("slow");
	
}
function hide() {
//	1.找到关闭窗口的节点
	var windNode = $("#win");
//	2.讲窗口隐藏起来
//	方法1.修改css
//	windNode.css("display","none");
//	方法2.利用hide方法
//	windNode.hide("slow");
//	方法3.利用fadeOut进行淡出处理
	windNode.fadeOut("slow");
}