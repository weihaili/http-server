package cn.org.kkl.version08;

public class ServerExceptionServlet extends Servlet {

	@Override
	public void doGet(Request request, Response response) throws Exception {
		response.println("<html><title>HTTP Response sington : server exception</title>");
		response.println("</head><body>");
		response.println("<h1>welcome :").println("server exception system is in maintence").println(" come back register");
		response.println("</h1></body></html>");
	}

	@Override
	public void doPost(Request request, Response response) throws Exception {
		response.println("<html><title>HTTP Response sington : server exception</title>");
		response.println("</head><body>");
		response.println("<h1>welcome :").println("server exception system is in maintence").println(" come back register");
		response.println("</h1></body></html>");

	}

}
