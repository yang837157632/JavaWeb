public class OuterWolf {
	String name  = "土狼";
	
	public void test() {
		new Animal() {
			@Override
			public void shout() {				
				System.out.println(OuterWolf.this.name+" 嗚嗚~~~~~");
			}
		}.shout();		
	}
}
