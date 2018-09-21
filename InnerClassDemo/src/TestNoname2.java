public class TestNoname2 {
	public static void main(String[] args) {
		Dog dog=new Dog();		
		dog.shout();

		class Wolf extends Animal{
			@Override
			public void shout(){
				System.out.println(" 嗚嗚~~~~~");
			}
		}
		
//		外部类不能直接访问内部类的成员，必须首先要建立内部类的对象才可访问。
		Wolf wolf = new Wolf();
		wolf.shout();
	}
}
