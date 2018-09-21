package com.compare;

import java.util.Arrays;
import java.util.Comparator;

public class TestStudents3 {

	public static void main(String[] args) {

		Student[] school= new Student[4];		
		school[0] = new Student(1, "libin", 18);
		school[1] = new Student(2, "libin1", 18);
		school[2] = new Student(3, "张强", 15);
		school[3] = new Student(4, "安华", 8);
		
		Arrays.sort(school, new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				Student stu1 = (Student)o1;
				Student stu2 = (Student)o2;
				
				if(stu1.getAge()>stu2.getAge())
					return 1;
				else if(stu1.getAge()<stu2.getAge())
					return -1;
				else
					return stu1.getName().compareTo(stu2.getName());
			}
		});
		
		for(int i=0;i<school.length;i++){
			System.out.println(school[i]);
		}
	}

}
