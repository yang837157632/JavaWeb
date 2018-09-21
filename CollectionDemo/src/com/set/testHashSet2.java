package com.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Set;

public class testHashSet2 {

	public static void main(String[] args) {

		Set set=new HashSet();		
		set.add(new Student(1, "Aa", 17));
		set.add(new Student(2, "bb", 11));
		set.add(new Student(3, "cc", 18));
		
		Student stu= new Student(4, "dd", 19);		
		set.add(stu);
		System.out.println("stu1 hashcode:"+stu.hashCode());
		Student stu2 = new Student(4, "dd", 19);
		set.add(stu2);
		System.out.println("stu2 hashcode:"+stu2.hashCode());		
		
		Iterator it = set.iterator();		
		while(it.hasNext()){
			Object next = it.next();
			System.out.println(next);
		}		
	}
}
