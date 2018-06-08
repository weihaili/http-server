package cn.org.kkl.version03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import com.sun.org.apache.bcel.internal.generic.NEW;


public class Server {
	private ServerSocket server;
	
	public static final String CRLF="\r\n";
	
	public static final String BLANK=" ";
	
	private Socket client;
	
	public static void main(String[] args) {
		new Server().start();
	}
	
	private void start() {
		try {
			server=new ServerSocket(8888);
			receive();
		} catch (IOException e) {
			System.out.println("client connection server exception");
			e.printStackTrace();
		}
	}

	private void receive() {
		byte[] data=new byte[20480];
		try {
			client=server.accept();
			int len=client.getInputStream().read(data);
			String requestInfo=new String(data, 0, len).trim();
			System.out.println(requestInfo);
			
			//response
			responseHead();
			
		} catch (IOException e) {
			System.out.println("server read reqeusInfo exception");
			e.printStackTrace();
		}
	}
	
	
	/*private void response(StringBuilder head,StringBuilder content) {
		int length=responseContent().toString().getBytes().length;
		
	}*/

	private void responseHead() {
		StringBuilder responsehd=new StringBuilder();
		//http protocol and version, state-code,description
		responsehd.append("HTTP/1.1").append(BLANK)
		  		  .append("200").append(BLANK)
		  		  .append("OK").append(CRLF);
		//response head
		responsehd.append("cn.org.kkl.server/0.0.3").append(CRLF);
		//response data
		responsehd.append(new Date()).append(CRLF);
		//response dataType encode set
		responsehd.append("Content-type:text/html;charset=UTF-8").append(CRLF);
		//response content length  (byte length)
		responsehd.append("Content-Length:").append(responseContent().toString().getBytes().length).append(CRLF);
		//between content and head exist CRLF
		responsehd.append(CRLF);
		responsehd.append(responseContent());
		
		try {
			BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			bw.write(responsehd.toString());
			bw.flush();
			bw.close();
		} catch (IOException e) {
			System.out.println("response stream excepion");
			e.printStackTrace();
		}
		
	}

	private StringBuilder responseContent() {
		StringBuilder responseText=new StringBuilder();
		responseText.append("<html><head><title>firstResponse</title></head><body>"
				+ "<h1>hello world</h1></body></html>");
		return responseText;
	}
	
	

	private void stop() {
		
	}
}
