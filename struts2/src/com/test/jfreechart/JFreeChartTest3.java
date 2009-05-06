package com.test.jfreechart;

import java.awt.Font;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;

public class JFreeChartTest3
{
	
	private static DefaultPieDataset getDataset()
	{
		DefaultPieDataset dpd = new DefaultPieDataset();

		dpd.setValue("������Ա", 25);
		dpd.setValue("�г���Ա", 25);
		dpd.setValue("������Ա", 45);
		dpd.setValue("������Ա", 10);

		return dpd;
	}
	
	public static void main(String[] args) throws Exception
	{
		JFreeChart chart = ChartFactory.createPieChart3D("ĳ��˾��֯�ṹͼ",
				getDataset(), true, false, false);

		chart
				.setTitle(new TextTitle("ĳ��˾��֯�ṹͼ", new Font("����", Font.BOLD,
						22)));
//���ñ�������壬���Ը�������ı���
		LegendTitle legend = chart.getLegend(0);

		legend.setItemFont(new Font("΢���ź�", Font.BOLD, 14));//		��һ���±���������

		PiePlot plot = (PiePlot) chart.getPlot();

		plot.setLabelFont(new Font("����", Font.BOLD, 16));

		OutputStream os = new FileOutputStream("company.jpeg");
//����ķ����ܺõĽ�����ͼƬ�ļ�����������ͼƬ
		ChartUtilities.writeChartAsJPEG(os, chart, 800, 600);

		os.close();
		
		System.out.println("company.jpeg �����ɹ������ڹ����ļ����²��һ���ˢ�µ�ǰ����");

	}

	

}
