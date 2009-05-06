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

		dpd.setValue("管理人员", 25);
		dpd.setValue("市场人员", 25);
		dpd.setValue("开发人员", 45);
		dpd.setValue("其他人员", 10);

		return dpd;
	}
	
	public static void main(String[] args) throws Exception
	{
		JFreeChart chart = ChartFactory.createPieChart3D("某公司组织结构图",
				getDataset(), true, false, false);

		chart
				.setTitle(new TextTitle("某公司组织结构图", new Font("宋体", Font.BOLD,
						22)));
//设置标题和字体，可以覆盖上面的标题
		LegendTitle legend = chart.getLegend(0);

		legend.setItemFont(new Font("微软雅黑", Font.BOLD, 14));//		第一个下标设置字体

		PiePlot plot = (PiePlot) chart.getPlot();

		plot.setLabelFont(new Font("隶书", Font.BOLD, 16));

		OutputStream os = new FileOutputStream("company.jpeg");
//下面的方法很好的解决输出图片文件流，并创建图片
		ChartUtilities.writeChartAsJPEG(os, chart, 800, 600);

		os.close();
		
		System.out.println("company.jpeg 创建成功，请在工程文件夹下查找或者刷新当前工程");

	}

	

}
