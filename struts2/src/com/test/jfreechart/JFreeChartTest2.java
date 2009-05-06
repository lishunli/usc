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

		dataset.setValue(10, "管理人员", "管理人员");
		dataset.setValue(20, "市场人员", "市场人员");
		dataset.setValue(40, "开发人员", "开发人员");
		dataset.setValue(15, "其他人员", "其他人员");

		return dataset;
	}

	public static JFreeChart createChart(CategoryDataset dataset)
	{
		JFreeChart chart = ChartFactory.createBarChart3D("hello", "人员分布", "人员数量",
				dataset, PlotOrientation.VERTICAL, true, false, false);
//		标题hello，横坐标：人员分布，纵坐标：人员数量，柱状图是垂直方向，有legend

		chart.setTitle(new TextTitle("某公司组织结构图", new Font("宋体", Font.BOLD
				+ Font.ITALIC, 20)));

		CategoryPlot plot = (CategoryPlot) chart.getPlot();

		CategoryAxis categoryAxis = plot.getDomainAxis();

		categoryAxis.setLabelFont(new Font("微软雅黑", Font.BOLD, 12));

		return chart;

	}

	public static JPanel createPanel()
	{
		JFreeChart chart = createChart(createDataset());

		return new ChartPanel(chart);
	}

	public static void main(String[] args)
	{
		JFreeChartTest2 chart = new JFreeChartTest2("某公司组织结构图");

		chart.pack();
		chart.setVisible(true);
	}

}
