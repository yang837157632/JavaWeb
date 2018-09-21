package StudentManagement;

public class Student {
	private int sid;
	private String name;
	private int age;
	private String sex;
	private String province;
	private int tuition;
	
	public Student() {
		super();
		// TODO 自动生成的构造函数存根
	}
	//constructor
	public Student(int sid, String name, int age, String gander,
			String province, int tuition) {
		super();
		this.sid = sid;
		this.name = name;
		this.age = age;
		this.sex = gander;
		this.province = province;
		this.tuition = tuition;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setSname(String name) {
			this.name = CharactorTool.convertUTF8(name);
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String gander) {
		this.sex = gander;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
			this.province =CharactorTool.convertUTF8(province);
	}

	public int getTitution() {
		return tuition;
	}

	public void setTitution(int tuition) {
		this.tuition = tuition;
	}

	@Override
	public String toString() {
		return "Student [学生ID=" + sid + ", \t姓名=" + name + ", \t年龄=" + age
				+ ", \t性别=" + sex + ", \t来至=" + province
				+ "省 , \t工资=" + tuition + "]";
	}
	
	
	
}

