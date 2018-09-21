package com.reflect.A;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestReflect {

	@Test
	public void testReflect1() throws Exception{

		//导入class的方法 3种
		Class clazz = Class.forName("com.reflect.A.Person");
		System.out.println(clazz);

		Class clazz1 = new Person().getClass();
		System.out.println(clazz1);

		Class clazz2 = Person.class;		
		System.out.println(clazz2);

	}

	//反射出无参构造方法
	@Test
	public void testReflect2() throws Exception{
		//导入class
		Class clazz = Class.forName("com.reflect.A.Person");
		//反射出构造方法
		Constructor c = clazz.getConstructor(null);
		//调用该构造方法
		Person p = (Person) c.newInstance(null);

		System.out.println(p);

	}

	//反射出有参构造方法
	@Test
	public void testReflect3() throws Exception{
		//导入class
		Class clazz = Class.forName("com.reflect.A.Person");
		//反射出构造方法
		Constructor c = clazz.getConstructor(String.class);
		//调用该构造方法
		Person p = (Person) c.newInstance("奉孝");

		System.out.println(p);

	}

	//反射出私有的构造方法
	@Test
	public void testReflect4() throws Exception{
		//导入class
		Class clazz = Class.forName("com.reflect.A.Person");
		//反射出构造方法
		Constructor c = clazz.getDeclaredConstructor(String.class, int.class,String.class);
		//暴力反射
		c.setAccessible(true);
		//调用该构造方法
		Person p = (Person) c.newInstance("林星",25,"女");

		System.out.println(p);

	}

	//反射出无参的实例方法
	@Test
	public void testReflect5() throws Exception{
		//导入class
		Class clazz = Class.forName("com.reflect.A.Person");
		//反射出构造方法
		Method method = clazz.getMethod("func1", null);
		//调用该实例方法
		Person p = (Person) clazz.getConstructor().newInstance(null);

		method.invoke(p, null);

		System.out.println(p);				
	}

	//反射出有参的实例方法
	@Test
	public void testReflect6() throws Exception{
		//导入class
		Class clazz = Class.forName("com.reflect.A.Person");
		//反射出构造方法
		Method method = clazz.getMethod("func1", List.class);
		//调用该实例方法
		Person p = new Person();

		method.invoke(p, new ArrayList());

		System.out.println(p);				
	}

	//多参数的实例方法
	@Test
	public void testReflect7() throws Exception{
		//导入class
		Class clazz = Class.forName("com.reflect.A.Person");
		//反射出构造方法
		Method method = clazz.getMethod("func1", String.class,int.class,int[].class);

		method.invoke(new Person(), "白羽",89, new int[]{15,67,9});
	}

	//反射静态的方法
	@Test
	public void testReflect8() throws Exception{
		//导入class
		Class clazz = Class.forName("com.reflect.A.Person");
		//反射出构造方法
		Method method = clazz.getMethod("func1", String.class);

		method.invoke(null, "Star");

	}

	//反射私有的方法
	@Test
	public void testReflect9() throws Exception{
		//导入class
		Class clazz = Class.forName("com.reflect.A.Person");
		//反射出构造方法
		Method method = clazz.getDeclaredMethod("func1", int.class);
		//暴力反射
		method.setAccessible(true);

		method.invoke(new Person(), 100);

	}

	//反射字段
	@Test
	public void testReflectA() throws Exception{
		//导入class
		Class clazz = Class.forName("com.reflect.A.Person");
		//反射出字段
		Field field = clazz.getField("age");
		//调用该实例方法
		Person p = new Person();

		Class class1=field.getType();
		System.out.println(class1);

		int aaa = 99;
		field.set(p, aaa);

		System.out.println(p);						
	}

	//反射私有字段
	@Test
	public void testReflectB() throws Exception{
		//导入class
		Class clazz = Class.forName("com.reflect.A.Person");
		//反射出字段
		Field field = clazz.getDeclaredField("name");			
		//暴力反射
		field.setAccessible(true);
		//调用该实例方法
		Person p = (Person) clazz.getConstructor().newInstance(null);

		Class class1=field.getType();
		System.out.println(class1);

		String aaaString = "荀彧";
		if(class1.equals(aaaString.getClass()))
			field.set(p, aaaString);

		System.out.println(p);

	}
}
