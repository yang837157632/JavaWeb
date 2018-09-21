public class TestNoname {
	static String name  = "土狼";
	public static void main(String[] args) {	

		new Animal() {
			@Override
			public void shout() {				
				System.out.println(TestNoname.this.name+" 嗚嗚~~~~~");
			}
		}.shout();
	}
}
