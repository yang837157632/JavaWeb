package factorys;

public class InkFactory {

	public static Ink getInk(String type) {
		if (type.equals("red")) {
			return new RedInk();
		} else if (type.equals("black")){
			return new BlackInk();
		} else {
			return null;
		}
	}

}
