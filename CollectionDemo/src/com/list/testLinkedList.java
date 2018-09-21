package com.list;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.ListIterator;

import com.set.Student;

public class testLinkedList {

	public static void main(String[] args) {

		LinkedList list=new LinkedList();
		
		list.add(new Student(1, "Aa", 17));
		list.add(new Student(2, "bb", 11));
		list.add(new Student(3, "cc", 18));
		list.add(new Student(4, "dd", 19));
		
		list.removeLast();
		
		ListIterator it = list.listIterator();		
		while(it.hasNext()){
			Object next = it.next();
			System.out.println(next);
		}
		
		while(it.hasPrevious()){
			System.out.println("==>"+it.previous());
		}		
	}
}
