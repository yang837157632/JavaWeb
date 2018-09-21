package com.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class testArraylist {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		
		//增加
		list.add("122");
		list.add("78");

		list.add("22");
		list.add("sdjl");
		list.add("dsaf");
		list.add("asd");
//		System.out.println(list);
		
		//删除
//		list.clear();
		
//		list.remove(0);
//		list.remove("78");
		
		//修改
//		list.set(2, "33");
		
		//查询
		//get、contains、indexOf返回该元素出现的位置，若无则返回-1
//		System.out.println(list.indexOf("22"));
//		System.out.println(list.indexOf("33"));	
		
		//第一种徧历
//		for (int i = 0; i < list.size(); i++) {
//			System.out.print(list.get(i)+"\t");			
//		}

		//第二种
//		for (String str : list) {
//			System.out.print(str+" ");
//		}
		
		//第三种	迭代器
//		Iterator<String> it = list.iterator();		
//		while(it.hasNext()){
//			System.out.print(it.next()+" ");
//		}
		
		//第四种
		for (Iterator it = list.iterator(); it.hasNext(); ) {
			System.out.println(it.next());			
		}
	}

}
