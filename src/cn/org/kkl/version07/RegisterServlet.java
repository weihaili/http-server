package cn.org.kkl.version07;

public class RegisterServlet extends Servlet {

	@Override
	public void doGet(Request request, Response response) throws Exception {
		response.println("<html><title>HTTP Response sington : register</title>");
		response.println("</head><body>");
		response.println("<h1>welcome :").println(request.getParameter("name")).println(" come back register");
		response.println("</h1></body></html>");

	}

	@Override
	public void doPost(Request request, Response response) throws Exception {
		response.println("<html><title>HTTP Response sington : register</title>");
		response.println("</head><body>");
		response.println("<h1>welcome :").println(request.getParameter("name")).println(" come back register");
		response.println("</h1></body></html>");

	}

}
