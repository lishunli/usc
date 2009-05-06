package 模式8门面模式.FacadeDemo.facadedemo03;
//化验系统的门面
public class HuaYanJieDai {
	public final static HuaYan hy=new HuaYan();
	
	public void satrt(){
		hy.jiaoFei();
		hy.satrt();
		hy.over();
	}
}
