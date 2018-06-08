package cn.org.kkl.version02;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;

import javax.swing.text.AbstractDocument.BranchElement;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class Server {
	
	private ServerSocket server;
	
	private Socket client;
	
	public static void main(String[] args) {
		new Server().start();
	}
	
	public void start() {
		try {
			server=new ServerSocket(8888);
			receive();
		} catch (IOException e) {
			System.out.println("server port is occupancy");
			e.printStackTrace();
		}
	}
	
	private void receive() {
		try {
			client=server.accept();
			BufferedReader br=new BufferedReader(new InputStreamReader(client.getInputStream()));
			char[] data =new char[2048];
			int len=br.read(data);
			String requestInfo=new String(data, 0, len).trim();
			System.out.println(requestInfo);
			
		} catch (IOException e) {
			System.out.println("client connection server exception");
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 可以读取到post请求的请求参数 
	 */
	private void receive3() {
		try {
			client=server.accept();
			byte[] data=new byte[20480];
			int len=client.getInputStream().read(data);
			String requestInfo=new String(data, 0, len).trim();
			System.out.println(requestInfo);
		} catch (IOException e) {
			System.out.println("client connection server exception");
			e.printStackTrace();
		}
	}
	
	
	private void receive2() {
		try {
			client=server.accept();
			InputStream is = client.getInputStream();
			BufferedReader bf=new BufferedReader(new InputStreamReader(client.getInputStream()));
			StringBuilder sb = new StringBuilder();
			char[] msg=new char[1024];
			while((msg=bf.readLine().toCharArray()).length>0) {
				sb.append(msg);
				sb.append("\r\n");
			}
			String reqeustInfo=sb.toString().trim();
			System.out.println(reqeustInfo);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("client Connection server exception");
		}
	}
	
	private void receive1() {
		try {
			client=server.accept();
			BufferedReader bf=new BufferedReader(new InputStreamReader(client.getInputStream()));
			StringBuilder sb = new StringBuilder();
			String msg=null;
			while((msg=bf.readLine()).length()>0) {
				sb.append(msg);
				sb.append("\r\n");
				if(msg==null) {
					break;//此处无法读取post请求参数
				}
			}
			String requestInfo = sb.toString().trim();
			System.out.println(requestInfo);
			
		} catch (IOException e) {
			System.out.println("client connection server exception");
			e.printStackTrace();
		}
	}
	
	public void stop() {
		
	}

}
