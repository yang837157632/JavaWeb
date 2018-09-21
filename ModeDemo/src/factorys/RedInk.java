package factorys;

public class RedInk implements Ink {

	@Override
	public String color() {
		return "Red";
	}

	@Override
	public void use() {
		System.out.println("用红颜色的墨水，写字或者，画画。。。");
	}

}
