package com.list;

import java.util.ArrayList;
import java.util.Iterator;

import com.set.Student;

public class testArrayList2 {

	public static void main(String[] arg) {
		ArrayList<Student> list = new ArrayList<>();
		//增加
		list.add(new Student(1, "aaa", 18));
		list.add(new Student(2, "bbb", 14));
		list.add(new Student(3, "ccc", 11));
		list.add(new Student(4, "ddd", 21));
		list.add(new Student(5, "eee", 28));
		
		Student stu5=new Student(5, "eee", 28);
		
		list.remove(stu5);
		for (int i = 0; i < list.size(); i++) {
			 System.out.println(list.get(i));			
		}
		
		System.out.println(list.get(2));		
	}

}
