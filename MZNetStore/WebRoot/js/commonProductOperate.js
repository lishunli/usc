////产品发布
//function  publishe(entityID,type) {
//	var discount = prompt("请输入折扣 (1-100)","100");  
//	var re = /^[1-9]\d*\d$/;   //判断字符串是否为数字/^[0-9]+.?[0-9]*$/     //判断正整数 /^[1-9]+[0-9]*]*$/  
//	if(null == discount || discount < 1 || discount!=parseInt(discount) || discount>100 )
//	{
//		alert("折扣没有输入或者输入错误，请输入1-100 之间的正整数");
//	}
//	else
//	{
//		window.self.location = "publishe.action?entityID="+entityID+"&type="+type+"&discount="+discount;	
//	}
//}

//修改折扣
function mergeDiscount(entityID, type) {
	var discount = prompt("请输入修改的折扣 (1-100)", "100");//折扣
	if (null == discount) {//取消
	} else if (discount < 1 || discount != parseInt(discount) || discount > 100) {//正整数 1-100
		alert("折扣输入错误，请输入1-100 之间的正整数");
	} else {
		window.self.location = "updateDiscount.action?entityID=" + entityID
				+ "&type=" + type + "&discount=" + discount;
	}
}

// 撤销发布
function unPublishe(entityID, type) {
	if (confirm("你真的要撤销该普通商品的发布吗？")) {//撤销确认
		window.self.location = "unPublishe.action?entityID=" + entityID
				+ "&type=" + type;
	}
}

// 设为促销
function saleSet(entityID, type) {
	var salePrice = prompt("请输入促销价", "0.0");
	if (check_num(salePrice)) {
		var priority = prompt("请输入优先级 (正整数)", "1");
		if (null == priority) {
		} else if (priority < 1 || priority != parseInt(priority)) {
			alert("优先级输入错误，请输入正整数");
		} else {
			window.self.location = "saleSet.action?entityID=" + entityID
					+ "&type=" + type + "&salePrice=" + salePrice
					+ "&priority=" + priority;
		}
	} else {
		alert("促销价输入错误，请输入正确的促销价格");
	}
	// private Float salePrice;//特价
	// private Integer priority; //优先级
}

// 判断是否为float型数据
function check_num(val_num) {
	var checkOK = "0123456789.";
	var checkStr = val_num;
	var allValid = true;
	var decPoints = 0;
	var allNum = "";
	var n = 0;
	for (i = 0; i < checkStr.length; i++) {
		ch = checkStr.charAt(i);
		if (ch == checkOK.charAt(10)) {
			n++;// 判断该字符串中有几个点
		}
		for (j = 0; j < checkOK.length; j++)
			if (ch == checkOK.charAt(j))
				break;

		if (j == checkOK.length) {
			allValid = false;
			break;
		}
		if (n > 1)// 如果字符串中点的个数>1的,错误
		{
			allValid = false;
			break;
		}
	}
	if (!allValid) {
		return (false);
	}
	return (true);
}
