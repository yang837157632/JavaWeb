
package proxy_static;

public class MyProxy implements Rent {

	Rent p;

	public MyProxy(Rent r) {
		p = r;
	}

	public double pay(double payMoney) {
		payMoney = payMoney * 2;

		p.pay(payMoney);
		return payMoney;
	}

}
