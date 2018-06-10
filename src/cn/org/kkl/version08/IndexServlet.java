package cn.org.kkl.version08;

public class IndexServlet extends Servlet {

	@Override
	public void doGet(Request request, Response response) throws Exception {
		String title="index page";
		String data="welcome tourist come back !";
		response.println(JspUtil.createHtmlTemplate(title, data).toString());
		

	}

	@Override
	public void doPost(Request request, Response response) throws Exception {
		String title="index page";
		String data="welcome tourist come back !";
		response.println(JspUtil.createHtmlTemplate(title, data).toString());

	}

}
