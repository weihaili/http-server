package cn.org.kkl.version07;

public class Servlet {
	
	public void service(Request request,Response response) {
		StringBuilder info=new StringBuilder();
		info.append("<html><head><title>kkl server response</title></head><body><h1>welcome "
				+ request.getParameter("name")
				+ " come back</h1></body></html>");
		response=response.println(info.toString());
		
	}

}
