package cn.org.kkl.version08;

public class ServerExceptionServlet extends Servlet {

	@Override
	public void doGet(Request request, Response response) throws Exception {
		String title="Server is in maintence";
		String data="server is undate and please try again later";
		response.println(JspUtil.createHtmlTemplate(title, data).toString());
	}

	@Override
	public void doPost(Request request, Response response) throws Exception {
		String title="Server is in maintence";
		String data="server is undate and please try again later";
		response.println(JspUtil.createHtmlTemplate(title, data).toString());
	}

}
