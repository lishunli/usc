<%@page contentType="text/html; charset=GB2312"%>

<%@page import="java.io.FileNotFoundException"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="org.apache.commons.logging.Log"%>
<%@page import="java.io.IOException"%>

<%@page import="org.apache.commons.logging.LogFactory"%>
<%@page import="org.jfree.chart.ChartFactory"%>
<%@page import="org.jfree.chart.ChartUtilities"%>
<%@page import="org.jfree.chart.JFreeChart"%>
<%@page import="org.jfree.chart.plot.PlotOrientation"%>
<%@page import="org.jfree.data.category.CategoryDataset"%>
<%@page import="org.jfree.data.category.DefaultCategoryDataset"%>

<%@page import="java.awt.Color"%>
<%@page import="org.jfree.chart.renderer.category.BarRenderer3D"%>
<%@page import="org.jfree.chart.labels.StandardCategoryItemLabelGenerator"%>
<%@page import="org.jfree.chart.axis.CategoryAxis"%>
<%@page import="org.jfree.chart.plot.CategoryPlot"%>

<%
  DefaultCategoryDataset dataset    = new DefaultCategoryDataset();
  dataset.addValue(150, "����", "ƻ��");
  dataset.addValue(530, "�Ϻ�", "ƻ��");
  dataset.addValue(160, "����", "ƻ��");
  dataset.addValue(120, "����", "����");
  dataset.addValue(230, "�Ϻ�", "����");
  dataset.addValue(360, "����", "����");
  dataset.addValue(600, "����", "����");
  dataset.addValue(430, "�Ϻ�", "����");
  dataset.addValue(560, "����", "����");
  dataset.addValue(400, "����", "�㽶");
  dataset.addValue(530, "�Ϻ�", "�㽶");
  dataset.addValue(660, "����", "�㽶");
  dataset.addValue(500, "����", "��֦");
  dataset.addValue(630, "�Ϻ�", "��֦");
  dataset.addValue(430, "����", "��֦");
  
    JFreeChart chart = ChartFactory.createBarChart3D("ˮ������ͼͳ��-ľ������","ˮ������-http://blog.sina.com.cn/usc3l","����",dataset,PlotOrientation.VERTICAL,true,false,false);
        chart.setBackgroundPaint(Color.WHITE);
        CategoryPlot plot = chart.getCategoryPlot();

        CategoryAxis domainAxis = plot.getDomainAxis();
        //domainAxis.setVerticalCategoryLabels(false);
        plot.setDomainAxis(domainAxis);

        BarRenderer3D renderer = new BarRenderer3D();
        renderer.setBaseOutlinePaint(Color.BLACK);

        //����ÿ��������������ƽ������֮�����
        renderer.setItemMargin(0.1);
        //��ʾÿ��������ֵ�����޸ĸ���ֵ����������
        renderer.setItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        renderer.setItemLabelsVisible(true);
        plot.setRenderer(renderer);

        // ��������͸����
        plot.setForegroundAlpha(0.8f);

   		 ChartUtilities.writeChartAsPNG(response.getOutputStream(),chart,640,400);
    
    	out.clear();
		out = pageContext.pushBody();
%>