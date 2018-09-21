package singleton;

public class TestA {

	public static void main(String[] args) {

		A a = new A();
		A b = new A();

		a.a = 10;

		System.out.println(A.a);
		System.out.println(b.a);
	}

}
