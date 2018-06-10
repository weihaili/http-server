package cn.org.kkl.version08.xmlResolve;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class SAXParseTest {

	public static void main(String[] args) throws ParserConfigurationException, SAXException {
		//获得解析工厂
		SAXParserFactory factory=SAXParserFactory.newInstance();
		// 从工厂中获得解析器
		SAXParser parser=factory.newSAXParser();
		//加载document,注册处理器
		
		SAXParseHandlerTest test = new SAXParseHandlerTest();
		try {
			parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("cn/org/kkl/version08/xmlResolve/persion.xml"), test);
		} catch (IOException e) {
			System.out.println("load document exception or assign handler exception");
			e.printStackTrace();
		}
		
		List<Persion> persions = test.getPersions();
		for (Persion persion : persions) {
			System.out.println(persion.getAge()+persion.getName()+persion.getCareer());
		}

	}

}
