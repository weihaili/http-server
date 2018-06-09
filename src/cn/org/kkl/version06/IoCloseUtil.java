package cn.org.kkl.version06;

import java.io.Closeable;
import java.io.IOException;

public class IoCloseUtil {
	
	public static void closeStream(Closeable ...io) {
		for (Closeable stream : io) {
			try {
				if(null!=stream) {
					stream.close();
				}
			} catch (IOException e) {
				System.out.println("closeStream exception");
			}
		}
	}
}
