package com.usc.service;


/*****************************
 *Servlet ��֤��(���������ĸ+���ֵ�6λ��֤��)
 *@author ���ΰ
 *QQ:858593747
 *Email:auglyboy@yahoo.cn
*****************************/

import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ImageServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ImageServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//��ȷ��Ӧ�ĵ�������ͼƬ
		response.setContentType("image/jpeg");
//		PrintWriter outp = response.getWriter();
		//����ͼƬ��������
		String code[]={
				"0","1","2","3","4","5","6","7","8","9",
				"A","B","C","D","E","F","G","H","I","J",
				"K","L","M","N","O","P","Q","R","S","T",
				"U","V","W","S","Y","Z","a","b","c","d",
				"e","f","g","h","i","j","k","l","m","n",
				"o","p","q","r","s","t","u","v","w","s",
				"y","z"
		};
		//��������
		OutputStream out=response.getOutputStream();
		//�������ͼƬ,���л��湦��
		BufferedImage image=new BufferedImage(75,25,BufferedImage.TYPE_INT_RGB);
		//��û�ͼ����
		java.awt.Graphics g=image.getGraphics();
		//���ñ���ɫ
		//g.setColor(getRandColor(200,250));
		//g.fillRect(0, 0, width, height);
		//g.setColor(java.awt.Color.WHITE);
		//�����������
		g.fillRect(0,0,120,70);
		//����ǰ����ɫ
		g.setColor(java.awt.Color.BLACK);
		Random random = new Random();
		g.setColor(getRandColor(160,200));
		for (int i=0;i<155;i++)
		{
		 int x = random.nextInt(75);
		 int y = random.nextInt(25);
		        int xl = random.nextInt(12);
		        int yl = random.nextInt(12);
		 g.drawLine(x,y,x+xl,y+yl);
		}
		//���߿�
//		g.drawRect(0,0,75-1,25-1);
		g.drawRect(0,0,75-1,25-1);
		//���������Ϣ����
		g.setFont(new java.awt.Font("����",java.awt.Font.BOLD,18));
		g.setFont(new Font("Times New Roman",Font.PLAIN,18));
		//���������Ϣ ,�������������(6λ)
		String str="";
		for(int i=0;i<4;i++){
			//���������
			//int num=(int)(Math.random()*10);
			String autoStr = code[random.nextInt(62)];
			str+=autoStr;
			//str+=num;
//			g.setColor(getRandColor(160,200));
			 g.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));//���ú�����������ɫ��ͬ����������Ϊ����̫�ӽ�������ֻ��ֱ������
			 //g.drawString(str,13*i+6,16);
		}
//		System.out.println("���ɵ���֤���ǣ�"+str);
//		request.setAttribute("verify", str);
		request.getSession().setAttribute("verify", str);
		
//		outp.print(str);
//		System.out.println("::::"+request.getSession().getAttribute("verify"));
		//����������Ϣ
		g.drawString(str,5,18);
		//�ͷŻ�ͼ����
		g.dispose();
		//���������ͼƬ���������
		javax.imageio.ImageIO.write(image,"JPEG",out);	
		
	}

	/**
	 * �����������ɫ
	 * @param fc
	 * @param bc
	 * @return color
	 */
	private Color getRandColor(int fc,int bc){//������Χ��������ɫ
        Random random = new Random();
        if(fc>255) fc=255;
        if(bc>255) bc=255;
        int r=fc+random.nextInt(bc-fc);
        int g=fc+random.nextInt(bc-fc);
        int b=fc+random.nextInt(bc-fc);
        return new Color(r,g,b);
    }
	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occure
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
