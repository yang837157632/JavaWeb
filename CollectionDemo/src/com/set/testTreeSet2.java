package com.set;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class testTreeSet2 {
	public static void main(String[] arg) {
		Set<Student> set = new TreeSet<Student>();
		//增加
		set.add(new Student(1, "aaa", 18));
		set.add(new Student(2, "bbb", 14));
		set.add(new Student(3, "ccc", 11));
		set.add(new Student(4, "ddd", 21));
		set.add(new Student(5, "eee", 28));
		
		Student stu5=new Student(5, "eee", 28);	
		set.remove(stu5);
		
		ArrayList al=new ArrayList();
		al.addAll(set);
		
		for (int i = 0; i < al.size(); i++) {
			 System.out.println(al.get(i));	
		}		
	}
}
