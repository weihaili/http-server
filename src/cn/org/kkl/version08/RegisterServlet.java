package cn.org.kkl.version08;

public class RegisterServlet extends Servlet {

	@Override
	public void doGet(Request request, Response response) throws Exception {
		String title = " register page";
		String url="/index";
		String method="get";
		StringBuilder data=new StringBuilder();
		data.append("<table><tr>"
				+ "<td><span>name:<span></td><td><input type='text' name='name'/></td></tr>"
				+ "<tr><td><span>password:</span></td><td><input type='password' name='pwd'/></td></tr>"
				+ "<tr><input type='submit' value='register'/></tr></table>");
		response.println(JspUtil.createHtmlWithFormTemplate(title, url, method, data.toString()).toString());
	}

	@Override
	public void doPost(Request request, Response response) throws Exception {
		String title = " register page";
		String url="/index";
		String method="get";
		StringBuilder data=new StringBuilder();
		data.append("<table><tr>"
				+ "<td><span>name:<span></td><td><input type='text' name='name'/></td></tr>"
				+ "<tr><td><span>password:</span></td><td><input type='password' name='pwd'/></td></tr>"
				+ "<tr><input type='submit' value='register'/></tr></table>");
		response.println(JspUtil.createHtmlWithFormTemplate(title, url, method, data.toString()).toString());

	}

}
