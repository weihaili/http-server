package cn.org.kkl.version08.reflect;
/**
 * 获取类的类类型，类的元数据，类的字节码文件
 * 获取方法有三种：
 * 1. 通过对象，调用其父类Object的getClass（）方法获取到该对象的类的类类型
 * 2. 通过类.class 获取到类的类类型
 * 3. 通过Class.forName("完整的类路径");
 * 同类型的对象公用一个类类型，即仅有一个元数据，.class文件
 * @author Admin
 *
 */
public class ReflectTest {

	public static void main(String[] args) {
		String str="kkl";
		
		try {
			Class class2=str.getClass();
			Class class1=String.class;
			Class class3=Class.forName("java.lang.String");
			
			System.out.println(class1==class2);
			System.out.println(class2==class3);
			System.out.println(class1==class3);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}

/**
 * 当获取到一个类的元数据后，可以调用和查看该类中的任何已经存在的方法和属性
 * @author Admin
 *
 */
class ReflectMethodInvokeTest{
	public static void main(String[] args) {
		try {
			Class<?> cls=Class.forName("java.lang.String");
			String str=(String) cls.newInstance();//使用此方法创建对象需要确保空构造器的存在，否则创建对象异常。
			System.out.println(str.getClass()==cls);
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
