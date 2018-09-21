package com.annotation.fruit;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented

//注解的生效范围,必须项
@Retention(RetentionPolicy.RUNTIME)

//注解的使用位置,必须项
//TYPE	FIELD	METHOD	PARAMETER	CONSTRUCTOR	LOCAL_VARIABLE	ANNOTATION_TYPE	PACKAGE
@Target(ElementType.TYPE)

public @interface Fruit_Anno {
	
	public String fruitname();

}
