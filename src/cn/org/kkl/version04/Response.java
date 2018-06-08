package cn.org.kkl.version04;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;

/**
 * packaging response infomation
 * 
 * @author Admin
 * 
 *         1. first line :http/version state-code description 2. response
 *         head:contains server information,content-type,encode-set,response
 *         date modify date,response information byte length 3. CRLF 4. response
 *         content: html
 */
public class Response {
	public static final String CRLF = "\r\n";

	public static final String BLANK = " ";
	
	private int len=0;

	private StringBuilder headInfo;
	
	private StringBuilder content;
	
	private BufferedWriter bw;
	
	public Response() {
		headInfo = new StringBuilder();
		content=new StringBuilder();
		len=0;
	}
	
	public Response(OutputStream os) {
		this();
		bw=new BufferedWriter(new OutputStreamWriter(os));
	}
	
	public Response(Socket client) {
		this();
		try {
			bw=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
		} catch (IOException e) {
			System.out.println("response get bufferedWriter exception");
			headInfo=null;
			e.printStackTrace();
		}
	}
	
	/**
	 * create response content
	 * @param info
	 */
	public Response print(String info) {
		content.append(info);
		len+=info.getBytes().length;
		return this;
	}
	
	public Response println(String info) {
		content.append(info).append(CRLF);
		len+=(info+CRLF).getBytes().length;
		return this;
	}

	/**
	 * create response head information
	 */
	private void createResponseHead(int statCode) {
		// http protocol and version, state-code,description
		headInfo.append("HTTP/1.1").append(BLANK).append(statCode).append(BLANK);
		switch (statCode) {
		case 200:
			headInfo.append("OK");
			break;
		case 404:
			headInfo.append("NOT FOUND");
			break;
		case 500:
			headInfo.append("SERVER EXCEPTION");
			break;
		}
		headInfo.append(CRLF);
		// response head
		headInfo.append("cn.org.kkl.server/0.0.3").append(CRLF);
		// response data
		headInfo.append(new Date()).append(CRLF);
		// response dataType encode set
		headInfo.append("Content-type:text/html;charset=UTF-8").append(CRLF);
		// response content length (byte length)
		headInfo.append("Content-Length:").append(len).append(CRLF);
		headInfo.append(CRLF);
	} 
	
	void pushToClient(int code) {
		if(null==headInfo) {
			code=500;
		}
		createResponseHead(code);
		 try {
			bw.write(headInfo.toString());
			if(404==code || 500==code) {
				bw.write(createErrContent(code).toString());
			}else {
				bw.write(content.toString());
			}
			bw.flush();
		} catch (IOException e) {
			System.out.println("response push to client exception");
			e.printStackTrace();
		}
	}
	
	private StringBuilder createErrContent(int code) {
		StringBuilder errInfo = new StringBuilder();
		
		switch (code) {
		case 404:
			errInfo.append("<html>"
					+ "<head>"
					+ "<title>NOT FOUND</title>"
					+ "</head>"
					+ "<body>"
					+ "<h1>your url not found file response ,please check<h1>"
					+ "</body>"
					+ "</html>");
			break;
			
		case 500:
			errInfo.append("<html>"
					+ "<head>"
					+ "<title>SERVER ERR</title>"
					+ "</head>"
					+ "<body>"
					+ "<h1>server in maintence ,please try again later <h1>"
					+ "</body>"
					+ "</html>");
			break;
		}
		len+=errInfo.toString().getBytes().length;
		return errInfo;
	}
	
	public void close() {
		IoCloseUtil.closeAllIo(bw);
	}

}
