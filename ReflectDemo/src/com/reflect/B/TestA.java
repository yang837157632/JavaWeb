
package com.reflect.B;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestA<E, T> {

	E e;

	public int a;

	public static void main(String[] args) {

//		 根据内存中person的实例对象，反向获得person的类信息
//		private变量不可用此种方法
		Person object = getObject(new Person());
		System.out.println();
		 
		 
		Animal object2 = getObject2(new Animal());
		System.out.println();

		
		ArrayList<Map> am = new ArrayList<Map>();
		for (int i = 0; i < 10; i++) {
			Map map = new HashMap<String, Object>();
			map.put("username", "张" + i);
			map.put("password", i + "");
			map.put("age", 10 + i);
			am.add(map);
		}
		List<User> list = getList(new User(), am);
		System.out.println();

		ArrayList<Map> am2 = new ArrayList<Map>();
		for (int i = 0; i < 5; i++) {
			Map map = new HashMap<String, Object>();
			map.put("name", "王" + i);
			map.put("age", 10 + i);
			am2.add(map);
		}
		List<Person> list1 = getList(new Person(), am2);

		System.out.println("*****");
	}

	public static <T> List<T> getList(T t, Collection<Map> cm) {
		ArrayList<Map> al = new ArrayList<Map>();
		List<T> arry = new ArrayList<T>();
		al.addAll(cm);
		Class c1 = t.getClass();
		for (int i = 0; i < al.size(); i++) {
			Map map = al.get(i);
			try {
				Field[] declaredFields = c1.getDeclaredFields();
				T newInstance = (T) c1.newInstance();
				for (int j = 0; j < declaredFields.length; j++) {
					String name = declaredFields[j].getName();
					// Class type = declaredFields[i].getType();
					Object object = map.get(name);
					Method[] declaredMethods = c1.getDeclaredMethods();
					for (int k = 0; k < declaredMethods.length; k++) {
						String name2 = declaredMethods[k].getName()
								.toLowerCase();
						String testM = ("set" + name).toLowerCase();
						if (name2.equals(testM)) {
							declaredMethods[k].invoke(newInstance, object);
						}
					}
				}
				arry.add(newInstance);
				System.out.println(newInstance);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return arry;
	}

	/***
	 * 通过方法域反射封装数据
	 * 
	 * @auth xjb
	 * @date 2016年7月26日 下午3:22:54
	 * @param a
	 * @return
	 */
	public static <A> A getObject2(A a) {
		Class c1 = a.getClass();

		try {
			Field declaredField = c1.getDeclaredField("age");
			Method m = c1.getMethod("setAge", int.class);
			System.out.println(declaredField);
			System.out.println(m);
			m.invoke(a, 100);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(a);
		return a;
	}

	/**
	 * 通过field域对对象实例进行数据封装
	 * 
	 * @auth xjb
	 * @date 2016年7月26日 下午3:12:35
	 * @param a
	 * @return
	 */
	public static <A> A getObject(A a) {
		// 该方法里需要判断输入的对象，是否有一个age的属性，如果有，将age的属性赋值为100;
		// 等同于a.age = 100,private变量不适用

		Class c1 = a.getClass();

		Field[] declaredFields = c1.getDeclaredFields();

		for (int i = 0; i < declaredFields.length; i++) {
			String name = declaredFields[i].getName();
			System.out.println(name);
			if (name.equals("age")) {
				try {
					declaredFields[i].setAccessible(true);
					declaredFields[i].setInt(a, 100);					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println(a);
		return a;
	}

}
