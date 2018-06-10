package cn.org.kkl.version08.xmlResolve;

public class Persion {
	
	private String name;
	
	private int age;
	
	private char gender;
	
	private String career;

	public Persion() {
		super();
	}

	public Persion(String name, int age, char gender, String career) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.career = career;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getCareer() {
		return career;
	}

	public void setCareer(String career) {
		this.career = career;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
