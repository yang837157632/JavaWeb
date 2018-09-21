package com.compare;

import java.util.Arrays;

public class TestStudents2 {

	public static void main(String[] args) {

		Student[] school= new Student[4];		
		school[0] = new Student(1, "李斌", 18);
		school[1] = new Student(2, "李华", 20);
		school[2] = new Student(3, "张强", 15);
		school[3] = new Student(4, "安华", 8);
		Arrays.sort(school);			//默认升序	
		for(int i=0;i<school.length;i++){
			System.out.println(school[i]);
		}
		
		int[] a={3,7,6,2,4,5};
		Arrays.sort(a);
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]);
		}
		
	}

}
