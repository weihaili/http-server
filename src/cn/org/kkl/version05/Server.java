package cn.org.kkl.version05;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	private ServerSocket server;
	
	private Socket client;
	
	private InputStream is;
	
	private Response response;
	
	public static void main(String[] args) {
		Server kklServer=new Server();
		kklServer.start();
		kklServer.stop();
		System.exit(0);
	}
	
	private void stop() {
		IoCloseUtil.closeStream(is);
		response.close();
	}

	private void start() {
		try {
			server=new ServerSocket(8889);
			receive();
		} catch (IOException e) {
			System.out.println("server port is occupancy");
			e.printStackTrace();
		}
	}

	private void receive() {
		byte[] flush=new byte[20480];
		try {
			client=server.accept();
			is=client.getInputStream();
			int len=is.read(flush);
			String requestInfo=new String(flush,0,len).trim();
			System.out.println(requestInfo);
			
			//response
			response=new Response(client.getOutputStream());
			StringBuilder info=new StringBuilder();
			info.append("<html><head><title>kkl server response</title></head><body><h1>welcome liweihai come back</h1></body></html>");
			response=response.println(info.toString());
			response.pushToClient(404);
			
		} catch (IOException e) {
			System.out.println("server read client reqestInfo exception");
			e.printStackTrace();
		}
	}
}
