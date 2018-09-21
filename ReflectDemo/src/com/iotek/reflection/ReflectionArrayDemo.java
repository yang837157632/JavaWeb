package com.iotek.reflection;

import java.lang.reflect.Array;

public class ReflectionArrayDemo {

	public static void main(String[] args) throws Exception {
		//创建一个一维数组(String)
		Class<?> classType = Class.forName("java.lang.String");
		Object array = Array.newInstance(classType, 5);
		Array.set(array, 3, "abc");
		System.out.println(Array.get(array, 1));
		System.out.println(Array.get(array, 3));
		System.out.println();
		
		//创建一个二维数组(3行3列)
		int [] dimens={3,3};
		Object array2 = Array.newInstance(int.class, dimens);
		Object arrayObj = Array.get(array2, 2);//获取第三行(就是一个一维数组)
		Array.setInt(arrayObj, 2, 10);//给指定数组位置的元素赋上新值
		int [][] arr=(int [][])array2;
		System.out.println(arr[1][2]);	
		System.out.println(arr[2][2]);		
	}
}
