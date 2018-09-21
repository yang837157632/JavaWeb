package com.zr.Demo;

import java.io.File;

public class FileDemo {

	public static void main(String[] args) {
		// 创建File对象
		//相对路径
		File file = new File("src\\com\\zr\\Demo\\FileDemo.java");
		//绝对路径
		//File file = new File("D:\\work\\src");
		
		//文件是否存在
		boolean e = file.exists();
		System.out.println("exists="+e);
		
		//是否是文件
		boolean f = file.isFile();
		System.out.println("isFile="+f);
		
		//是否是目录
		boolean d = file.isDirectory();
		System.out.println("isDirectory="+d);
		
		//获得文件名
		String fname = file.getName();
		System.out.println("fname="+fname);
		
		//获得文件的相对路径
		String path = file.getPath();
		System.out.println("path="+path);
		
		//获得文件的绝对路径
		String apath = file.getAbsolutePath();
		System.out.println("apath:"+apath);

		File file1 = new File("src\\com\\zr\\Demo\\Demo.docx");
		File file2 = new File("src\\com\\zr\\Demo\\Demo.txt");
		//文件改名
		boolean flag=file1.renameTo(file2);
		System.out.println(flag);
		
		//删文件
		file2.delete();
	}

}
