package com.usc.stock;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * Created by IntelliJ IDEA. User: ming Date: 2008-6-14 Time: 9:35:50 To change
 * this template use File | Settings | File Templates. ���ع�Ʊ��ǰ��Ϣ��servlet
 */
public class GetStocksInfo extends HttpServlet
{
	// �����Ʊ�����map
	private HashMap<String, Stock> stocks;

	protected void doGet(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws ServletException,
			IOException
	{
		// ������ֻ��Ʊ�ļ۸���Ϣ

		// 1�����������
		double sz = Math.random() * 20;
		double pf = Math.random() * 0.5;

		// ͨ�����������������ż�����жϹ�Ʊ���ǻ����µ�
		boolean flagsz = ((int) (Math.random() * 10)) % 2 == 0;
		boolean flagpf = ((int) (Math.random() * 10)) % 2 == 0;

		// 2����������͹�Ʊ�ĵ�ǰ�۸���мӻ���Ĳ������õ��µĵ�ǰ�۸�
		Stock szzs = stocks.get("300001");
		Stock pfyh = stocks.get("000001");
		double temp;
		if (flagsz)
		{
			temp = szzs.getNow() + sz;
		} else
		{
			temp = szzs.getNow() - sz;
		}
		// ��Ҫ���µĵ�ǰ�۸���н�ȡ��ֻ����С�������λ
		temp = (int) (temp * 100) / 100.0;
		szzs.setNow(temp);
		if (flagpf)
		{
			temp = pfyh.getNow() + pf;
		} else
		{
			temp = pfyh.getNow() - pf;
		}
		temp = (int) (temp * 100) / 100.0;
		pfyh.setNow(temp);

		httpServletResponse.setContentType("text/html;charset=gb2312");
		PrintWriter out = httpServletResponse.getWriter();
		// out.println(szzs + "<br />" + pfyh);
		// 3��������ֻ��Ʊ���������̣����쿪�̺͵�ǰ�۸�
		// ����json�����ݸ�ʽ���ع�Ʊ����Ϣ
		StringBuilder builder = new StringBuilder();
//		// ��������ķ�ʽ�ش�������Ʊ����
//		 builder.append("[{name:\"").append(szzs.getName()).append("\",id:\"").
//		 append(szzs.getId())
//		  .append("\",yes:").append(szzs.getYesterday()).append
//		(",tod:").append(szzs.getToday())
//		  .append(",now:").append(szzs.getNow()) .append("},")
//		  .append("{name:\""
//		  ).append(pfyh.getName()).append("\",id:\"").append(pfyh.getId())
//		  .append
//		  ("\",yes:").append(pfyh.getYesterday()).append(",tod:").append(
//		  pfyh.getToday()) .append(",now:").append(pfyh.getNow())
//		  .append("}]");
		
		// ���ö���ķ�ʽ�ش�������Ʊ����
		// ����ش���ʾ�����json����Ҫ����������һ�����ţ�����ҳ����������
		builder.append("({").append("\"").append(szzs.getId()).append(
				"\":{name:\"").append(szzs.getName()).append("\",yes:").append(
				szzs.getYesterday()).append(",tod:").append(szzs.getToday())
				.append(",now:").append(szzs.getNow()).append("},")
				.append("\"").append(pfyh.getId()).append("\":{name:\"")
				.append(pfyh.getName()).append("\",yes:").append(
						pfyh.getYesterday()).append(",tod:").append(
						pfyh.getToday()).append(",now:").append(pfyh.getNow())
				.append("}})");
		out.println(builder);

	}

	protected void doPost(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws ServletException,
			IOException
	{
		doGet(httpServletRequest, httpServletResponse);
	}

	public void init(ServletConfig servletConfig) throws ServletException
	{
		stocks = new HashMap<String, Stock>();
		// ������Ʊ
		Stock szzs = new Stock(3000.0, 2990.1, "��ָ֤��", "300001");
		Stock pfyh = new Stock(23.22, 23.50, "�ַ�����", "000001");

		// ����ֻ��Ʊ������stocks��map��
		stocks.put(szzs.getId(), szzs);
		stocks.put(pfyh.getId(), pfyh);

		System.out.println(stocks);
	}
}
