
package proxy_dynamic;

import java.lang.reflect.Proxy;

public class TestB {

	public static void main(String[] args) {

		MySport p = new MyYdy();

		MyProxy mp = new MyProxy(p);

		Object newProxyInstance = Proxy.newProxyInstance(p.getClass()
				.getClassLoader(), p.getClass().getInterfaces(), mp);

		MySport r = (MySport) newProxyInstance;

		r.doSport();
	}

}
