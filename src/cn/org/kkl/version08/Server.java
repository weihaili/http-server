package cn.org.kkl.version08;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	private ServerSocket server;
	
	private boolean isShutdown=false;
	
	private int port=8889;
	
	
	public static void main(String[] args) {
		Server kklServer=new Server();
		kklServer.start();
		//System.exit(0);
	}
	
	private void stop() {
		isShutdown=true;
		IoCloseUtil.closeSeoket(server);
	}

	public void start() {
		start(port);
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
			while(!isShutdown) {
				new Thread(new Dispatcher(server.accept())).start();
			}
		} catch (IOException e) {
			System.out.println("server read client reqestInfo exception");
			e.printStackTrace();
			stop();
		}
	}
}
