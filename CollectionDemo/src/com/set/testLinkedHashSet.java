package com.set;

import java.util.LinkedHashSet;

public class testLinkedHashSet {

	public static void main(String[] args) {
		LinkedHashSet<String> set1 = new LinkedHashSet<>();		
		set1.add("aaa");
		set1.add("bbb");
		set1.add("eee");
		set1.add("ccc");
		set1.add("ddd");		
		set1.add("eee");				
		System.out.println(set1);

		LinkedHashSet<Student> set2 = new LinkedHashSet<>();
		set2.add(new Student(1, "aaa", 18));
		set2.add(new Student(2, "bbb", 14));
		set2.add(new Student(5, "eee", 28));		
		set2.add(new Student(3, "ccc", 11));
		set2.add(new Student(4, "ddd", 21));
		System.out.println(set2);

	}
}
