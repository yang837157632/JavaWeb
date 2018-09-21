
public class Test1 {

	public static void main(String[] args) {

		OuterClass outer = new OuterClass();
		OuterClass.InnerClass myInnerClass = outer.new InnerClass();
		System.out.println(myInnerClass.addAge());
		outer.test();
	}

}
