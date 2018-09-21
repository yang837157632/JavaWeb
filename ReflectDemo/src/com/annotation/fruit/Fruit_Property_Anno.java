package com.annotation.fruit;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented

@Retention(RetentionPolicy.RUNTIME)

@Target(ElementType.FIELD)

public @interface Fruit_Property_Anno {
	
	public String color();
	public double weight();
	public String address();

}
