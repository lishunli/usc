package org.usc.validate.action;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 用Struts2来生成验证码
 * 
 * @author <a href="http://www.blogjava.net/lishunli/" target="_blank">ShunLi</a>
 * @notes Created on 2010-3-12<br>
 *        Revision of last commit:$Revision$<br>
 *        Author of last commit:$Author$<br>
 *        Date of last commit:$Date$<br>
 *        <p>
 */
@SuppressWarnings("serial")
public class ValidateCode2Action extends ActionSupport
{
	private ByteArrayInputStream inputStream;

	public String getValidateImage() throws Exception
	{
		int width = 75;
		int height = 20;
		/** 应用绘图对象 **/
		BufferedImage bi = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		Graphics2D gd = (Graphics2D) bi.getGraphics();
		/** 绘制背景 **/

		gd.setColor(new Color(0xDCDCDC));
		gd.fillRect(0, 0, width, height);
		// 随机产生120个干扰点
		for (int i = 0; i < 120; i++)
		{
			int x = (int) (Math.random() * width);
			int y = (int) (Math.random() * height);
			int red = (int) (Math.random() * 255);
			int green = (int) (Math.random() * 255);
			int blue = (int) (Math.random() * 255);
			gd.setColor(new Color(red, green, blue));
			gd.drawOval(x, y, 1, 0);
		}

		// 红：204 绿：232 蓝：207
//		gd.setBackground(new Color(204, 232, 207));
		// gd.setBackground(new Color(rnd(),rnd(),rnd()));

		/** 设置字体 **/
//		"宋体",java.awt.Font.BOLD,18
//		Font font = new Font(getRndFontNames(), Font.PLAIN, 24);//原先设置的字体，可以随机
		Font font = new Font("宋体",java.awt.Font.BOLD,24);
		gd.setFont(font);
		/** 随机字串 **/
		StringBuffer sb = new StringBuffer();
		int i;
		for (i = 0; i < 4; i++)
		{
			sb.append(filter(rnd()));
		}

		/** 设置颜色并输出 **/
		/**
		 * 1 所有验证码颜色一致 gd.setColor(new Color(rnd(),rnd(),rnd()));
		 * gd.drawString(sb.toString(), 0, 16); //这是普通方式，我想让所有字母颜色都不同
		 **/
		/** 2 用随机颜色生成每个验证符 **/
		String st = sb.toString();
		while (i > 0)
		{
			/** 随机颜色，并进行色彩限定 **/
			gd.setColor(new Color(rnd(), rnd(), rnd()));
			gd.drawString(st.substring(i - 1, i), (i - 1) * 16 + 5, 16);
			i--;
		}

		/** 清理现场 **/
		gd.dispose();
		bi.flush();
		

		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) ctx.get(ServletActionContext.HTTP_REQUEST);

		request.getSession().setAttribute("security", st);
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		ImageOutputStream imageOut = ImageIO.createImageOutputStream(output);
		ImageIO.write(bi, "JPEG", imageOut);
		imageOut.close();
		ByteArrayInputStream input = new ByteArrayInputStream(output.toByteArray());
		this.setInputStream(input);
		return SUCCESS;
		
		
	}

	public void setInputStream(ByteArrayInputStream inputStream)
	{
		this.inputStream = inputStream;
	}

	public ByteArrayInputStream getInputStream()
	{
		return inputStream;
	}

	/** 随机生成0-255的数字 **/
	public int rnd()
	{
		java.util.Random random = new java.util.Random();
		return random.nextInt(255);
	}

	/** 把除了大小写字母和数字外的字符全过滤掉 **/
	public char filter(int k)
	{
		if (k < 65)
			k = 48 + (k % 10);
		if (k > 64 && k < 96)
			k = 65 + (k % 26);
		if (k > 96)
			k = 97 + (k % 26);
		return (char) k;
	}

	/** 取得一个随机字体 **/
	public String getRndFontNames()
	{
		GraphicsEnvironment ge = GraphicsEnvironment
				.getLocalGraphicsEnvironment();
		String[] k = ge.getAvailableFontFamilyNames();
		java.util.Random r = new java.util.Random();
		return k[r.nextInt(k.length)];
	}
}
