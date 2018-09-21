//		内部类可以直接访问外部类的所有成员，包括私有的成员。
//		外部类不能直接访问内部类的成员，必须首先要建立内部类的对象才可访问。
//		注意：局部内部类中，访问包含此类的方法中的变量时，这个变量需要用final修饰。

public class OuterClass {
	//属性
	//成员变量、字段field
	private String name="outer's name";
	private int age;

	//成员内部类
	class InnerClass{
		private String name;
		private int age;
		//static int xxx;
		int addAge(){
			OuterClass.this.print();
			return ++OuterClass.this.age;//使用外部类的成员属性
		}
	}

	//静态内部类
	static class StaticInnerClass{
		public String name="zhang3";
		public StaticInnerClass(){ }
		public StaticInnerClass(String name){
			this.name=name;
		}
	}

	public OuterClass() {
		super();
	}
	
	public OuterClass(String name, int age) {
		super();
		this.name = name;
		this.age = age;
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

	//实例方法、具体方法、成员方法
	public void print(){
		System.out.println("name="+name);
	}
	
	//静态方法、类方法
	public static void sayHello(){
		System.out.println("hello, Outter class");
	}
	
	public void test(){
		//局部变量
		final int myNum = 100;
		//方法内部类、局部内部类
		class LocalInnerClass{
			private String name = "inner's name";
			void print(){

				System.out.println("这里是局部内部类"+myNum);
				System.out.println("这里外部类的属性name="+OuterClass.this.name);

			}
		}
		LocalInnerClass local = new LocalInnerClass();
		local.print();
	}
}
