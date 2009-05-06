<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
    
<%@ page import="org.jfree.data.general.DefaultPieDataset,org.jfree.chart.ChartFactory
,org.jfree.chart.JFreeChart,org.jfree.chart.servlet.*" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>

<%

DefaultPieDataset dpd = new DefaultPieDataset();

dpd.setValue("管理人员", 25);
dpd.setValue("市场人员", 25);
dpd.setValue("开发人员", 45);
dpd.setValue("其他人员", 10);

JFreeChart chart = ChartFactory.createPieChart3D("某公司组织结构图",dpd, true, false, false);

String fileName = ServletUtilities.saveChartAsPNG(chart,800,600,null,session);
//放到服务器的临时文件夹下

//String url = request.getContextPath() + "/servlet/DisplayChart?filename=" + fileName;
String url=request.getContextPath() + "/servlet/DisplayChart?filename=" +fileName;//图片的url

//String url = "C:\\Program Files\\Apache Software Foundation\\Tomcat 6.0\\temp\\" + fileName;
//C:\\Program Files\\Apache Software Foundation\\Tomcat 6.0\\我的tomcat的物理地址，图片是放在temp文件夹下的

%>

<img src="<%= url %>" width=800 height=600>
<!--<img src="C:\Program Files\Apache Software Foundation\Tomcat 6.0\temp\jfreechart-20853.png" width=800 height=600 border=0 usemap="#<%= fileName %>">-->


</body>
</html>