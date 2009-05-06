package 模式8门面模式.FacadeDemo.facadedemo03;
//取药系统的门面
public class QuYaoJieDai {
	
	public final static QuYao qy=new QuYao();
	
	public void start(){
		qy.jiaoFei();
		qy.start();
		qy.over();
	}
}
