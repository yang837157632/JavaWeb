package com.reflect.A;

import java.util.List;

public class Person {

	private String name = "郭嘉";
	public  int age = 37;
	public String sex ="男";
	
	//构造方法
	public Person(){
		
	}
	
	public Person(String name){
		this.name = name;
	}
	
	public Person(String name ,int age){
		this.name = name;
		this.age = age;
	}
	
	private Person(String name ,int age, String sex){
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	
	//方法定义
	//无参的实例方法
	public void func1(){
		System.out.println("无参的实例方法");
	}
	
	//有参的实例方法
	public void func1(List list){
		System.out.println("有参的实例方法");
	}
	
	//多参数的实例方法
	public void func1(String name,int age, int[] arr){
		System.out.println("多参的实例方法");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	//静态的方法
	public static void func1(String name){
		System.out.println("静态方法");
		System.out.println("name="+name);		
	}
	
	//私有的方法
	private static void func1(int name){
		System.out.println("私有方法");
		System.out.println("name="+name);		
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}
	
}