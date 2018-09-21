package singleton;

public class TestB {

	public static void main(String[] args) {
		SingletonA a1 = SingletonA.getSingletonA();
		SingletonA a2 = SingletonA.getSingletonA();

		a1.a = 10;
		System.out.println(a2.a);
		
		System.out.println(a1.equals(a2));
	}

}
