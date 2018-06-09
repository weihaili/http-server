package cn.org.kkl.version04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	private ServerSocket server;
	
	private Socket client;
	
	private InputStream is;
	
	private BufferedReader br;
	
	private Response response;
	
	public static void main(String[] args) {
		Server kkl = new Server();
		kkl.start();
		kkl.stop();
	}
	
	private void start() {
		try {
			server=new ServerSocket(8888);
			//receiveByByte();
			receiveByChar();
		} catch (IOException e) {
			System.out.println("server port is occupancy");
			e.printStackTrace();
		}
	}

	/**
	 * byte array read
	 * spend time 42699ms
	 */
	private void receiveByByte() {
		try {
			long start = System.currentTimeMillis();
			client=server.accept();
			byte[] flush=new byte[10240];
			is=client.getInputStream();
			int len=is.read(flush);
			String requestInfo=new String(flush, 0, len).trim();
			System.out.println(requestInfo);
			long end=System.currentTimeMillis();
			System.out.println("receiveByByte spend time "+(end-start));
			
			response = new Response(client);
			StringBuilder responseInfo=new StringBuilder();
			responseInfo.append("<html>"
					+ "<head>"
					+ "<title>kkl server response</title>"
					+ "</head>"
					+ "<body>"
					+ "<h1>welcom liweihai come back</h1>"
					+ "</body>"
					+ "</html>");
			
			response=response.println(responseInfo.toString());
			response.pushToClient(500);
			response.close();
			
		} catch (IOException e) {
			System.out.println("client connection server exception");
			e.printStackTrace();
		}
	}
	
	/**
	 * char array read
	 * spend time 30483ms
	 */
	private void receiveByChar() {
		try {
			long start=System.currentTimeMillis();
			client=server.accept();
			br = new BufferedReader(new InputStreamReader(client.getInputStream()));
			char[] flush=new char[10240];
			int len=br.read(flush);
			String requestInfo=new String(flush,0,len).trim();
			System.out.println(requestInfo);
			long end=System.currentTimeMillis();
			System.out.println("receiveByChar spend time "+(end-start));
			
			//response
			response=new Response(client.getOutputStream());
			StringBuilder info=new StringBuilder();
			info.append("<html><head><title>kkl web server response</title></head><body>"
					+ "<h1>welcome liweihai come back</h1></body></html>");
			response=response.println(info.toString());
			response.pushToClient(200);
			
			response.close();
		} catch (IOException e) {
			System.out.println("client connection server exception");
			e.printStackTrace();
		}
		
	}
	
	private void stop() {
		IoCloseUtil.closeAllIo(is,br);
	}
}
