package cn.org.kkl.version08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import sun.applet.resources.MsgAppletViewer;

public class Test {
	
	public static String msgInfo="POST /index.html?name=liweihai&pwd=123456 HTTP/1.1\r\n" + 
			"Host: localhost:8889\r\n" + 
			"Connection: keep-alive\r\n" + 
			"Content-Length: 36\r\n" + 
			"Cache-Control: max-age=0\r\n" + 
			"Upgrade-Insecure-Requests: 1\r\n" + 
			"Origin: null\r\n" + 
			"Content-Type: application/x-www-form-urlencoded\r\n" + 
			"User-Agent: Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.62 Safari/537.36\r\n" + 
			"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8\r\n" + 
			"Accept-Encoding: gzip, deflate, br\r\n" + 
			"Accept-Language: zh-CN,zh;q=0.9\r\n" + 
			"\r\n"
			+"name=fads&pwd=dfasdf&fav=&fav=";
	
	public static final String CRLF="\r\n";
	
	public static final String BLANK=" ";

	public static void main(String[] args) {
		String firstLineStr=msgInfo.substring(0, msgInfo.indexOf(CRLF));
		System.out.println(firstLineStr);
		
		String method= firstLineStr.substring(0,firstLineStr.indexOf(BLANK));
		System.out.println(method);
		
		String[] temp=firstLineStr.split(BLANK);
		System.out.println(Arrays.toString(temp));
		System.out.println(temp[0]);
		System.out.println(temp[1]);
		System.out.println(temp[2]);
		
		System.out.println(temp[1].substring(0, temp[1].indexOf("?")));
		System.out.println(temp[1].substring(temp[1].indexOf("?")+1));
		
		String params=temp[1].substring(temp[1].indexOf("?")+1);
		
		String[] paramArr=params.split("&");
		System.out.println(Arrays.toString(paramArr));
		
		for (String str : paramArr) {
			String[] arrTemp=str.split("=");
			System.out.println(arrTemp[0]+":"+arrTemp[1]);
		}
		
		String postParams=msgInfo.substring(msgInfo.lastIndexOf(CRLF)).trim();
		System.out.println(postParams);
		String[] arrParams=postParams.split("&");
		System.out.println(Arrays.toString(arrParams));
		
		String str="";
		System.out.println(str.trim());
		
		String info="name=&pwd=123&fav=";
		
		StringTokenizer token = new StringTokenizer(info,"&");
		while(token.hasMoreTokens()) {
			String string=token.nextToken();
			String[] kVArr=string.split("=");
			if(1==kVArr.length) {
				kVArr=Arrays.copyOf(kVArr, 2);
				kVArr[1]=null;
			}
			System.out.println(Arrays.toString(kVArr));
		}
		List<String> list=new ArrayList<String>();
		
		
		
	}
	

}
