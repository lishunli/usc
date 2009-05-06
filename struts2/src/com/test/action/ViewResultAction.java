package com.test.action;

import java.awt.Font;
import java.util.List;
import java.util.Map;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ViewResultAction extends ActionSupport
{
	private JFreeChart chart;

	private List<String> interest;

	public JFreeChart getChart()
	{
		chart = ChartFactory.createBarChart3D("兴趣统计结果", "项目", "结果", this
				.getDataset(), PlotOrientation.VERTICAL, false, false, false);
		
		chart.setTitle(new TextTitle("兴趣统计结果",new Font("黑体",Font.BOLD,22)));//设置标题名称和字体
		
		CategoryPlot plot = (CategoryPlot)chart.getPlot();
		
		CategoryAxis categoryAxis = plot.getDomainAxis();
		
		categoryAxis.setLabelFont(new Font("宋体",Font.BOLD,22));
		
		categoryAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);//水平倾斜45度
		
		NumberAxis numberAxis = (NumberAxis)plot.getRangeAxis();
		
		numberAxis.setLabelFont(new Font("宋体",Font.BOLD,22));
		
		return chart;
	}

	public List<String> getInterest()
	{
		return interest;
	}

	public void setInterest(List<String> interest)
	{
		this.interest = interest;
	}

	@Override
	public String execute() throws Exception
	{
		return SUCCESS;
	}
//在真正的业务处理的时候一般不会写在action内，一般写在modul内
	@SuppressWarnings("unchecked")
	private void increaseResult(List<String> list)
	{
		ActionContext context = ActionContext.getContext();

		Map map = context.getApplication();

		for (String str : list)
		{
			if (null == map.get(str))//第一次投票设置为1
			{
				map.put(str, 1);
			}
			else//后面的投票设置为+1
			{
				map.put(str, (Integer) map.get(str) + 1);
			}
		}
	}

	@SuppressWarnings("unchecked")
	private CategoryDataset getDataset()
	{
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		this.increaseResult(this.getInterest());//把结果放到context中

		ActionContext context = ActionContext.getContext();

		Map map = context.getApplication();

		dataset.setValue((Integer) map.get("football"), "", "足球");
		dataset.setValue((Integer) map.get("basketball"), "", "篮球");
		dataset.setValue((Integer) map.get("volleyball"), "", "排球");
		dataset.setValue((Integer) map.get("badminton"), "", "羽毛球");

		return dataset;
	}

}
