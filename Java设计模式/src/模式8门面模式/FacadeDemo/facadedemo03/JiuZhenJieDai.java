package 模式8门面模式.FacadeDemo.facadedemo03;
//就诊系统的门面
public class JiuZhenJieDai {
	public final static JiuZhen jz=new JiuZhen();
	
	public void start(){
		jz.start();
		jz.huaYan();
	}
}
