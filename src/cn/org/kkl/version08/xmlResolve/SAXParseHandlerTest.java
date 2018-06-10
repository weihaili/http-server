package cn.org.kkl.version08.xmlResolve;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * 存储对象
 * @author Admin
 *
 */
public class SAXParseHandlerTest extends DefaultHandler {
	
	private List<Persion> persions;
	public List<Persion> getPersions() {
		return persions;
	}

	private Persion persion;
	private String tag;//记录标签名
	
	@Override
	public void startDocument() throws SAXException {
		System.out.println("处理文档开始");
		persions=new ArrayList<Persion>();
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.println("开始处理一个元素"+qName);
		if(!qName.isEmpty()) {
			tag=qName;
		}
		if("persion".equalsIgnoreCase(qName)) {
			persion=new Persion();
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		System.out.println("解析的数据");
		System.out.println(new String(ch,start,length));
		if("name".equalsIgnoreCase(tag)) {
			persion.setName(new String(ch,start,length));
		}
		if("age".equalsIgnoreCase(tag)) {
			persion.setAge(Integer.parseInt(new String(ch,start,length)));
		}
		if("gender".equalsIgnoreCase(tag)) {
			persion.setGender(ch[0]);
		}
		if ("career".equalsIgnoreCase(tag)) {
			persion.setCareer(new String(ch,start,length));
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println("处理一个元素结束"+qName);
		if("persion".equalsIgnoreCase(qName)) {
			this.persions.add(persion);
		}
		tag=null;
	}
	
	@Override
	public void endDocument() throws SAXException {
		System.out.println("处理文档结束");
	}






}
