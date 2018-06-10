package cn.org.kkl.version07;

public class LoginServlet extends Servlet {

	@Override
	public void doGet(Request request,Response response) throws Exception {
		String name=request.getParameter("name");
		String password=request.getParameter("pwd");
		if(isLogin(name,password)) {
			response.println("登录成功");
		}else {
			response.println("失败");
		}
	}
	
	public boolean isLogin(String name,String password) {
		return "liweihai".equalsIgnoreCase(name)&& "123456".equalsIgnoreCase(password);
	}

	@Override
	public void doPost(Request request,Response response) throws Exception {
		response.println("<html><title>HTTP Response sington : login</title>");
		response.println("</head><body>");
		response.println("<h1>welcome :").println(request.getParameter("name")).println(" come back login");
		response.println("</h1></body></html>");
	}

}
