package com.reflect.A;

public class ClassDemo {

	public static void main(String[] args) {
		//对象名.getClass()
		Employee employee=new Employee("王儁", 52);
		Class<?> classType = employee.getClass();
		System.out.println(classType);
		System.out.println(classType.getName());
		System.out.println(classType.getSuperclass().getName());
		System.out.println();
		
		//类名.class
		Class<?> classType2=Employee.class;
		System.out.println(classType2.getName());
		System.out.println(classType2.getSuperclass().getName());
		System.out.println();
		
		//使用Class.forName();
		try {
			Class<?> classType3=Class.forName("com.reflect.A.Employee");
			System.out.println(classType3.getName());
			System.out.println(classType3.getSuperclass().getName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println();
		
		//获取基本数据类型的Class对象
		Class<?> classType4=int.class;
		System.out.println(classType4.getName());
//		System.out.println(classType4.getSuperclass().getName());	//此句编译无误，运行有错
		System.out.println();
		
		//通过基本数据类型的包装类来获取对应的基本数据类型所对应的Class对象		
		Class<?> classType5=Double.TYPE;
		System.out.println(classType5.getName());
//		System.out.println(classType5.getSuperclass().getName());	//此句编译无误，运行有错
		System.out.println();
		
		Class<?> classType6=Double.class;
		System.out.println(classType6.getName());
		System.out.println(classType6.getSuperclass().getName());
		System.out.println();
		
		Class<?> classType7=Integer.class;
		System.out.println(classType7.getName());
		System.out.println(classType7.getSuperclass().getName());
	}

}

class Employee {
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

}
