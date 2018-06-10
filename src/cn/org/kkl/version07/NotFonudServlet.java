package cn.org.kkl.version07;

public class NotFonudServlet extends Servlet {

	@Override
	public void doGet(Request request, Response response) throws Exception {
		response.println("<html><title>HTTP Response sington : url corressponding source not found</title>");
		response.println("</head><body>");
		response.println("<h1>welcome :").println("url corressponding source not found").println(" come back register");
		response.println("</h1></body></html>");

	}

	@Override
	public void doPost(Request request, Response response) throws Exception {
		response.println("<html><title>HTTP Response sington : url corressponding source not found</title>");
		response.println("</head><body>");
		response.println("<h1>welcome :").println("url corressponding source not found").println(" come back register");
		response.println("</h1></body></html>");

	}

}
