package cn.org.kkl.version08;

public class NotFonudServlet extends Servlet {

	@Override
	public void doGet(Request request, Response response) throws Exception {
		String title="source not found";
		String data="your input web sit content not found resource in server";
		response.println(JspUtil.createHtmlTemplate(title, data).toString());
	}

	@Override
	public void doPost(Request request, Response response) throws Exception {
		String title="source not found";
		String data="your input web sit content not found resource in server";
		response.println(JspUtil.createHtmlTemplate(title, data).toString());
	}

}
