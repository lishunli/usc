package com.test.jfreechart;

import java.awt.Font;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class JFreeChartTest2 extends ApplicationFrame
{
	public JFreeChartTest2(String title)
	{
		super(title);

		this.setContentPane(createPanel());
	}

	public static CategoryDataset createDataset()
	{
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		dataset.setValue(10, "������Ա", "������Ա");
		dataset.setValue(20, "�г���Ա", "�г���Ա");
		dataset.setValue(40, "������Ա", "������Ա");
		dataset.setValue(15, "������Ա", "������Ա");

		return dataset;
	}

	public static JFreeChart createChart(CategoryDataset dataset)
	{
		JFreeChart chart = ChartFactory.createBarChart3D("hello", "��Ա�ֲ�", "��Ա����",
				dataset, PlotOrientation.VERTICAL, true, false, false);
//		����hello�������꣺��Ա�ֲ��������꣺��Ա��������״ͼ�Ǵ�ֱ������legend

		chart.setTitle(new TextTitle("ĳ��˾��֯�ṹͼ", new Font("����", Font.BOLD
				+ Font.ITALIC, 20)));

		CategoryPlot plot = (CategoryPlot) chart.getPlot();

		CategoryAxis categoryAxis = plot.getDomainAxis();

		categoryAxis.setLabelFont(new Font("΢���ź�", Font.BOLD, 12));

		return chart;

	}

	public static JPanel createPanel()
	{
		JFreeChart chart = createChart(createDataset());

		return new ChartPanel(chart);
	}

	public static void main(String[] args)
	{
		JFreeChartTest2 chart = new JFreeChartTest2("ĳ��˾��֯�ṹͼ");

		chart.pack();
		chart.setVisible(true);
	}

}