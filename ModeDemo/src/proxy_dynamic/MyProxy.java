
package proxy_dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyProxy implements InvocationHandler {

	Object p;

	public MyProxy(Object r) {
		p = r;
	}

	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {

		System.out.println("代理对象执行之前。。。");

		if (args != null && args.length > 0) {
			Object object = args[0];

			double d = (Double) object;

			Double dd = d * 2;

			args[0] = dd;
		}

		method.invoke(p, args);

		System.out.println("代理对象执行之后。。。");
		return 0;
	}

}
