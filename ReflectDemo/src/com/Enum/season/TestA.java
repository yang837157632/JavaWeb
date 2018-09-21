package com.Enum.season;

public class TestA {
	
	public static void main(String[] args) {
		
		Seasons spring=Seasons.Spring;
		int order=spring.getOrder();
		String desc=spring.getDesc();
		System.out.println(order+"\t"+desc);
		
		Seasons autumn=Seasons.Autumn;
		int order2=autumn.getOrder();
		autumn.setDesc("秋天月满人园");
		String desc2=autumn.getDesc();
		System.out.println(order2+"\t"+desc2);
	}

}
