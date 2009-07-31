//需要点击主菜单的按钮时，对应的子菜单可以显示，再次点击子菜单则隐藏

//需要编写代码，在页面装载的时候，就给所有的主菜单添加onclick时间，
//保证主菜单点击时可以显示或者隐藏子菜单

//注册页面装载时执行的方法
$(document).ready(function () {
//	这里需要首先找到所有的主菜单
//	然后给所有的主菜单注册点击事件
//	找到ul中的a节点，方法一
//	var as = $("ul").children("a");
//	方法二
	var as = $("ul > a");
	as.click(function () {
//		这里需要找到当前ul中的li，然后显示出来
//		获取当前被点击的ul节点
		var aNode = $(this);
//		找到当前ul节点的所有li子节点，对应方法一
//		var lis = ulNode.children("li");
//		找到当前ul节点的所有li子节点，对应方法二
		var lis = aNode.nextAll("li");
//		让子菜单显示或隐藏
//		lis.toggle("slow");
		lis.toggle();
		$("li > a").click(function () {
			$("#content").load($(this).attr("id"));
		});
	});
});
