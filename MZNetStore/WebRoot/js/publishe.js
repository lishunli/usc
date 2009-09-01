//function typeChange() {
//	var type = document.getElementById("type");
//	if(type.value ==  "图书")
//	{
//		$("#digital").css("visibility","hidden");
//		$("#book").css("visibility","visible");
//	}
//	else if(type.value == "数码")
//	{
//		$("#digital").css("visibility","visible");
//		$("#book").css("visibility","hidden");
//	}
//	
//}
//
////function backSerach() {
////	alert("hello");
////	window.self.location = "backSerach.action"	
////}
//
////图书发布
//function  publisheBook(entityID) {
//	var discount = prompt("请输入折扣 (1-100)","100");  
//	var re = /^[1-9]\d*\d$/;   //判断字符串是否为数字/^[0-9]+.?[0-9]*$/     //判断正整数 /^[1-9]+[0-9]*]*$/  
//	if(null == discount)
//	{
//	}
//	else if(discount < 1 || discount!=parseInt(discount) || discount>100 )
//	{
//		alert("折扣输入错误，请输入1-100 之间的正整数");
//	}
//	else
//	{
//		window.self.location = "publishe.action?entityID="+entityID+"&type=1&discount="+discount;	
//	}
//}

//产品发布
function publishe(entityID, type) {
	var discount = prompt("请输入折扣 (1-100)", "100");//输入折扣
	if (null == discount) {//取消
	} else if (discount < 1 || discount != parseInt(discount) || discount > 100) {//正整数 1-100
		alert("折扣输入错误，请输入1-100 之间的正整数");
	} else {
		window.self.location = "publishe.action?entityID=" + entityID
				+ "&type=" + type + "&discount=" + discount;
	}
}