package com;

import Insert.NoWorkTools;
import Shuju.Mydata;

public class Test {
	public static void main(String[] args) {
//		DepartmentTools s=new DepartmentTools();
//		MajorTools s=new MajorTools();
//		TeacherTools s=new TeacherTools();
//		ClassTools s=new ClassTools();
//		CompanyTools s=new CompanyTools();
//		StudentTools s=new StudentTools();
//		WorkTools s=new WorkTools();
//		NoWorkTools s=new NoWorkTools();
//		
//		Thread t = new Thread(s);
//		t.start();
		
		for(int i=1;i<22;i++){
			System.out.println("update s_department set xyjs='本学院师资队伍强大' where id='"+i+"';");
		}
	}
}
