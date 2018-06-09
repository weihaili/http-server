package cn.org.kkl.version05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Request {
	//CRLF
	public static final String CRLF="\r\n";
	
	//BLANK
	public static final String BLANK=" ";
	
	//?
	public static final String QUESTION_MARK="?";
	
	//&
	public static final String SINGLE_AND="&";
	
	//=
	public static final String EQUAL_SIGN="=";
	
	//request method
	private String method;
	
	//request resource
	private String url;
	
	//request parameter
	private Map<String, List<String>> parameterMap;
	
	//server get client information
	private String requestInfo;
	
	private InputStream is;
	
	public Request() {
		method="";
		url="";
		requestInfo="";
		parameterMap = new HashMap<String,List<String>>();
	}
	
	public Request(InputStream is){
		this();
		this.is=is;
		byte[] flush=new byte[20480];
		int len=0;
		try {
			len = is.read(flush);
			requestInfo=new String(flush, 0, len).trim();
		} catch (IOException e) {
			System.out.println("server get client request information exception");
			e.printStackTrace();
			return;
		}
		
		paseRequestInfo();
	}

	public Request(Socket client){
		this();
		char[] flush=new char[10240];
		int len=0;
		try {
			this.is=client.getInputStream();
			len=new BufferedReader(new InputStreamReader(is)).read(flush);
			requestInfo=new String(flush, 0, len).trim();
		} catch (IOException e) {
			System.out.println("server get client request information exception");
			e.printStackTrace();
			return;
		}
		paseRequestInfo();
	}
	
	/**
	 * analysis requestInfo
	 */
	private void paseRequestInfo() {
		if(requestInfo.isEmpty()) {
			System.out.println("requestInfo is null,please check");
			return;
		}
		
		/**
		 * ==============================================
		 * 从接收到的requstInfo的首行中，获取到请求方式（method）,请求路径即请求资源路径（url）
		 * 若是get请求，获取到存在的请求参数
		 * 若是post请求，则在请求正文中获取到存在的请求参数
		 * ==============================================
		 */
		String paramStr="";//接收请求参数
		String firstLineStr=requestInfo.substring(0, requestInfo.indexOf(CRLF));
		String[] temp=firstLineStr.split(BLANK);
		method=temp[0];
		String urlStr=temp[1];
		if(method.isEmpty()) {
			return;
		}else {
			if(urlStr.isEmpty()) {
				return;
			}
			if("get".equalsIgnoreCase(method)) {
				if(urlStr.contains(QUESTION_MARK)) {
					url=urlStr.substring(0, urlStr.indexOf(QUESTION_MARK));
					String tempParams=urlStr.substring(urlStr.indexOf(QUESTION_MARK)+1);
					String[] paramsArr=tempParams.split(SINGLE_AND);
					for (String str : paramsArr) {
						String[] arrTemp=str.split(EQUAL_SIGN);
						if(!parameterMap.containsKey(arrTemp[0])) {
							List<String> list=new ArrayList<String>();
							list.add(arrTemp[1]);
							parameterMap.put(arrTemp[0], list);
						}else{
							List<String> list=parameterMap.get(arrTemp[0]);
							list.add(arrTemp[1]);
						}
					}
				}
			}else if("post".equalsIgnoreCase(method)) {
				String paramsStr=requestInfo.substring(requestInfo.lastIndexOf(CRLF));
				if(!paramsStr.isEmpty()) {
					paramsStr.trim();
					String[] postParams=paramsStr.split(SINGLE_AND);
					for (String postTemp : postParams) {
						List<String> list = new ArrayList<String>();
						String[] postArr=postTemp.split(EQUAL_SIGN);
						if(parameterMap.containsKey(postArr[0])) {
							list=parameterMap.get(postArr[0]);
							list.add(postArr[1]);
						}
						list.add(postArr[1]);
						parameterMap.put(postArr[0], list);
					}
				}
			}
			url=urlStr;
		}
		
		
	}

}
