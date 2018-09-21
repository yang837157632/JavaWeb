package com.annotation.fruit;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class TestA {
	
	public static void main(String[] args) throws Exception{
		Fruit fruit=new Fruit();
		Class<?> clazz=fruit.getClass();
		Fruit_Anno anno1=clazz.getAnnotation(Fruit_Anno.class);
		System.out.println(anno1.fruitname());
		
		Field field=clazz.getDeclaredField("property");
		Fruit_Property_Anno anno2=field.getAnnotation(Fruit_Property_Anno.class);
		Annotation[] annos=field.getAnnotations();
		System.out.println(anno2.address()+"\t"+anno2.color()+"\t"+anno2.weight());
		
	}

}
