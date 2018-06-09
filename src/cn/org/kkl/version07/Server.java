package cn.org.kkl.version07;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	private ServerSocket server;
	
	private Socket client;
	
	private boolean isShutdown=false;
	
	
	public static void main(String[] args) {
		Server kklServer=new Server();
		kklServer.start();
		kklServer.stop();
		System.exit(0);
	}
	
	private void stop() {
		isShutdown=true;
		IoCloseUtil.closeSeoket(server);
	}

	public void start() {
		start(8889);
	}
	
	public void start(int port) {
		try {
			server=new ServerSocket(port);
			receive();
		} catch (IOException e) {
			System.out.println("server port is occupancy");
			e.printStackTrace();
			stop();
		}
	}

	private void receive() {
		try {
			client=server.accept();
			while(!isShutdown) {
				new Thread(new Dispatcher(client)).start();
			}
		} catch (IOException e) {
			System.out.println("server read client reqestInfo exception");
			e.printStackTrace();
			stop();
		}
	}
}
