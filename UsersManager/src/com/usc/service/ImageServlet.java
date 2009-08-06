package com.usc.service;


/*****************************
 *Servlet 验证码(随机生成字母+数字的6位验证码)
 *@author 徐嘉伟
 *QQ:858593747
 *Email:auglyboy@yahoo.cn
*****************************/

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ImageServlet extends HttpServlet {
//
//	/**
//	 * Constructor of the object.
//	 */
//	public ImageServlet() {
//		super();
//	}
//
//	/**
//	 * Destruction of the servlet. <br>
//	 */
//	public void destroy() {
//		super.destroy(); // Just puts "destroy" string in log
//		// Put your code here
//	}
//
//	/**
//	 * The doGet method of the servlet. <br>
//	 *
//	 * This method is called when a form has its tag value method equals to get.
//	 * 
//	 * @param request the request send by the client to the server
//	 * @param response the response send by the server to the client
//	 * @throws ServletException if an error occurred
//	 * @throws IOException if an error occurred
//	 */
//	public void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		//明确响应文档类型是图片
//		response.setContentType("image/jpeg");
////		PrintWriter outp = response.getWriter();
//		//产生图片数字数组
//		String code[]={
//				"0","1","2","3","4","5","6","7","8","9",
//				"A","B","C","D","E","F","G","H","I","J",
//				"K","L","M","N","O","P","Q","R","S","T",
//				"U","V","W","S","Y","Z","a","b","c","d",
//				"e","f","g","h","i","j","k","l","m","n",
//				"o","p","q","r","s","t","u","v","w","s",
//				"y","z"
//		};
//		//获得输出流
//		OutputStream out=response.getOutputStream();
//		//产生输出图片,具有缓存功能
//		BufferedImage image=new BufferedImage(75,25,BufferedImage.TYPE_INT_RGB);
//		//获得绘图对象
//		java.awt.Graphics g=image.getGraphics();
//		//设置背景色
//		//g.setColor(getRandColor(200,250));
//		//g.fillRect(0, 0, width, height);
//		//g.setColor(java.awt.Color.WHITE);
//		//设置填充区域
//		g.fillRect(0,0,120,70);
//		//设置前景颜色
//		g.setColor(java.awt.Color.BLACK);
//		Random random = new Random();
//		g.setColor(getRandColor(160,200));
//		for (int i=0;i<155;i++)
//		{
//		 int x = random.nextInt(75);
//		 int y = random.nextInt(25);
//		        int xl = random.nextInt(12);
//		        int yl = random.nextInt(12);
//		 g.drawLine(x,y,x+xl,y+yl);
//		}
//		//画边框
////		g.drawRect(0,0,75-1,25-1);
//		g.drawRect(0,0,75-1,25-1);
//		//设置输出信息字体
//		g.setFont(new java.awt.Font("宋体",java.awt.Font.BOLD,18));
//		g.setFont(new Font("Times New Roman",Font.PLAIN,18));
//		//产生输出信息 ,随机产生的数字(6位)
//		String str="";
//		for(int i=0;i<4;i++){
//			//产生随机数
//			//int num=(int)(Math.random()*10);
//			String autoStr = code[random.nextInt(62)];
//			str+=autoStr;
//			//str+=num;
////			g.setColor(getRandColor(160,200));
//			 g.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));//调用函数出来的颜色相同，可能是因为种子太接近，所以只能直接生成
//			 //g.drawString(str,13*i+6,16);
//		}
////		System.out.println("生成的验证码是："+str);
////		request.setAttribute("verify", str);
//		request.getSession().setAttribute("verify", str);
//		
////		outp.print(str);
////		System.out.println("::::"+request.getSession().getAttribute("verify"));
//		//输出随机数信息
//		g.drawString(str,5,18);
//		//释放绘图对象
//		g.dispose();
//		//真正的输出图片到浏览器端
//		javax.imageio.ImageIO.write(image,"JPEG",out);	
//		
//	}
//
//	/**
//	 * 生成随机背景色
//	 * @param fc
//	 * @param bc
//	 * @return color
//	 */
//	private Color getRandColor(int fc,int bc){//给定范围获得随机颜色
//        Random random = new Random();
//        if(fc>255) fc=255;
//        if(bc>255) bc=255;
//        int r=fc+random.nextInt(bc-fc);
//        int g=fc+random.nextInt(bc-fc);
//        int b=fc+random.nextInt(bc-fc);
//        return new Color(r,g,b);
//    }
//	/**
//	 * The doPost method of the servlet. <br>
//	 *
//	 * This method is called when a form has its tag value method equals to post.
//	 * 
//	 * @param request the request send by the client to the server
//	 * @param response the response send by the server to the client
//	 * @throws ServletException if an error occurred
//	 * @throws IOException if an error occurred
//	 */
//	public void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		this.doGet(request, response);
//	}
//
//	/**
//	 * Initialization of the servlet. <br>
//	 *
//	 * @throws ServletException if an error occure
//	 */
//	public void init() throws ServletException {
//		// Put your code here
//	}
	

	  static final long serialVersionUID = 19870121;
	    public void init(){
	        /*初始化Servlet*/
	    }
	    public void destory(){
	        /*退出Servlet*/
	    }
	    public String tranPOST(String buffer_){/*编码翻译*/
	        try{
	            return java.net.URLDecoder.decode(buffer_, "UTF-8");
	        }catch(Exception e){
	        /*错误处理*/
	            return null;
	        }
	    }
	    public void doGet(HttpServletRequest request,HttpServletResponse response){
	        try{
	            doPost(request,response);
	        }catch(Exception e){
	        /*错误处理*/
	        }
	    }
	    public void doPost(HttpServletRequest request,HttpServletResponse response){
	        try{
	            response.setContentType("image/jpeg");
	            request.getSession().setAttribute("verify",writeImg(response.getOutputStream()));
//	            System.out.println("verifycodeold:"+request.getSession().getAttribute("verifycode"));
	            
	        }catch(Exception e){
	        //错误处理
	        }
	    }
	    public String writeImg(OutputStream out){
	        int width = 75;
	        int height = 18;
	        /**应用绘图对象**/
	        BufferedImage bi = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
	        Graphics2D gd = (Graphics2D)bi.getGraphics();
	        /**绘制背景**/
	        
//			gd.setColor(getRandColor(100,200));
//			gd.fillRect(0, 0, width, height);
//			gd.setColor(java.awt.Color.WHITE);
//			gd.fillRect(0,0,120,70);
//	        红：204 绿：232 蓝：207
	        gd.setBackground(new Color(204,232,207));
//	        gd.setBackground(new Color(rnd(),rnd(),rnd()));
	        gd.clearRect(0,0,width,height);
	        /**设置字体**/
	        Font font = new Font(getRndFontNames(),Font.PLAIN,24);
	        gd.setFont(font);
	        /**随机字串**/
	        StringBuffer sb = new StringBuffer();
	        int i;
	        for(i=0;i<4 ;i++ ){
	            sb.append(filter(rnd()));
	        }
	        
	        /**设置颜色并输出**/
	        /** 1 所有验证码颜色一致
	        gd.setColor(new Color(rnd(),rnd(),rnd()));
	        gd.drawString(sb.toString(), 0, 16); //这是普通方式，我想让所有字母颜色都不同
	        **/
	        /** 2 用随机颜色生成每个验证符**/
	        String st = sb.toString();
	        while(i>0){
	            /**随机颜色，并进行色彩限定**/
	            gd.setColor(new Color(rnd(),rnd(),rnd()));
	            gd.drawString(st.substring(i-1,i),(i-1)*16+5,16);
	            i--;
	        }

	/**清理现场**/
	        gd.dispose();
	        bi.flush();
	/**绘制**/
	        try{
	            ImageIO.write(bi,"jpg",out);
	        }catch(IOException e){
	            System.out.println("Error in writeImg:" + e);
	        }
	        return st;
	    }
	/**随机生成0-255的数字**/
	    public int rnd(){
	        java.util.Random random = new java.util.Random();
	        return random.nextInt(255);
	    }
	/**把除了大小写字母和数字外的字符全过滤掉**/
	    public char filter(int k){
	        if(k<65)k=48+(k%10);
	        if(k>64&&k<96)k=65+(k%26);
	        if(k>96)k=97+(k%26);
	        return (char)k;
	    }
	/**取得一个随机字体**/
	    public String getRndFontNames(){
	        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	        String[] k = ge.getAvailableFontFamilyNames();
	        java.util.Random r = new java.util.Random();
	        return k[r.nextInt(k.length)];
	    }
		private Color getRandColor(int fc,int bc){//给定范围获得随机颜色
      Random random = new Random();
      if(fc>255) fc=255;
      if(bc>255) bc=255;
      int r=fc+random.nextInt(bc-fc);
      int g=fc+random.nextInt(bc-fc);
      int b=fc+random.nextInt(bc-fc);
      return new Color(r,g,b);


		}
	
}
