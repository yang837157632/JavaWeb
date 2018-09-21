
package proxy_dynamic;

import java.lang.reflect.Proxy;

public class TestA {

	public static void main(String[] args) {

		Rent p = new Person();

		MyProxy mp = new MyProxy(p);

		Object newProxyInstance = Proxy.newProxyInstance(p.getClass()
				.getClassLoader(), p.getClass().getInterfaces(), mp);

		Rent r = (Rent) newProxyInstance;

		r.pay(1000);
	}
}
