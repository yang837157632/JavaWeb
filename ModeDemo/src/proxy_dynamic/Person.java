
package proxy_dynamic;

public class Person implements Rent {

	public double pay(double payMoney) {

		System.out.println("您应付的租金为" + payMoney);

		return payMoney;
	}
}
