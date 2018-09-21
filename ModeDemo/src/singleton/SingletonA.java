
package singleton;

public class SingletonA {

	public int a = 0;

	private static SingletonA sa;// 懒汉式单例

	private SingletonA() {
		System.out.println("SingletonA 被实例化 。。。");
	}

	public static SingletonA getSingletonA() {
		if (sa == null) {
			sa = new SingletonA();
		}
		return sa;
	}

}
