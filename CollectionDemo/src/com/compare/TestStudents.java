package com.compare;

public class TestStudents {

	public static void main(String[] args) {

		Student A = new Student(1, "李斌", 18);
		Student B = new Student(2, "李华", 20);
		
		if(A.compareTo(B)>0)
			System.out.println("A>B");
		else if(A.compareTo(B)<0)
			System.out.println("A<B");
		else {
			System.out.println("A=B");
		}
	}

}
