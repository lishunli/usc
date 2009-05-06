package 模式8门面模式.FacadeDemo.facadedemo03;
//取药类
public class QuYao {
	
	public void jiaoFei(){
		System.out.println("划价交费。。。");
	}
	public void start(){
		System.out.println("等待取药中。。。。");
	}
	public void over(){
		System.out.println("拿了药，走人。。。");
	}
}
