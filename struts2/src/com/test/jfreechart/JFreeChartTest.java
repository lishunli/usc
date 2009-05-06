package com.test.jfreechart;

import java.awt.Font;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;

public class JFreeChartTest
{
	public static void main(String[] args)
	{
//		饼图
		DefaultPieDataset dpd = new DefaultPieDataset();

		dpd.setValue("管理人员", 25);
		dpd.setValue("市场人员", 25);
		dpd.setValue("开发人员", 45);
		dpd.setValue("其他人员", 10);
		/*
		 * title - the chart title (null permitted).
dataset - the dataset for the chart (null permitted).
legend - a flag specifying whether or not a legend is required.
tooltips - configure chart to generate tool tips?
urls - configure chart to generate URLs?
		 */
//		JFreeChart chart = ChartFactory.createPieChart("某公司人员组织结构图", dpd, true,true, false);
//
//
		JFreeChart chart = ChartFactory.createPieChart3D("某公司人员组织结构图", dpd, true,true, false);
//		   /*------这句代码解决了底部汉字乱码的问题-----------*/  
//		chart.getLegend().setItemFont(new Font("宋体", Font.PLAIN, 12)); 
//
//		ChartFrame chartFrame = new ChartFrame("某公司人员组织结构图", chart);
//
//		chartFrame.pack();
//
//		chartFrame.setVisible(true);
//		
//		下面是因为版本高的时候出现中文乱码的问题，后来换了一个低版本的就没有出现了
//		Font font = new Font("Default", 10, 20); 
//		TextTitle txtTitle = null; 
//		txtTitle = chart.getTitle(); 
//		txtTitle.setFont(font); 
//		PiePlot pieplot = (PiePlot)chart.getPlot(); 
//		pieplot.setLabelFont(font); 
//		chart.getLegend().setItemFont(font); 
		
		ChartFrame pieFrame = new ChartFrame("公司组织架构图", chart); 
		
		pieFrame.pack(); 
//		pieFrame.setFont(font); 
		pieFrame.setVisible(true); 

		
		

	}
}
