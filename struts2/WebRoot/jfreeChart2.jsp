<%@ page language="java" contentType="text/html; charset=gb2312"%>
<%@ page import="org.jfree.data.general.DefaultPieDataset"%>
<%@ page import="org.jfree.chart.*"%>
<%@ page import="org.jfree.chart.plot.*"%>
<%@ page import="org.jfree.chart.servlet.ServletUtilities"%>
<%@ page import="org.jfree.chart.labels.StandardPieToolTipGenerator"%>
<%@ page import="org.jfree.chart.urls.StandardPieURLGenerator"%>
<%@ page import="org.jfree.chart.entity.StandardEntityCollection"%>
<%@ page import="java.io.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>程序员学历情况调查表</title>
</head>
<%
            DefaultPieDataset data = new DefaultPieDataset(); 
            //数据初始化
            data.setValue("高中以下",380); 
            data.setValue("高中",1620); 
            data.setValue("大专",6100); 
            data.setValue("本科",8310); 
            data.setValue("硕士",3520); 
            data.setValue("博士",180); 
            
            //HttpSession session = request.getSession();

            PiePlot3D plot = new PiePlot3D(data);//生成一个3D饼图 
            //plot.setURLGenerator(new StandardPieURLGenerator("DegreedView.jsp"));//设定图片链接 
            JFreeChart chart = new JFreeChart("",JFreeChart.DEFAULT_TITLE_FONT, plot, true); 
            chart.setBackgroundPaint(java.awt.Color.white);//可选，设置图片背景色 
            chart.setTitle("程序员学历情况调查表-木子制作");//可选，设置图片标题 
            plot.setToolTipGenerator(new StandardPieToolTipGenerator()); 
            StandardEntityCollection sec = new StandardEntityCollection(); 
            ChartRenderingInfo info = new ChartRenderingInfo(sec); 
            PrintWriter w = new PrintWriter(out);//输出MAP信息 
            //500是图片长度，300是图片高度
            String filename = ServletUtilities.saveChartAsPNG(chart,500,300,info,session); 
           // String filename = ServletUtilities.saveChartAsJPEG(chart,500,300,info,session); 
            ChartUtilities.writeImageMap(w,"map0",info,false); 

            String graphURL = request.getContextPath() + "/servlet/DisplayChart?filename=" + filename;
 //           out.print(request);
%> 

<P ALIGN="CENTER"> 
<img src="<%= graphURL %>" width=500 height=300 border=0 usemap="#map0"> 
</P>

</html>