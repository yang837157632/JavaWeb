package com.iotek.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionAPIDemo {

	public static void main(String[] args)throws Exception {
		//获取Employee这个类所关联的Class对象
		Class<?> classType = Class.forName("com.iotek.reflection.Employee");
		
		//通过反射机制来构造一个Employee的实例对象(默认调用无参数的构造方法)
		Employee employee=(Employee)classType.newInstance();
		System.out.println(employee);
		System.out.println();
		
		//调用指定的构造方法来构造对象(无参数构造方法)
		Constructor<?> constructor1 = classType.getConstructor(new Class[]{});
		Employee employee1=(Employee)constructor1.newInstance(new Object[]{});
		System.out.println(employee1);
		System.out.println();
		
		//调用指定的构造方法来构造对象(带参数构造方法)
		Constructor<?> constructor2 = classType.getConstructor(new Class[]{String.class,int.class});
		Employee employee2=(Employee)constructor2.newInstance(new Object[]{"张三",30});
		System.out.println(employee2);
		System.out.println();
		
		//获取Class对象所指定的所有方法,包括私有的.
		Method []methods = classType.getDeclaredMethods();
		for(Method method:methods){
			System.out.println(method.getName()+"--"+method.getModifiers()+"--"+method.getReturnType());
		}
		System.out.println();
		
		//获取Class对象多指定的方法,包括私有的
		Method method1 = classType.getDeclaredMethod("toString", new Class[]{});
		System.out.println(method1.getName());
		//方法的调用
		String desc=(String)method1.invoke(employee, new Object[]{});
		System.out.println(desc);
		System.out.println();
		
		Method method2 = classType.getDeclaredMethod("work", new Class[]{});
		System.out.println(method2.getName());
		method2.setAccessible(true);
		//方法的调用
		method2.invoke(employee, new Object[]{});
		System.out.println();
		
		//获取Class对象所指定的属性,包括私有的
		Field field = classType.getDeclaredField("name");
		field.setAccessible(true);
		field.set(employee, "李四");
		System.out.println(field.get(employee));		
	}
}

class Employee {
	
	public Employee(){
		System.out.println("无参数构造方法");
	}
	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Employee(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + "]";
	}
	
	private void work(){
		System.out.println("working...");
	}

}
