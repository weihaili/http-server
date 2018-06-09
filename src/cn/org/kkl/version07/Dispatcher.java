package cn.org.kkl.version07;

import java.io.IOException;
import java.net.Socket;

/**
 * 一个请求-响应 对应一个线程
 * @author Admin
 *
 */
public class Dispatcher implements Runnable {
	
	private Request request;
	
	private Response response;
	
	private Socket client;
	
	private int code=200;
	
	public Dispatcher(Socket client) {
		this.client=client;
		try {
			request=new Request(client.getInputStream());
			response=new Response(client.getOutputStream());
		} catch (IOException e) {
			System.out.println("init requst or response exception");
			e.printStackTrace();
			code=500;
			return;
		}
	}

	@Override
	public void run() {
		Servlet servlet=new Servlet();
		servlet.service(request, response);
		response.pushToClient(code);
		
		IoCloseUtil.closeSeoket(client);
	}

}
