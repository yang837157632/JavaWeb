package factorys;

public class BlackInk implements Ink {

	@Override
	public String color() {
		// TODO Auto-generated method stub
		return "黑色墨水";
	}

	@Override
	public void use() {
		System.out.println("用黑颜色的墨水，写字或者，画画。。。");
	}

}
