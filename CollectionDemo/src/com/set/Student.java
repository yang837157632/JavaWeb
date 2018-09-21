package com.set;

public class Student implements Comparable<Student> {

	int id;
	String name;
	int age;

	public Student(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student){
			Student stu = (Student) obj;
			if (this.id == stu.id && this.name.equals(stu.name)
					&& this.age == stu.age)
				return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return (name + age + id).hashCode();
	}

//	@Override	
//	若为Comparable则使用此方法
//	public int compareTo(Object o) {
//		Student stu = (Student) o;
//		if (this.age > stu.age)
//			return 1;
//		else if (this.age < stu.age)
//			return -1;
//		else 
//			return 0;
//	}

	@Override
	public int compareTo(Student o) {
		if (this.age > o.age)
			return 1;
		else if (this.age < o.age)
			return -1;
		else 
			return 0;
	}

}
