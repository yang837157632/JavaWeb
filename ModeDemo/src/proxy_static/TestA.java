
package proxy_static;

public class TestA {

	public static void main(String[] args) {

		Rent p = new Person();

		MyProxy myProxy = new MyProxy(p);

		myProxy.pay(1000);

	}

}
