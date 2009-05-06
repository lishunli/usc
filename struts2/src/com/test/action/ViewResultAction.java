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
		chart = ChartFactory.createBarChart3D("��Ȥͳ�ƽ��", "��Ŀ", "���", this
				.getDataset(), PlotOrientation.VERTICAL, false, false, false);
		
		chart.setTitle(new TextTitle("��Ȥͳ�ƽ��",new Font("����",Font.BOLD,22)));//���ñ������ƺ�����
		
		CategoryPlot plot = (CategoryPlot)chart.getPlot();
		
		CategoryAxis categoryAxis = plot.getDomainAxis();
		
		categoryAxis.setLabelFont(new Font("����",Font.BOLD,22));
		
		categoryAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);//ˮƽ��б45��
		
		NumberAxis numberAxis = (NumberAxis)plot.getRangeAxis();
		
		numberAxis.setLabelFont(new Font("����",Font.BOLD,22));
		
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
//��������ҵ�����ʱ��һ�㲻��д��action�ڣ�һ��д��modul��
	@SuppressWarnings("unchecked")
	private void increaseResult(List<String> list)
	{
		ActionContext context = ActionContext.getContext();

		Map map = context.getApplication();

		for (String str : list)
		{
			if (null == map.get(str))//��һ��ͶƱ����Ϊ1
			{
				map.put(str, 1);
			}
			else//�����ͶƱ����Ϊ+1
			{
				map.put(str, (Integer) map.get(str) + 1);
			}
		}
	}

	@SuppressWarnings("unchecked")
	private CategoryDataset getDataset()
	{
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		this.increaseResult(this.getInterest());//�ѽ���ŵ�context��

		ActionContext context = ActionContext.getContext();

		Map map = context.getApplication();

		dataset.setValue((Integer) map.get("football"), "", "����");
		dataset.setValue((Integer) map.get("basketball"), "", "����");
		dataset.setValue((Integer) map.get("volleyball"), "", "����");
		dataset.setValue((Integer) map.get("badminton"), "", "��ë��");

		return dataset;
	}

}
