package cn.org.kkl.version07;
/**
 * 抽象出servlet父类
 * @author Admin
 */
public abstract class Servlet {
	
	public void service(Request request,Response response) throws Exception {
		this.doGet(request,response);
		this.doPost(request,response);
	}
	
	public abstract void doGet(Request request,Response response) throws Exception;
	
	public abstract void doPost(Request request,Response response) throws Exception;

}
