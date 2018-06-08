package cn.org.kkl.version04;

import java.io.Closeable;
import java.io.IOException;

public class IoCloseUtil {
	
	public static void closeAllIo(Closeable ... io) {
		for (Closeable stream : io) {
			try {
				if(null!=stream) {
					stream.close();
				}
			} catch (IOException e) {
				System.out.println("close stream exception");
				e.printStackTrace();
			}
		}
	}

}
