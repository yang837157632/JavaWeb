package com.iotek.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class CopyObjectDemo {

	public static void main(String[] args) {
		// 2,生成一个学生对象(被复制的那个对象,源对象)
		Student stu = new Student(1, "张三", 30);
		try {
			Student stu2=(Student)ObjectCopyUtil.copyObj(stu);
			System.out.println("赋值对象成功!");
			System.out.println(stu2.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}

/**
 * 这是一个Copy对象的工具类,内部提供了一个Copy对象的方法,接受源对象.
 * 
 * @author video
 *
 */
class ObjectCopyUtil {
	public static Object copyObj(Object obj) throws Exception {
		// 3.获取Student对象所对应类型的Class对象(也就是Student这个类所对应的Class对象)
		Class<?> classType = obj.getClass();
		// 4.通过Class对象的newInstance方法来构建一个目标对象.
		Object objRes = classType.newInstance();
		// 5.获取Class对象的get和Set方法
		for (Field field : classType.getDeclaredFields()) {
			/*// 得到属性所对应的get和set方法
			String getMethodName = "get"
					+ field.getName().substring(0, 1).toUpperCase()
					+ field.getName().substring(1);// getId
			String setMethodName = "set"
					+ field.getName().substring(0, 1).toUpperCase()
					+ field.getName().substring(1);// setId
			// 调用源对象的get方法获取属性值
			Method getMethod = classType.getDeclaredMethod(getMethodName,
					new Class[] {});
			Object value = getMethod.invoke(obj, new Object[] {});
			// 调用目标对象的set方法来给属性赋值
			Method setMethod = classType.getDeclaredMethod(setMethodName,
					new Class[] { field.getType() });
			setMethod.invoke(objRes, new Object[] { value });*/
			
			//直接获取源对象属性的值
			field.setAccessible(true);
			Object value = field.get(obj);
			field.set(objRes, value);			
		}
		return objRes;
	}
}

// 1声明一个学生类
class Student {
	private int id;
	private String name;
	private int age;

	public Student() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public Student(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
}
