package cn.org.kkl.version01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class Server {
	private ServerSocket server;
	
	private Socket client;
	
	public static void main(String[] args) {
		Server server=new Server();
		server.start();
	}
	
	/**
	 * start up method
	 */
	public void start() {
		try {
			server = new ServerSocket(8888);
			this.receive();
		} catch (IOException e) {
			System.out.println("server port is occupancy");
			e.printStackTrace();
		}
		
	}
	
	/**
	 * receive client connection
	 */
	private void receive() {
		try {
			client = server.accept();
			//receive client request information
			String msg=null;
			StringBuilder sb=new StringBuilder();
			BufferedReader bf=new BufferedReader(new InputStreamReader(client.getInputStream()));
			while ((msg=bf.readLine()).length()>0) {
				sb.append(msg);
				sb.append("\r\n");
				if(null==msg) {
					break;
				}
			}
			//receive client`s final request information
			String requestInfo=sb.toString().trim();
			
			System.out.println(requestInfo);
			
		} catch (IOException e) {
			System.out.println("server get client connection exception");
			e.printStackTrace();
		}
		
	}
	
	/**
	 * stop server service
	 */
	public void stop() {
		
	}

}
