package cn.org.kkl.version08;

public class JspUtil {
	
	public static StringBuilder createHtmlTemplate(String title,String data) {
		StringBuilder strb=new StringBuilder();
		strb.append("<html><head><title>HTTP Response sington : ");
		strb.append(title.isEmpty()?" ":title);
		strb.append("</title></head>");
		strb.append("<body>");
		strb.append(data.isEmpty()?" ":data);
		strb.append("</body></html?");
		
		return strb;
	}

}
