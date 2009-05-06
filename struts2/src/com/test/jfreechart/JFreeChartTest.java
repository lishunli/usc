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
//		��ͼ
		DefaultPieDataset dpd = new DefaultPieDataset();

		dpd.setValue("������Ա", 25);
		dpd.setValue("�г���Ա", 25);
		dpd.setValue("������Ա", 45);
		dpd.setValue("������Ա", 10);
		/*
		 * title - the chart title (null permitted).
dataset - the dataset for the chart (null permitted).
legend - a flag specifying whether or not a legend is required.
tooltips - configure chart to generate tool tips?
urls - configure chart to generate URLs?
		 */
//		JFreeChart chart = ChartFactory.createPieChart("ĳ��˾��Ա��֯�ṹͼ", dpd, true,true, false);
//
//
		JFreeChart chart = ChartFactory.createPieChart3D("ĳ��˾��Ա��֯�ṹͼ", dpd, true,true, false);
//		   /*------���������˵ײ��������������-----------*/  
//		chart.getLegend().setItemFont(new Font("����", Font.PLAIN, 12)); 
//
//		ChartFrame chartFrame = new ChartFrame("ĳ��˾��Ա��֯�ṹͼ", chart);
//
//		chartFrame.pack();
//
//		chartFrame.setVisible(true);
//		
//		��������Ϊ�汾�ߵ�ʱ�����������������⣬��������һ���Ͱ汾�ľ�û�г�����
//		Font font = new Font("Default", 10, 20); 
//		TextTitle txtTitle = null; 
//		txtTitle = chart.getTitle(); 
//		txtTitle.setFont(font); 
//		PiePlot pieplot = (PiePlot)chart.getPlot(); 
//		pieplot.setLabelFont(font); 
//		chart.getLegend().setItemFont(font); 
		
		ChartFrame pieFrame = new ChartFrame("��˾��֯�ܹ�ͼ", chart); 
		
		pieFrame.pack(); 
//		pieFrame.setFont(font); 
		pieFrame.setVisible(true); 

		
		

	}
}
