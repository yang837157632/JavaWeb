
public class testStatic {

	public static void main(String[] args) {

		OuterClass.StaticInnerClass myClass=new OuterClass.StaticInnerClass("li4");
		System.out.println(myClass.name);
	}
}
