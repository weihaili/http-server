package cn.org.kkl.version07;

import java.util.Map;

public class Webapp {
	
	private static ServletContext context;
	
	static {
		context=new ServletContext();
		
		Map<String,String> mapping=context.getMapping();
		mapping.put("/500", "500");
		mapping.put("/404", "404");
		mapping.put("/index.html", "index");
		mapping.put("/login", "login");
		mapping.put("/log", "login");
		mapping.put("/reg", "register");
		
		
		Map<String,Servlet> servlet=context.getServlet();
		servlet.put("404", new NotFonudServlet());
		servlet.put("500", new ServerExceptionServlet());
		servlet.put("index", new IndexServlet());
		servlet.put("login", new IndexServlet());
		servlet.put("login", new LoginServlet());
		servlet.put("register", new RegisterServlet());
	}
	
	public static Servlet getServlet(String url) {
		if (url.trim().isEmpty()) {
			return null;
			//return context.getServlet().get(context.getMapping().get(url));
		}
		
		return context.getServlet().get(context.getMapping().get(url));
	}

}
