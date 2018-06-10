package cn.org.kkl.version08;
/**
 * 抽象出servlet父类
 * @author Admin
 */
public abstract class Servlet {
	
	public void service(Request request,Response response) throws Exception {
		if("pose".equalsIgnoreCase(request.getMethod())) {
			this.doPost(request, response);
		}else {
			this.doGet(request, response);
		}
	}
	
	public abstract void doGet(Request request,Response response) throws Exception;
	
	public abstract void doPost(Request request,Response response) throws Exception;

}
