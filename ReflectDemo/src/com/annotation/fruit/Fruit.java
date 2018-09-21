package com.annotation.fruit;

@Fruit_Anno(fruitname="apples")
public class Fruit {
	
	public String type;
	public String data;
	
	@Fruit_Property_Anno(address = "上海", color = "red", weight = 3.5)
	public String property;

}
