package com.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class testHashSet {

	public static void main(String[] args) {

		Set set= new HashSet<>(10);
		set.add("123");
		set.add("acb");
		set.add("xyz");
		set.add("kkk");
		set.add("kkk");
		set.add("kkk");
		
		set.remove("123");
		for(Object s: set){
			System.out.println(s);
		}
		System.out.println();
		
		Iterator it = set.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		System.out.println();
		
		for (Iterator it2 = set.iterator(); it2.hasNext();) {
			System.out.println(it2.next());
			
		}
	}

}
