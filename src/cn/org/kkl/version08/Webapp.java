package cn.org.kkl.version08;

import java.util.Map;

public class Webapp {
	
	private static ServletContext context;
	
	static {
		context=new ServletContext();
		
		Map<String,String> mapping=context.getMapping();
		mapping.put("/serverErr", "serverErr");
		mapping.put("/notFound", "notFonud");
		mapping.put("/index.html", "index");
		mapping.put("/login", "login");
		mapping.put("/log", "login");
		mapping.put("/reg", "register");
		
		
		Map<String,String> servlet=context.getServlet();
		servlet.put("notFonud", "cn.org.kkl.version08.NotFonudServlet");
		servlet.put("serverErr", "cn.org.kkl.version08.ServerExceptionServlet");
		servlet.put("index", "cn.org.kkl.version08.IndexServlet");
		servlet.put("login", "cn.org.kkl.version08.LoginServlet");
		servlet.put("log", "cn.org.kkl.version08.LoginServlet");
		servlet.put("register", "cn.org.kkl.version08.RegisterServlet");
	}
	
	public static Servlet getServlet(String url) {
		if (url.trim().isEmpty()) {
			return null;
			//return context.getServlet().get(context.getMapping().get(url));
		}
		
		try {
			return (Servlet) Class.forName(context.getServlet().get(context.getMapping().get(url))).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			System.out.println("webapp get servlet exception please check your url");
			e.printStackTrace();
		}
		return null;
	}

}
